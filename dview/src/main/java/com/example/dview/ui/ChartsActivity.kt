package com.example.dview.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityChartsBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.BarData
import dora.widget.BarDataset
import dora.widget.BarEntry
import dora.widget.CurveData
import dora.widget.CurveDataSet
import dora.widget.CurveEntry
import dora.widget.chart.component.Legend

@Route(path = ARouterPath.ACTIVITY_CHARTS)
class ChartsActivity : BaseActivity<ActivityChartsBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_charts
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityChartsBinding) {
        val legend = Legend()
        legend.type = Legend.LegendType.CIRCLE
        legend.xAxisOffset = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35f,
            resources.displayMetrics)
        legend.yAxisOffset = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f,
            resources.displayMetrics)
        val dataSet = CurveDataSet(label = "K", mode = CurveDataSet.Mode.CURVE)
        dataSet.lineColor = Color.parseColor("#FFFFFF")

        dataSet.addEntry(CurveEntry(52.15f))
        dataSet.addEntry(CurveEntry(57.81f))
        dataSet.addEntry(CurveEntry(44.94f))
        dataSet.addEntry(CurveEntry(77.79f))
        dataSet.addEntry(CurveEntry(42.69f))
        legend.entries.add(dataSet.calcLegend())

        val dataSet2 = CurveDataSet(label = "D", mode = CurveDataSet.Mode.CURVE)
        dataSet2.lineColor = Color.parseColor("#FFFF00")
        dataSet2.addEntry(CurveEntry( 60.59f))
        dataSet2.addEntry(CurveEntry(50.57f))
        dataSet2.addEntry(CurveEntry(43.46f))
        dataSet2.addEntry(CurveEntry( 77.38f))
        dataSet2.addEntry(CurveEntry( 49.6f))
        legend.entries.add(dataSet2.calcLegend())

        val dataSet3 = CurveDataSet(label = "J", mode = CurveDataSet.Mode.CURVE)
        dataSet3.lineColor = Color.parseColor("#F00FFF")
        dataSet3.addEntry(CurveEntry( 35.26f))
        dataSet3.addEntry(CurveEntry( 72.29f))
        dataSet3.addEntry(CurveEntry( 47.89f))
        dataSet3.addEntry(CurveEntry( 78.61f))
        dataSet3.addEntry(CurveEntry(31.93f))
        legend.entries.add(dataSet3.calcLegend())
        binding.kdjChart.setLegend(legend)
        val data = CurveData(dataSet, dataSet2, dataSet3)
        binding.kdjChart.xAxis.axisLineColor = Color.GRAY
        binding.kdjChart.xAxis.axisLineWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            1f, resources.displayMetrics)
        binding.kdjChart.xAxisPlaceholder = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            30f, resources.displayMetrics)
        binding.kdjChart.yAxis.axisLineColor = Color.GRAY
        binding.kdjChart.yAxis.axisLineWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            1f, resources.displayMetrics)
        binding.kdjChart.setData(data)

        val legend2 = Legend()
        legend2.type = Legend.LegendType.SQUARE
        legend2.xAxisOffset = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            35f, resources.displayMetrics)
        legend2.yAxisOffset = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f,
            resources.displayMetrics)
        val dataSet4 = CurveDataSet(label = "RSI6")
        dataSet4.lineColor = Color.parseColor("#FFFFFF")
        dataSet4.addEntry(CurveEntry(17.58f))
        dataSet4.addEntry(CurveEntry(49.69f))
        dataSet4.addEntry(CurveEntry(59.76f))
        dataSet4.addEntry(CurveEntry(41.99f))
        dataSet4.addEntry(CurveEntry(42.68f))
        dataSet4.addEntry(CurveEntry(26.04f))
        dataSet4.addEntry(CurveEntry(39.02f))
        dataSet4.addEntry(CurveEntry(80.93f))
        dataSet4.addEntry(CurveEntry(39.59f))
        dataSet4.addEntry(CurveEntry(67.93f))
        legend2.entries.add(dataSet4.calcLegend())

        val dataSet5 = CurveDataSet(label = "RSI12")
        dataSet5.lineColor = Color.parseColor("#FFFF00")
        dataSet5.addEntry(CurveEntry( 27.85f))
        dataSet5.addEntry(CurveEntry(45.43f))
        dataSet5.addEntry(CurveEntry(53.69f))
        dataSet5.addEntry(CurveEntry( 46.77f))
        dataSet5.addEntry(CurveEntry( 45.79f))
        dataSet5.addEntry(CurveEntry( 36.71f))
        dataSet5.addEntry(CurveEntry(39.58f))
        dataSet5.addEntry(CurveEntry(70.94f))
        dataSet5.addEntry(CurveEntry( 40.94f))
        dataSet5.addEntry(CurveEntry( 59.61f))
        legend2.entries.add(dataSet5.calcLegend())

        val dataSet6 = CurveDataSet(label = "RSI24")
        dataSet6.lineColor = Color.parseColor("#F00FFF")
        dataSet6.addEntry(CurveEntry( 34.19f))
        dataSet6.addEntry(CurveEntry( 42.65f))
        dataSet6.addEntry(CurveEntry( 48.11f))
        dataSet6.addEntry(CurveEntry( 45.51f))
        dataSet6.addEntry(CurveEntry(45.45f))
        dataSet6.addEntry(CurveEntry( 41.17f))
        dataSet6.addEntry(CurveEntry( 41.31f))
        dataSet6.addEntry(CurveEntry( 60.83f))
        dataSet6.addEntry(CurveEntry( 44.87f))
        dataSet6.addEntry(CurveEntry(54.25f))
        legend2.entries.add(dataSet6.calcLegend())
        binding.rsiChart.setLegend(legend2)
        binding.rsiChart.yAxis.drawGridLine = false
        binding.rsiChart.xAxisPlaceholder = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            30f, resources.displayMetrics)
        val data2 = CurveData(dataSet4, dataSet5, dataSet6)
        binding.rsiChart.setData(data2)

        val legend3 = Legend()
        legend3.type = Legend.LegendType.CIRCLE
        legend3.xAxisOffset = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25f,
            resources.displayMetrics)
        val dataSet7 = BarDataset()
        dataSet7.valueTextColor = Color.parseColor("#FFFFFF")
        dataSet7.addEntry(BarEntry(3f, true, true))
        dataSet7.addEntry(BarEntry(2f, true, true))
        dataSet7.addEntry(BarEntry(1f, true, true))
        dataSet7.addEntry(BarEntry(2f, true, false))
        dataSet7.addEntry(BarEntry(3f, true, false))
        dataSet7.addEntry(BarEntry(1f, true, true))
        dataSet7.addEntry(BarEntry(-1f, true, true))
        dataSet7.addEntry(BarEntry(-2f, true, true))
        dataSet7.addEntry(BarEntry(-3f, true, true))
        dataSet7.addEntry(BarEntry(-4f,   true, true))
        dataSet7.addEntry(BarEntry(-3f, true, false))
        dataSet7.addEntry(BarEntry(-2f,  true, false))
        val data3 = BarData(dataSet7)
        binding.macdChart.xAxis.axisLineColor = Color.GRAY
        binding.macdChart.xAxis.axisLineWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            1f, resources.displayMetrics)
        binding.macdChart.yAxis.axisLineColor = Color.GRAY
        binding.macdChart.yAxis.axisLineWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            1f, resources.displayMetrics)
        binding.macdChart.yAxis.drawGridLine = false
        binding.macdChart.yAxis.sideScaleValueCount = 4
        binding.macdChart.setData(data3)
    }
}