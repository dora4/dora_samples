package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityRsaBinding
import dora.BaseActivity
import dora.util.SecurityUtils
import kotlinx.android.synthetic.main.activity_rsa.*

/**
 * 基于RSA非对称加密。
 */
@Route(path = ARouterPath.ACTIVITY_RSA)
class RsaActivity : BaseActivity<ActivityRsaBinding?>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_rsa
    }

    override fun initData(savedInstanceState: Bundle?) {
        //生成公钥私钥键值对
        val keyPair = SecurityUtils.generateRSAKeyPair(1024)
        //从map中获取公钥
        val publicKey = keyPair["publicKey"]
        //从map中获取私钥
        val privateKey = keyPair["privateKey"]
        tv_rsa_key_pair.text = "生成一对秘钥\n\n公钥：${publicKey}\n\n私钥：${privateKey}\n\n"
        btn_rsa_next_step.setOnClickListener {
            val text = "Dora1234567890"
            val encryptByPublic = SecurityUtils.encryptByPublic(publicKey, text)
            val decryptByPrivate = SecurityUtils.decryptByPrivate(privateKey, encryptByPublic)
            tv_rsa_key_pair.append("等待加密的字符串${text}\n公钥加密后：${encryptByPublic}\n" +
                    "私钥解密后：${decryptByPrivate}")
        }
    }
}