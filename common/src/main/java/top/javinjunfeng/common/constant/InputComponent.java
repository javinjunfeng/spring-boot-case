package top.javinjunfeng.common.constant;

/**
 * 输入框类型枚举
 *
 * Created by zhongjunkai on 18/10/26.
 */
public enum InputComponent {

    SELECTOR("select"),
    INPUT("input"),
    TEXTAREA("textarea"),
    DATE("date"),
    DATETIME("datetime"),
    CHECKBOX("checkbox"),
    RADIO("radio")
    ;
    String code;

    InputComponent(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
