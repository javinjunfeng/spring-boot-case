package top.javinjunfeng.example.dao.dto;

import lombok.Data;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/21 5:16 PM
 */
@Data
public class FieldInfoDTO {

    /**
     * 字段名
     */
    private String fieldNameEn;

    /**
     * 字段类型
     */
    private String fieldType;

    /**
     * 字段备注
     */
    private String fieldNameCn;

    /**
     * 字段长度
     */
    private Integer fieldSize;

    /**
     * 是否可以为空 0：不能为空，1：可以为空
     */
    private Integer nullFlag;

}
