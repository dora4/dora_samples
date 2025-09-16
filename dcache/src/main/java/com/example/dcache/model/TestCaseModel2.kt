package com.example.dcache.model

import dora.db.constraint.Id
import dora.db.constraint.NotNull
import dora.db.migration.OrmMigration
import dora.db.table.*
import dora.widget.panel.IMenu
import java.io.Serializable

@Table("test_case_2")
data class TestCaseModel2(
    // @Id注解将自动配置主键，且列名以_id命名
    @Id
    val id: Long = 0,

    @NotNull
    @Column("data_index")
    var index: Int = 0,

    @NotNull
    @Column("boolean_value")
    var booleanVal: Boolean = false,

    @NotNull
    @Column("short_value")
    var shortVal: Short = 0,

    @NotNull
    @Column("int_value")
    var intVal: Int = 0,

    @NotNull
    @Column("long_value")
    var longVal: Long = 0L,

    @NotNull
    @Column("float_value")
    var floatVal: Float = 0.0f,

    @NotNull
    @Column("double_value")
    var doubleVal: Double = 0.0,

    override val isUpgradeRecreated: Boolean = false,
    override val migrations: Array<OrmMigration>? = arrayOf(),
    override val menuName: String? = null

) : OrmTable, IMenu, Serializable