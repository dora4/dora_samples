package com.example.dview.ui

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Shader
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityRotateViewBinding
import dora.util.DensityUtils
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_ROTATE_VIEW)
class RotateViewActivity : BaseActivity<ActivityRotateViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_rotate_view
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityRotateViewBinding) {
        binding.rotateView.setImageBitmap(createDefaultCover(this))
        binding.rotateView.startRotateAnimation()
    }

    /**
     * 创建一个圆形的默认转盘封面。
     */
    private fun createDefaultCover(context: Context): Bitmap {
        // 加载原图
        val bmp = BitmapFactory.decodeResource(context.resources, R.drawable.by_hatsune_miku2)
        // 取原图较小的边作为直径基础，保证居中裁剪为正圆
        val size = minOf(bmp.width, bmp.height)
        val radius = size / 2f

        // 创建输出Bitmap（正方形）
        val output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)

        // 使用BitmapShader裁剪为圆形
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val shader = BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        // 调整Shader偏移，让图片居中显示
        val dx = (bmp.width - size) / 2f
        val dy = (bmp.height - size) / 2f
        val matrix = Matrix()
        matrix.setTranslate(-dx, -dy)
        shader.setLocalMatrix(matrix)
        paint.shader = shader
        // 绘制圆形内容
        canvas.drawCircle(radius, radius, radius, paint)
        // 绘制白色边框
        val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        borderPaint.style = Paint.Style.STROKE
        borderPaint.color = Color.WHITE
        borderPaint.strokeWidth = DensityUtils.DP4.toFloat() // 例如4dp宽的边框
        canvas.drawCircle(radius, radius, radius - borderPaint.strokeWidth / 2, borderPaint)
        return output
    }

    override fun onDestroy() {
        mBinding.rotateView.cancelRotateAnimation()
        super.onDestroy()
    }
}