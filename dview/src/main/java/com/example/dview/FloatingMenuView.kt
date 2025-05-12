package com.example.dview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import com.example.common.Colors
import kotlin.math.*

class FloatingMenuView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private var downX = 0f
    private var downY = 0f
    private var arcCircleGap = 10
    private val labels = arrayOf("A", "B", "C", "D", "E", "F", "G", "H")
    private var centerLabel = "Start"
    private var isDragging = false
    private var touchSlop = 10

    private val paintArc = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Colors.OBSIDIAN_BLACK
    }

    private val paintCenter = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Colors.OBSIDIAN_BLACK
    }

    private val paintText = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textAlign = Paint.Align.CENTER
        textSize = 40f
    }

    private val paintLine = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = Color.WHITE
        strokeWidth = 4f
    }

    private var centerX = 0f
    private var centerY = 0f
    private var outerRadius = 0f
    private var innerRadius = 0f

    var onSectorClick: ((index: Int) -> Unit)? = null
    var onCenterClick: (() -> Unit)? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        touchSlop = ViewConfiguration.get(context).scaledTouchSlop
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val defaultSizeDp = 200
        val density = resources.displayMetrics.density
        val defaultSizePx = (defaultSizeDp * density).toInt()
        val width = resolveSize(defaultSizePx, widthMeasureSpec)
        val height = resolveSize(defaultSizePx, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2f
        centerY = h / 2f
        outerRadius = min(centerX, centerY) - arcCircleGap
        innerRadius = outerRadius / 2.5f
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val rectOuter = RectF(
            centerX - outerRadius,
            centerY - outerRadius,
            centerX + outerRadius,
            centerY + outerRadius
        )

        val rectInner = RectF(
            centerX - innerRadius,
            centerY - innerRadius,
            centerX + innerRadius,
            centerY + innerRadius
        )

        // 画8个扇形块
        for (i in labels.indices) {
            val startAngle = i * 45f - 90f
            canvas.drawArc(rectOuter, startAngle, 45f, true, paintArc)

            // 用“挖空”的方式抠掉中心圆
            paintArc.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            canvas.drawArc(rectInner, startAngle, 45f, true, paintArc)
            paintArc.xfermode = null

            // 画每个按钮的文字
            val midAngle = Math.toRadians((startAngle + 22.5).toDouble())
            val textRadius = (outerRadius + innerRadius) / 2
            val textX = (centerX + textRadius * cos(midAngle)).toFloat()
            val textY = (centerY + textRadius * sin(midAngle)).toFloat() - (paintText.descent() + paintText.ascent()) / 2
            canvas.drawText(labels[i], textX, textY, paintText)

            val lineAngle = Math.toRadians((startAngle + 45f).toDouble()) // 下一块的起始角度
            val startX = centerX + innerRadius * cos(lineAngle).toFloat()
            val startY = centerY + innerRadius * sin(lineAngle).toFloat()
            val stopX = centerX + outerRadius * cos(lineAngle).toFloat()
            val stopY = centerY + outerRadius * sin(lineAngle).toFloat()

            paintLine.color = Color.WHITE
            paintLine.strokeWidth = 4f
            canvas.drawLine(startX, startY, stopX, stopY, paintLine)
        }

        // 最后画中心重置按钮
        canvas.drawCircle(centerX, centerY, innerRadius - 10, paintCenter)
        val centerTextY = centerY - (paintText.descent() + paintText.ascent()) / 2
        canvas.drawText(centerLabel, centerX, centerTextY, paintText)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                downY = event.y
                isDragging = false
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                val dx = event.x - downX
                val dy = event.y - downY
                if (!isDragging && hypot(dx, dy) > touchSlop) {
                    isDragging = true
                }
                return true
            }
            MotionEvent.ACTION_UP -> {
                if (isDragging) {
                    isDragging = false
                    return true // 拖动后不触发点击
                }
                val upX = event.x
                val upY = event.y
                val dx = upX - centerX
                val dy = upY - centerY
                val dist = hypot(dx, dy)
                if (dist <= innerRadius - arcCircleGap) {
                    onCenterClick?.invoke()
                    return true
                } else if (dist <= outerRadius) {
                    val angle = (Math.toDegrees(atan2(dy.toDouble(), dx.toDouble())) + 360) % 360
                    val fixedAngle = (angle + 90) % 360
                    val index = (fixedAngle / 45).toInt()
                    onSectorClick?.invoke(index)
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }
}
