package top.javinjunfeng.rdbms.dto;

import lombok.Data;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/22 3:31 PM
 */
@Data
public class InformationSchemaSchemata {
    private String catalogName;

    private String schemaName;

    private String defaultCharacterSetName;

    private String defaultCollationName;

    private String sqlPath;
}