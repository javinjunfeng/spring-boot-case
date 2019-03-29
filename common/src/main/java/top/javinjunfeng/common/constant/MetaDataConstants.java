package top.javinjunfeng.common.constant;

/**
 * @Descriptoin: 数据库元数据常量
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/21 5:35 PM
 */
public enum MetaDataConstants {

    /**
     * 表、表名、字段名、备注、是否允许为空0：不能为空，1：可以为空、字段大小、字段类型
     */
    TABLE("TABLE"),TABLE_NAME("TABLE_NAME"),COLUMN_NAME("COLUMN_NAME"),
    REMARKS("REMARKS"), NULLABLE("NULLABLE"),
    COLUMN_SIZE("COLUMN_SIZE"), DATA_TYPE("DATA_TYPE");

    private String columnLabel;

    MetaDataConstants(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    public String getColumnLabel() {
        return columnLabel;
    }
}
