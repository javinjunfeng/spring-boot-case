package top.javinjunfeng.example.dao.dto;

import lombok.Data;

import java.util.List;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/21 5:17 PM
 */
@Data
public class TableInfoDTO {

    /**
     * 表名
     */
    private String tableNameEn;

    /**
     * 表备注
     */
    private String tableNameCn;

    /**
     * 表创建时间
     */
    private String createTime;

    /**
     * 表主键信息
     */
    private List<String> primaryKey;

    /**
     * 字段信息
     */
    private List<FieldInfoDTO> fieldInfo;

}
