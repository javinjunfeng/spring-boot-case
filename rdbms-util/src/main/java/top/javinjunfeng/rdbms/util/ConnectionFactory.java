package top.javinjunfeng.rdbms.util;

import java.sql.Connection;

/**
 * @author zhangjunfeng
 */
public interface ConnectionFactory {

    /**
     * 获取连接，失败重试
     * @return
     */
    public Connection getConnecttion();

    /**
     * 获取连接，失败不重试
     * @return
     */
    public Connection getConnecttionWithoutRetry();

    /**
     * 获取连接信息
     * @return
     */
    public String getConnectionInfo();

}
