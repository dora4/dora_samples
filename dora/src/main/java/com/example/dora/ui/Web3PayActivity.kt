package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityWeb3PayBinding
import dora.BaseActivity
import dora.trade.DoraTrade
import dora.util.ToastUtils

@Route(path = ARouterPath.ACTIVITY_WEB3_PAY)
class Web3PayActivity : BaseActivity<ActivityWeb3PayBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_web3_pay
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityWeb3PayBinding) {
        // 1.在Application中初始化支付SDK
        // 2.设置支付结果监听
        DoraTrade.setPayListener(object : DoraTrade.PayListener {
            override fun onPaySuccess() {
                // 支付成功，在此发货商品
                ToastUtils.showShort("支付成功")
            }

            override fun onPayFailure() {
                // 支付失败，一般为点了冷钱包的取消发送
                ToastUtils.showShort("支付失败")
            }
        })
        // 3.连接钱包
        binding.btnConnect.setOnClickListener {
            DoraTrade.connectWallet(this)
        }
        // 4.发起支付
        binding.btnPay.setOnClickListener {
            DoraTrade.pay(
                this,
                "AyAD8J9M0R7H",
                "填写订单信息，便于框架给你弹窗，以让用户知晓正在支付",
                "填写商品详细描述，便于框架给你弹窗，以让用户知晓正在支付",
                "0xfF6FC0F28835F2C1FE23B15fb4488d976B06Dcd9",
                0.01
            )
        }
    }
}