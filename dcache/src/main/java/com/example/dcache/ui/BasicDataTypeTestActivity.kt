package com.example.dcache.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.common.Colors
import com.example.dcache.R
import com.example.dcache.databinding.ActivityBasicDataTypeTestBinding
import com.example.dcache.db.model.TestCaseModel
import com.example.dcache.widget.SwipeMenuPanelItem
import dora.BaseActivity
import dora.db.dao.DaoFactory
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ToastUtils
import dora.widget.panel.MenuPanelItemGroup

@Route(path = ARouterPath.ACTIVITY_BASIC_DATA_TYPE_TEST)
class BasicDataTypeTestActivity : BaseActivity<ActivityBasicDataTypeTestBinding>() {

    private var models: List<TestCaseModel> = arrayListOf()

    override fun getLayoutId(): Int {
        return R.layout.activity_basic_data_type_test
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityBasicDataTypeTestBinding) {
        super.initData(savedInstanceState, binding)
        binding.tvAdd.setOnClickListener {
            val intent = Intent(this, OrmModelEditorActivity::class.java)
            intent.action = "ACTION_ADD"
            intent.putExtra("title", "模型编辑器")
            intent.putExtra("themeColor", Colors.LEAF_GREEN)
            startActivityForResult(intent, 0)
        }
        refreshModels()
    }

    private fun refreshModels() {
        models = DaoFactory.getDao(TestCaseModel::class.java).selectAll()
        mBinding.menuPanel
            .clearAll()
            .addMenuGroup(
            MenuPanelItemGroup(
                items = getMenuPanelItems()
            )
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val model = data?.getSerializableExtra("model") as TestCaseModel
            if (requestCode == 0) {
                if (DaoFactory.getDao(TestCaseModel::class.java).insert(model)) {
                    ToastUtils.showShort("添加成功")
                    setResult(Activity.RESULT_OK)
                    finish()
                } else {
                    ToastUtils.showShort("添加失败")
                }
            }
            if (requestCode == 1) {
                if (DaoFactory.getDao(TestCaseModel::class.java).update(model)) {
                    ToastUtils.showShort("编辑成功")
                    setResult(Activity.RESULT_OK)
                    finish()
                } else {
                    ToastUtils.showShort("编辑失败")
                }
            }
            refreshModels()
        }
    }

    private fun getMenuPanelItems(): Array<SwipeMenuPanelItem> {
        val list = mutableListOf<SwipeMenuPanelItem>()
        models.forEach {
            val item = SwipeMenuPanelItem("", it)
            item.setItemListener(object : SwipeMenuPanelItem.ItemListener {

                override fun onClick(model: TestCaseModel) {
                    val intent = Intent(this@BasicDataTypeTestActivity, OrmModelEditorActivity::class.java)
                    intent.action = "ACTION_UPDATE"
                    intent.putExtra("title", "模型编辑器")
                    intent.putExtra("themeColor", Colors.LEAF_GREEN)
                    intent.putExtra("model", model)
                    startActivityForResult(intent, 1)
                }

                override fun onDelete(model: TestCaseModel, item: SwipeMenuPanelItem) {
                    if (DaoFactory.getDao(TestCaseModel::class.java).delete(model)) {
                        ToastUtils.showShort("删除成功")
                        mBinding.menuPanel.removeItem(item)
                    } else {
                        ToastUtils.showShort("删除失败")
                    }
                }
            })
            list.add(item)
        }
        return list.toTypedArray()
    }
}