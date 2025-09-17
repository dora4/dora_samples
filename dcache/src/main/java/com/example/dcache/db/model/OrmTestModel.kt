package com.example.dcache.db.model

import dora.db.constraint.Default
import dora.db.constraint.Id
import dora.db.constraint.NotNull
import dora.db.constraint.Unique
import dora.db.converter.StringListConverter
import dora.db.migration.OrmMigration
import dora.db.table.Column
import dora.db.table.Convert
import dora.db.table.Ignore
import dora.db.table.OrmTable
import dora.db.table.Since

data class OrmTestModel(
    @Id
    var id: Long = 0,

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

    override val migrations: Array<OrmMigration> = arrayOf(),

) : OrmTable