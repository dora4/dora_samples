package com.example.dora.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityWeb3PayBinding
import com.walletconnect.web3.modal.client.Modal
import dora.BaseActivity
import dora.trade.DoraTrade
import dora.trade.PayUtils
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ToastUtils
import timber.log.Timber

/**
 * 中国大陆用户暂时需要开启VPN才能正常访问。
 */
@Route(path = ARouterPath.ACTIVITY_WEB3_PAY)
class Web3PayActivity : BaseActivity<ActivityWeb3PayBinding>() {

    private var lastTransactionHash: String = ""

    override fun getLayoutId(): Int {
        return R.layout.activity_web3_pay
    }

    companion object {
        const val REQUEST_CODE_TEST_PAY = 0
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_TEST_PAY) {
                // payProxy：基础版密钥，无需填写收款账号，官方代收
                // pay：去中心化，需填写收款账号，直接打到商户账户
                if (DoraTrade.isWalletConnected()) {
                    // 连接上钱包自动调启支付
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
                                Timber.tag(TAG).i("生成支付订单，交易订单号：$orderId")
                            }
                        }
                    )
                }
            }
        }
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityWeb3PayBinding) {
        // 1.在Application中初始化支付SDK
        // 2.设置钱包支付监听
        DoraTrade.setPayListener(object : DoraTrade.PayListener {

            @SuppressLint("SetTextI18n")
            override fun onSendTransactionToBlockchain(orderId: String, transactionHash: String) {
                // 和之前保存的orderId进行比对，确认该笔订单的交易哈希
                lastTransactionHash = transactionHash
                runOnUiThread {
                    binding.tvTransactionHash.text = "交易哈希：$transactionHash"
                    binding.tvTransactionHash.visibility = View.VISIBLE
                    binding.btnQueryTransaction.visibility = View.VISIBLE
                }
                Timber.tag(TAG).d("支付消息上链，确认中，订单号：$orderId，交易哈希：$transactionHash")

            }

            override fun onPayFailure(orderId: String, msg: String) {
                Timber.tag(TAG).d("支付失败，订单号：$orderId，错误信息：$msg")
            }
        })
        // 3.连接钱包
        binding.btnConnect.setOnClickListener {
            DoraTrade.connectWallet(this, REQUEST_CODE_TEST_PAY)
        }
        binding.btnDisconnect.setOnClickListener {
            DoraTrade.disconnectWallet()
            ToastUtils.showShort("断开钱包连接")
        }
        // 4.发起支付
        binding.btnPay.setOnClickListener {
            if (!DoraTrade.isWalletConnected()) {
                ToastUtils.showShort("请先连接钱包")
                return@setOnClickListener
            }
            // payProxy：基础版密钥，无需填写收款账号，官方代收
            // pay：去中心化，需填写收款账号，直接打到商户账户
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
                        Timber.tag(TAG).i("生成支付订单，交易订单号：$orderId")
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