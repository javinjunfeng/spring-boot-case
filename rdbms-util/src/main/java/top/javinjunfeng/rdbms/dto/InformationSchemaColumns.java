package top.javinjunfeng.rdbms.dto;

import lombok.Data;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/22 3:31 PM
 */
@Data
public class InformationSchemaColumns {
    private String tableCatalog;

    private String tableSchema;

    private String tableName;

    private String columnName;

    private Long ordinalPosition;

    private String isNullable;

    private String dataType;

    private Long characterMaximumLength;

    private Long characterOctetLength;

    private Long numericPrecision;

    private Long numericScale;

    private Long datetimePrecision;

    private String characterSetName;

    private String collationName;

    private String columnKey;

    private String extra;

    private String privileges;

    private String columnComment;

    private String columnDefault;

    private String columnType;

    private String generationExpression;
}