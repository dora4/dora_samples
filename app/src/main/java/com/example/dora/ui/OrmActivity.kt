package com.example.dora.ui

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath
import com.example.dora.R
import com.example.dora.MessageEvent
import com.example.dora.databinding.ActivityOrmBinding
import com.example.dora.bean.UserEntity
import dora.BaseActivity
import dora.db.Orm
import dora.db.dao.DaoFactory
import dora.db.table.TableManager
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_ORM)
class OrmActivity : BaseActivity<ActivityOrmBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmBinding) {
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}