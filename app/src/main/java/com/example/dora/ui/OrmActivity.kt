package com.example.dora.ui

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityOrmBinding
import com.example.dora.model.UserEntity
import dora.BaseActivity
import dora.db.test.Orm
import dora.db.test.TableManager
import dora.db.test.dao.DaoFactory
import kotlinx.android.synthetic.main.activity_orm.*

@Route(path = ARouterPath.ACTIVITY_ORM)
class OrmActivity : BaseActivity<ActivityOrmBinding>(), View.OnClickListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm
    }

    override fun initData(savedInstanceState: Bundle?) {
        // 正常来说这个是在Application中初始化
        Orm.init(this, "orm_sample")
        // 创表，这个也是在Application中创建比较好
        TableManager.createTable(UserEntity::class.java)
        btn_orm_insert.setOnClickListener(this)
        btn_orm_delete_all.setOnClickListener(this)
    }

    private fun showData() {
        val users = DaoFactory.getDao(UserEntity::class.java).selectAll()
        tv_orm_display.text = ""
        users.iterator().forEach {
            tv_orm_display.append("\n用户名：${it.userName}\n用户ID：${it.userId}\n用户昵称：${it.userAlias}\n好友列表：${it.roster}\n")
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_orm_insert -> {
                val roster = listOf("10001", "10002")
                DaoFactory.getDao(UserEntity::class.java).insert(UserEntity("10000",
                    "jack123", "Jack", roster))
                showData()
            }
            R.id.btn_orm_delete_all -> {
                DaoFactory.getDao(UserEntity::class.java).deleteAll()
                showData()
            }
        }
    }
}