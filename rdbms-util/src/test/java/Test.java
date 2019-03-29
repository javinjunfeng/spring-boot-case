import top.javinjunfeng.rdbms.util.DBUtil;
import top.javinjunfeng.rdbms.util.DataBaseType;
import top.javinjunfeng.rdbms.util.JdbcConnectionFactory;

import java.sql.Connection;
import java.util.List;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/15 6:47 PM
 */

public class Test {
    @org.junit.Test
    public void testConn() {
        DataBaseType DATABASE_TYPE = DataBaseType.MySql;
        String jdbcUrl = "jdbc:mysql://localhost:3306/guiji?useUnicode=true&characterEncoding=utf8&autoReconnect=true&connectTimeout=30000&socketTimeout=60000&rewriteBatchedStatements=true";
        String username = "root";
        String password = "katarina";
        JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory(DATABASE_TYPE, jdbcUrl, username, password);
        String connectionInfo = connectionFactory.getConnectionInfo();
        System.out.println(connectionInfo);
        Connection connecttion = connectionFactory.getConnecttion();
        System.out.println(connecttion);

        List<String> columns = DBUtil.getTableColumnsByConn(DATABASE_TYPE, connectionFactory.getConnecttionWithoutRetry(), "ajj_sajj_aqcx_info", connectionFactory.getConnectionInfo());
        System.out.println(columns);

    }
}
