package com.example.dcache.db.model

import dora.db.constraint.Default
import dora.db.constraint.Id
import dora.db.constraint.NotNull
import dora.db.constraint.Unique
import dora.db.converter.StringListConverter
import dora.db.dao.OrmDao
import dora.db.migration.OrmMigration
import dora.db.table.*
import dora.widget.panel.IMenu
import java.io.Serializable

class OrmMigration_1_2 : OrmMigration(1, 2) {
    override fun migrate(dao: OrmDao<out OrmTable>): Boolean {
        dao.addColumn("byteVal")
        dao.addColumn("charVal")
        return true
    }
}

@Table("test_case")
data class TestCaseModel(
    // @Id注解将自动配置主键，且列名以_id命名
    @Id
    val id: Long = 0,

    @Since(version = 1)
    @Default("")
    @NotNull
    @Column("string_value")
    var stringVal: String? = null,

    @Since(version = 1)
    @NotNull
    @Column("boolean_value")
    var booleanVal: Boolean = false,

    @Since(version = 2)
    @NotNull
    @Column("byte_value")
    var byteVal: Byte = 0,

    @Since(version = 1)
    @NotNull
    @Column("short_value")
    var shortVal: Short = 0,

    @Since(version = 1)
    @NotNull
    @Column("int_value")
    var intVal: Int = 0,

    @Since(version = 1)
    @NotNull
    @Column("long_value")
    var longVal: Long = 0L,

    @Since(version = 1)
    @NotNull
    @Column("float_value")
    var floatVal: Float = 0.0f,

    @Since(version = 1)
    @NotNull
    @Column("double_value")
    var doubleVal: Double = 0.0,

    @Since(version = 2)
    @NotNull
    @Column("char_value")
    var charVal: Char = 'A',

    /**
     * 跳过映射的属性。
     */
    @Ignore
    @Unique
    @Convert(converter = StringListConverter::class, columnType = String::class)
    @Since(version = 1)
    @Column("string_list_value")
    var stringListVal: List<String>? = null,

    override val isUpgradeRecreated: Boolean = false,

    override val migrations: Array<OrmMigration> = arrayOf(
        OrmMigration_1_2()
    ),
    override val menuName: String? = null

) : OrmTable, IMenu, Serializable