package com.example.dcache.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dcache.R
import com.example.dcache.databinding.ActivityOrmConverterBinding
import com.example.dcache.db.model.UserEntity
import dora.BaseActivity
import dora.db.Orm
import dora.db.dao.DaoFactory
import dora.db.table.TableManager
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_ORM_CONVERTER)
class OrmConverterActivity : BaseActivity<ActivityOrmConverterBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_converter
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmConverterBinding) {
        binding.v = this
        // 正常来说这个是在Application中初始化
        Orm.init(this, "orm_sample")
        // 创表，这个也是在Application中创建比较好
        TableManager.createTable(UserEntity::class.java)
    }

    fun insertData() {
        val roster = listOf("10001", "10002")
        DaoFactory.getDao(UserEntity::class.java).insert(
            UserEntity(
                "10000",
                "jack123", "Jack", roster
            )
        )
        showData()
    }

    fun deleteAllData() {
        DaoFactory.getDao(UserEntity::class.java).deleteAll()
        showData()
    }

    private fun showData() {
        val users = DaoFactory.getDao(UserEntity::class.java).selectAll()
        mBinding.tvOrmDisplay.text = ""
        users.iterator().forEach {
            mBinding.tvOrmDisplay.append("\n用户名：${it.userName}\n用户ID：${it.userId}\n用户昵称：${it.userAlias}\n好友列表：${it.roster}\n")
        }
    }
}