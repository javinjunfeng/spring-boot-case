package top.javinjunfeng.example.dao.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "db_info")
public class DbInfo {
    /**
     * 数据源编码
     */
    @Id
    @Column(name = "db_code")
    private Integer dbCode;

    /**
     * 数据源类型
     */
    @Column(name = "db_type")
    private String dbType;

    /**
     * 数据源IP
     */
    @Column(name = "db_ip")
    private String dbIp;

    /**
     * 数据源端口
     */
    @Column(name = "db_port")
    private String dbPort;

    /**
     * 数据库名
     */
    @Column(name = "db_name")
    private String dbName;

    /**
     * 用户名
     */
    @Column(name = "db_username")
    private String dbUsername;

    /**
     * 密码
     */
    @Column(name = "db_password")
    private String dbPassword;

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
     * 获取数据源类型
     *
     * @return db_type - 数据源类型
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * 设置数据源类型
     *
     * @param dbType 数据源类型
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    /**
     * 获取数据源IP
     *
     * @return db_ip - 数据源IP
     */
    public String getDbIp() {
        return dbIp;
    }

    /**
     * 设置数据源IP
     *
     * @param dbIp 数据源IP
     */
    public void setDbIp(String dbIp) {
        this.dbIp = dbIp;
    }

    /**
     * 获取数据源端口
     *
     * @return db_port - 数据源端口
     */
    public String getDbPort() {
        return dbPort;
    }

    /**
     * 设置数据源端口
     *
     * @param dbPort 数据源端口
     */
    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    /**
     * 获取数据库名
     *
     * @return db_name - 数据库名
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * 设置数据库名
     *
     * @param dbName 数据库名
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * 获取用户名
     *
     * @return db_username - 用户名
     */
    public String getDbUsername() {
        return dbUsername;
    }

    /**
     * 设置用户名
     *
     * @param dbUsername 用户名
     */
    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    /**
     * 获取密码
     *
     * @return db_password - 密码
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * 设置密码
     *
     * @param dbPassword 密码
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
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