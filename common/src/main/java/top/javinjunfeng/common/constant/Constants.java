package top.javinjunfeng.common.constant;

/**
 * Created by zhongjunkai on 17/11/27.
 */
public class Constants {

    public static final String SESSION_SECURITY_CODE = "sessionSecCode";

    //需要认证的路径前缀
    public static final String AUTH_PATH = "auth";

    //不需要认证的路径前缀
    public static final String OPEN_PATH = "open";

    //验证码
    public static final String AUTH_CODE = "AUTH_CODE:%s";

    /**
     *      浮点类型
     */
    public enum FloatNumber{
        DOUBLE,
        DECIMAL,
        FLOAT
    }

    /**
     *      数据库字段类型 VARCHAR
     */
    public enum VarChar{
        VARCHAR,
        TEXT,
        LONGTEXT,
        CHAR,
        TINYBLOB,
        TINYTEXT,
        BLOB,
        MEDIUMBLOB,
        MEDIUMTEXT,
        LONGBLOB
    }

    /**
     *      数据库字段类型 INTEGER
     */
    public enum Int{
        INTEGER,
        UNSIGNED,
        INT,
        SMALLINT,
        TINYINT,
        MEDIUMINT,
        BIGINT
    }

    /**
     *      数据库存储时间类型
     */
    public enum TimeType{
        DATE,
        TIMESTAMP,
        DATETIME
    }


    /**
     * 数据库数据状态0：有效，1：已删除
     */
    public enum DataStatus {
        ADDED(0), //新增(默认值)
        COMMITTED(1), //提交
        DELETED(2); // 删除

        DataStatus(Integer code){
            this.code = code;
        }

        private Integer code;

        public Integer getCode() {
            return code;
        }
    }

    /**
     *  0启用，1未启用
     */
    public enum StatusEnable{

        ENABLE("0"),
        DISABLE("1");

        private String status;

        StatusEnable(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return this.getStatus();
        }}

    public enum ResultEnums{
        SUCCESS("1", "成功"),
        ERROR("0", "发生异常"),
        UNLOGIN("2", "用户未登陆"),
        FIELD_ERROR("01", "字段不正确"),
        BEEN_REFERENCED_ERROR("02", "被引用，不能删除"),
        PARENT_DONT_EXIST_ERROR("03", "父类不存在"),
        REPEAT_ERROR("04", "值重复");

        private String code;

        private String msg;

        ResultEnums(String code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public enum MonthEnums{
        JAN(0),FEB(1),MAR(2),APR(3),MAY(4),JUN(5),JUL(6),AUG(7),SEP(8),OCT(9),NOV(10),DEC(11);
        private int month;
        MonthEnums(int month){
            this.month = month;
        }

        public int getMonth() {
            return month;
        }

    }

    public enum HandleType{
        HANDLED("handled", "已处理"), UNTREATED("untreated", "未处理");

        HandleType(String code, String msg){
            this.code = code;
            this.msg = msg;
        }

        private String code;

        private String msg;

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public enum FieldFillable {
        YES(0), NO(1);
        private Integer code;

        FieldFillable(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }
    /**
     * 字段是否可为空，1：可为空，0：不能为空
     */
    public enum FieldNullable {
        YES(1), NO(0);

        private Integer code;

        FieldNullable(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 字段是否作为表头
     */
    public enum FieldHeadTag {
        YES(0), NO(1);
        private Integer code;

        FieldHeadTag(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 字段是否可作为搜索条件
     */
    public enum FieldSearchable {
        YES(1), No(0);
        private int code;

        FieldSearchable(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    /**
     * 备份数据操作状态
     */
    public enum BakOldDataStatus {
        UPDATE("update"), DELETE("delete");

        private String op;

        BakOldDataStatus(String op) {
            this.op = op;
        }

        public String getOp() {
            return op;
        }
    }

    /**
     * 角色
     */
    public enum Role {
        ADMIN("管理员", 1), GENERAL("普通用户", 2);

        private String roleName;

        private Integer roleId;

        Role(String roleName, Integer roleId) {
            this.roleId = roleId;
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }

        public Integer getRoleId() {
            return roleId;
        }


    }

}
