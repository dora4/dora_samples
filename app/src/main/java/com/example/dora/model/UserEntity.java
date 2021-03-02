package com.example.dora.model;

import java.util.List;

import dora.db.test.OrmTable;
import dora.db.test.PrimaryKeyEntity;
import dora.db.test.PrimaryKeyId;
import dora.db.test.converter.StringListConverter;
import dora.db.test.table.Column;
import dora.db.test.table.Convert;
import dora.db.test.table.Id;
import dora.db.test.table.Table;

/**
 * 所有用TableManager创建的表务必实现OrmTable接口。
 *
 * 注解详解：
 * PrimaryKey -> 设置主键（必须）
 * Id -> 设置主键ID（和PrimaryKey二选一，Id自带更新列名为"_id"，推荐使用）
 * Table -> 设置表名（非必须）
 * Column -> 设置列表（非必须）
 * Ignore -> 忽略成员属性（非必须）
 * Check -> 设置检查约束（非必须）
 * Default -> 设置默认值约束（非必须）
 * Unique -> 设置唯一约束（非必须）
 * NotNull -> 设置非空约束（非必须）
 */
@Table("user")
public class UserEntity implements OrmTable {

    @Id
    private long id;
    @Column("user_id")
    private String userId;
    @Column("user_name")
    private String userName;
    @Column("user_alias")
    private String userAlias;

    /**
     * 复杂数据类型映射到数据库存储，以及读取。
     * converter -> 指定转换器的类型，可自定义
     * columnType -> 指定映射到数据库的类型
     */
    @Convert(converter = StringListConverter.class, columnType = String.class)
    private List<String> roster;

    public UserEntity(String userId, String userName, String userAlias, List<String> roster) {
        this.userId = userId;
        this.userName = userName;
        this.userAlias = userAlias;
        this.roster = roster;
    }

    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public List<String> getRoster() {
        return roster;
    }

    @Override
    public PrimaryKeyEntity getPrimaryKey() {
        return new PrimaryKeyId(id);
    }

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }
}
