package com.example.dcache.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.common.Colors
import com.example.dcache.R
import com.example.dcache.databinding.ActivityComplexDataTypeTestBinding
import com.example.dcache.model.TestCaseModel
import com.example.dcache.model.TestCaseModel3
import com.example.dcache.widget.SwipeMenuPanelItem2
import dora.BaseActivity
import dora.db.dao.DaoFactory
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ToastUtils
import dora.widget.panel.MenuPanelItemGroup

@Route(path = ARouterPath.ACTIVITY_COMPLEX_DATA_TYPE_TEST)
class ComplexDataTypeTestActivity : BaseActivity<ActivityComplexDataTypeTestBinding>() {

    private var models: List<TestCaseModel3> = arrayListOf()

    override fun getLayoutId(): Int {
        return R.layout.activity_complex_data_type_test
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(
        savedInstanceState: Bundle?,
        binding: ActivityComplexDataTypeTestBinding
    ) {
        super.initData(savedInstanceState, binding)
        binding.tvAdd.setOnClickListener {
            val intent = Intent(this, OrmModelEditorActivity::class.java)
            intent.putExtra("title", "模型编辑器")
            intent.putExtra("themeColor", Colors.LEAF_GREEN)
            intent.action = "ACTION_ADD"
            startActivityForResult(intent, 0)
        }
        refreshModels()
    }

    private fun refreshModels() {
        models = DaoFactory.getDao(TestCaseModel3::class.java).selectAll()
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
            val model = data?.let { IntentUtils.getSerializableExtra(it, "model") } as TestCaseModel
            if (requestCode == 0) {
                val model3 = TestCaseModel3()
                model3.model = model
                if (DaoFactory.getDao(TestCaseModel3::class.java).insert(model3)) {
                    ToastUtils.showShort("添加成功")
                    setResult(Activity.RESULT_OK)
                    finish()
                } else {
                    ToastUtils.showShort("添加失败")
                }
            }
            refreshModels()
        }
    }

    private fun getMenuPanelItems(): Array<SwipeMenuPanelItem2> {
        val list = mutableListOf<SwipeMenuPanelItem2>()
        models.forEach {
            val item = SwipeMenuPanelItem2("", it)
            item.setItemListener(object : SwipeMenuPanelItem2.ItemListener {

                override fun onClick(model: TestCaseModel3) {
                }

                override fun onDelete(model: TestCaseModel3, item: SwipeMenuPanelItem2) {
                    if (DaoFactory.getDao(TestCaseModel3::class.java).delete(model)) {
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