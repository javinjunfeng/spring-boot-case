package top.javinjunfeng.db.management.util;

import lombok.Data;
import top.javinjunfeng.common.constant.Constants;

import java.util.List;

/**
 * 字段视图展示类
 *
 * Created by zhongjunkai on 18/10/26.
 */
@Data
public class FieldVO {

    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 字段英文名
     */
    private String fieldNameEn;

    /**
     * 字段中文名
     */
    private String fieldNameCn;

    /**
     * 字段类型
     */
    private String fieldType;

    /**
     * 字段大小
     */
    private String fieldSize;

    /**
     * 是否为空标记，默认值为1(可以为空)
     */
    private Integer nullFlag = Constants.FieldNullable.YES.getCode();

    /**
     * 是否必填标记，默认值为0(必须填写)
     */
    private Integer fillFlag = Constants.FieldFillable.YES.getCode();

    /**
     * 输入框类型
     */
    private String inputType;

    /**
     * 输入框配置类型
     */
    private String configType;

    /**
     * 所属表
     */
    private String belongTable;

    /**
     * 表单ID
     */
    private Integer formId;

    /**
     * 是否可作为搜索条件，0：不可作为搜索条件，1：可作为搜索条件
     */
    private int searchable;

    /**
     * 是否作为列表表头，0：作为列表表头，1：不作为列表表头
     */
    private int headTag;

    /**
     * 配置项，如果输入组件类型是有默认字典值的，则这里使用字典值集合
     */
//    private List<ConfigVo> configValues;


}