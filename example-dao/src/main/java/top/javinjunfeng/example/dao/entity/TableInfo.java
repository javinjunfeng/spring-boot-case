package top.javinjunfeng.example.dao.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "table_info")
public class TableInfo {
    /**
     * 表编码
     */
    @Id
    @Column(name = "table_id")
    private Integer tableId;

    /**
     * 数据源编码
     */
    @Column(name = "db_code")
    private Integer dbCode;

    /**
     * 表名
     */
    @Column(name = "table_name")
    private String tableName;

    /**
     * 表备注
     */
    @Column(name = "table_comment")
    private String tableComment;

    /**
     * 主键字段名,多个主键间以逗号“,”区分
     */
    @Column(name = "key_column")
    private String keyColumn;

    /**
     * 所有字段MD5加密(主键+所有字段：名称+类型+备注)
     */
    @Column(name = "md5_column")
    private String md5Column;

    /**
     * 是否启用（‘1’已启用，‘0’未启用）
     */
    @Column(name = "is_use")
    private String isUse;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 获取表编码
     *
     * @return table_id - 表编码
     */
    public Integer getTableId() {
        return tableId;
    }

    /**
     * 设置表编码
     *
     * @param tableId 表编码
     */
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    /**
     * 获取数据源编码
     *
     * @return db_code - 数据源编码
     */
    public Integer getDbCode() {
        return dbCode;
    }

    /**
     * 设置数据源编码
     *
     * @param dbCode 数据源编码
     */
    public void setDbCode(Integer dbCode) {
        this.dbCode = dbCode;
    }

    /**
     * 获取表名
     *
     * @return table_name - 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置表名
     *
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获取表备注
     *
     * @return table_comment - 表备注
     */
    public String getTableComment() {
        return tableComment;
    }

    /**
     * 设置表备注
     *
     * @param tableComment 表备注
     */
    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    /**
     * 获取主键字段名,多个主键间以逗号“,”区分
     *
     * @return key_column - 主键字段名,多个主键间以逗号“,”区分
     */
    public String getKeyColumn() {
        return keyColumn;
    }

    /**
     * 设置主键字段名,多个主键间以逗号“,”区分
     *
     * @param keyColumn 主键字段名,多个主键间以逗号“,”区分
     */
    public void setKeyColumn(String keyColumn) {
        this.keyColumn = keyColumn;
    }

    /**
     * 获取所有字段MD5加密(主键+所有字段：名称+类型+备注)
     *
     * @return md5_column - 所有字段MD5加密(主键+所有字段：名称+类型+备注)
     */
    public String getMd5Column() {
        return md5Column;
    }

    /**
     * 设置所有字段MD5加密(主键+所有字段：名称+类型+备注)
     *
     * @param md5Column 所有字段MD5加密(主键+所有字段：名称+类型+备注)
     */
    public void setMd5Column(String md5Column) {
        this.md5Column = md5Column;
    }

    /**
     * 获取是否启用（‘1’已启用，‘0’未启用）
     *
     * @return is_use - 是否启用（‘1’已启用，‘0’未启用）
     */
    public String getIsUse() {
        return isUse;
    }

    /**
     * 设置是否启用（‘1’已启用，‘0’未启用）
     *
     * @param isUse 是否启用（‘1’已启用，‘0’未启用）
     */
    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}