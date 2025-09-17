package com.example.dcache.model

import com.example.dcache.db.TestCaseModelConverter
import dora.db.constraint.Id
import dora.db.migration.OrmMigration
import dora.db.table.*
import dora.widget.panel.IMenu
import java.io.Serializable

@Table("test_case_3")
data class TestCaseModel3(

    // @Id注解将自动配置主键，且列名以_id命名
    @Id
    var id: Long = 0,

    @Column("complex_object")
    @Convert(converter = TestCaseModelConverter::class, columnType = String::class)
    var model: TestCaseModel? = null,

    override val isUpgradeRecreated: Boolean = false,
    override val migrations: Array<OrmMigration>? = arrayOf(),
    override val menuName: String? = null

) : OrmTable, IMenu, Serializable