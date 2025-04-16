package com.example.dora.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityWeb3PayBinding
import com.walletconnect.web3.modal.client.Modal
import com.walletconnect.web3.modal.client.Web3Modal
import dora.BaseActivity
import dora.trade.DoraTrade
import dora.trade.PayUtils
import dora.util.ToastUtils

@Route(path = ARouterPath.ACTIVITY_WEB3_PAY)
class Web3PayActivity : BaseActivity<ActivityWeb3PayBinding>() {

    private var lastTransactionHash: String = ""

    override fun getLayoutId(): Int {
        return R.layout.activity_web3_pay
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityWeb3PayBinding) {
        // 1.在Application中初始化支付SDK
        // 2.设置钱包支付监听
        DoraTrade.setPayListener(object : DoraTrade.PayListener {

            override fun onSendTransactionToBlockchain(orderId: String, transactionHash: String) {
                lastTransactionHash = transactionHash
                runOnUiThread {
                    binding.tvTransactionHash.text = "交易哈希：$transactionHash"
                    binding.tvTransactionHash.visibility = View.VISIBLE
                    binding.btnQueryTransaction.visibility = View.VISIBLE
                }
                Log.d(TAG, "支付消息上链，确认中，订单号：$orderId，交易哈希：$transactionHash")

            }

            override fun onPayFailure(orderId: String, errorMsg: String) {
                Log.d(TAG, "支付失败，订单号：$orderId，错误信息：$errorMsg")
            }
        })
        // 3.连接钱包
        binding.btnConnect.setOnClickListener {
            DoraTrade.connectWallet(this)
        }
        // 4.发起支付
        binding.btnPay.setOnClickListener {
            if (Web3Modal.getAccount() == null) {
                ToastUtils.showShort("请先连接钱包")
                return@setOnClickListener
            }
            DoraTrade.payProxy(
                this,
                "eTAIBZuUv0xw",
                "SvuYlqClCezj9UN55PXvHnaESnt62qpJ",
                "测试订单",
                "支付0.01个代币",
                0.01,
                object : DoraTrade.OrderListener {
                    override fun onPrintOrder(
                        orderId: String,
                        chain: Modal.Model.Chain,
                        value: Double
                    ) {
                        // 在这里保存订单号，便于钱包支付完成后得到对应的交易哈希
                        Log.i(TAG, "生成支付订单，交易订单号：$orderId")
                    }
                }
            )
        }
        // 5.查询订单支付状态
        binding.btnQueryTransaction.setOnClickListener {
            Thread {
                val ok = PayUtils.queryTransactionByHash(lastTransactionHash)
                // 如果在确认中，请多点几次
                ToastUtils.showShort("查询上笔支付订单：${if (ok) "成功" else "失败"}")
            }.start()
        }
    }
}