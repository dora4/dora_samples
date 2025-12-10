package com.example.dcache.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dcache.R
import com.example.dcache.databinding.ActivityOrmModelEditorBinding
import com.example.dcache.db.model.TestCaseModel
import com.example.dcache.widget.ToggleButtonEntity
import com.example.dcache.widget.ToggleButtonMenuPanelItem
import dora.BaseActivity
import dora.util.DensityUtils
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ViewUtils
import dora.widget.panel.MenuPanel
import dora.widget.panel.MenuPanelItem
import dora.widget.panel.menu.ButtonMenuPanelItem
import dora.widget.panel.menu.InputMenuPanelItem

@Route(path = ARouterPath.ACTIVITY_ORM_MODEL_EDITOR)
class OrmModelEditorActivity : BaseActivity<ActivityOrmModelEditorBinding>() {

    private var isOpen: Boolean = false
    private var model: TestCaseModel? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_model_editor
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmModelEditorBinding) {
        super.initData(savedInstanceState, binding)
        model = intent.getSerializableExtra("model") as TestCaseModel?
        isOpen = model?.booleanVal ?: false
        binding.menuPanel
            .addMenu(
                InputMenuPanelItem(
                    title = "String",
                    hint = "输入字符串",
                    content = model?.stringVal
                )
            )
            .addMenu(
                ToggleButtonMenuPanelItem(ToggleButtonEntity(
                    "布尔值开关",
                    isOpen,
                    object : ToggleButtonEntity.OnSelectListener {
                        override fun onSelect(
                            item: ToggleButtonMenuPanelItem,
                            select: Boolean
                        ) {
                            isOpen = select
                        }
                    }), "Boolean")
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "短整形",
                    hint = "输入short值",
                    content = model?.shortVal?.toString() ?: "0"
                )
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "整数型",
                    hint = "输入int值",
                    content = model?.intVal?.toString() ?: "0"
                )
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "长整形",
                    hint = "输入long值",
                    content = model?.longVal?.toString() ?: "0"
                )
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "单精度浮点型",
                    hint = "输入float值",
                    content = model?.floatVal?.toString() ?: "0.0"
                )
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "双精度浮点型",
                    hint = "输入double值",
                    content = model?.doubleVal?.toString() ?: "0.0"
                )
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "字节型",
                    hint = "输入byte值",
                    content = model?.byteVal?.toString() ?: "0"
                )
            )
            .addMenu(
                ButtonMenuPanelItem(marginTop = DensityUtils.DP10, menuName = "save", text = "保存",
                    textColor = ContextCompat.getColor(this, com.example.common.R.color.leaf_green))
            )
        binding.menuPanel.setOnPanelMenuClickListener(object : MenuPanel.OnPanelMenuClickListener {

            override fun onMenuClick(
                position: Int,
                view: View,
                menuName: String,
                item: MenuPanelItem
            ) {
                if (menuName == "save") {
                    if (intent.action == "ACTION_UPDATE") {
                        val testCaseModel = model
                        testCaseModel?.stringVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(0,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText
                        )
                        testCaseModel?.booleanVal = isOpen
                        testCaseModel?.shortVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(2,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText
                        ).toShort()
                        testCaseModel?.intVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(3,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText
                        ).toInt()
                        testCaseModel?.longVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(4,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText
                        ).toLong()
                        testCaseModel?.floatVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(5,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText
                        ).toFloat()
                        testCaseModel?.doubleVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(6,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText
                        ).toDouble()
                        testCaseModel?.byteVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(7,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText
                        ).toByte()
                        intent.putExtra("model", testCaseModel)
                    } else {
                        val testCaseModel = TestCaseModel(menuName = MenuPanelItem.generateMenuName())
                        testCaseModel.stringVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(0,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText)
                        testCaseModel.booleanVal = isOpen
                        testCaseModel.shortVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(2,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toShort()
                        testCaseModel.intVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(3,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toInt()
                        testCaseModel.longVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(4,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toLong()
                        testCaseModel.floatVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(5,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toFloat()
                        testCaseModel.doubleVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(6,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toDouble()
                        testCaseModel.byteVal = ViewUtils.getText(binding.menuPanel.getViewByPosition(7,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toByte()
                        intent.putExtra("model", testCaseModel)
                    }
                    setResult(RESULT_OK, intent)
                    finish()
                }
            }
        })
    }
}