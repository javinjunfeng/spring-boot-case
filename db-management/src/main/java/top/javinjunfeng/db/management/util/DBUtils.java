package top.javinjunfeng.db.management.util;

import com.alibaba.druid.util.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import top.javinjunfeng.common.exception.AbsorbException;
import top.javinjunfeng.common.constant.MetaDataConstants;
import top.javinjunfeng.db.management.dto.FieldInfoDTO;
import top.javinjunfeng.db.management.dto.TableInfoDTO;
import top.javinjunfeng.rdbms.util.DataBaseType;
import top.javinjunfeng.rdbms.util.JdbcConnectionFactory;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static top.javinjunfeng.common.constant.Constants.ResultEnums.ERROR;


/**
 * @Descriptoin: 元数据sql工具类
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/20 12:42 PM
 */
@Slf4j
@Component
@RestController
public class DBUtils {

    private String tablePrefix = "";
    private Connection connection = null;

    /**
     * 获取数据库元数据对象
     *
     * @return
     * @throws SQLException
     */
    private DatabaseMetaData getDatabaseMetaData(DataBaseType dataBaseType, String url, String userName, String password) throws SQLException {
        JdbcConnectionFactory jdbcConnectionFactory = new JdbcConnectionFactory(dataBaseType,url,userName,password);
        connection = jdbcConnectionFactory.getConnecttion();
        return connection.getMetaData();
    }

    /**
     * 展示数据库业务表，展示以tablePrefix开头的所有表信息
     *
     * @return 业务表列表
     */
    public List<String> showBizTables(DataBaseType dataBaseType, String url, String db, String userName, String password) {
        List<String> result = new ArrayList<>();
        try {
            DatabaseMetaData metaData = getDatabaseMetaData(dataBaseType, url, userName, password);
            ResultSet rs = metaData.getTables(null, db, tablePrefix + "%", new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME").toLowerCase();
                result.add(tableName);
            }
        } catch (SQLException e) {
            log.error("获取表信息异常：{}", e);
//            throw new AbsorbException(ERROR.getCode(), "获取表信息发生异常");
        }
        return result;
    }

    /**
     * 展示数据库所有表
     *
     * @return 库表列表
     */
    public List<TableInfoDTO> showTablesInfo(DataBaseType dataBaseType, String url, String db, String userName, String password) {
        List<TableInfoDTO> result = new ArrayList<>();

        try {
            DatabaseMetaData metaData = getDatabaseMetaData(dataBaseType, url, userName, password);
            ResultSet rs = metaData.getTables(null, db, "%", new String[]{MetaDataConstants.TABLE.getColumnLabel()});
            while (rs.next()) {
                TableInfoDTO tableInfoDTO = new TableInfoDTO();

                // 表名
                String tableName = rs.getString(MetaDataConstants.TABLE_NAME.getColumnLabel());
                tableInfoDTO.setTableNameEn(tableName);

                // 获取表的主键
                ResultSet pkSet = metaData.getPrimaryKeys(null, db, tableName);
                ArrayList<String> primarykeys = new ArrayList<>();
                while (pkSet.next()) {
                    // 主键字段
                    String columnName = pkSet.getString(MetaDataConstants.COLUMN_NAME.getColumnLabel());
                    primarykeys.add(columnName);
                }
                tableInfoDTO.setPrimaryKey(primarykeys);

                // 表备注
                String tableNameCn = rs.getString(MetaDataConstants.REMARKS.getColumnLabel());
                tableInfoDTO.setTableNameCn(tableNameCn);

                // 表创建时间
//                String string = rs.getString("CREATE_TIME");
//                System.out.println(string);
                // 表字段信息
                List<FieldInfoDTO> fieldInfoDTOS = showColumns(dataBaseType, url, db, userName, password, tableName);
                tableInfoDTO.setFieldInfo(fieldInfoDTOS);

                result.add(tableInfoDTO);
            }
        } catch (SQLException e) {
            log.error("sql报错，错误是{}", e.getMessage());
        }
        return result;
    }


    /**
     * 查询数据表字段元信息
     *
     * @param tableName
     */
    public List<FieldInfoDTO> showColumns(DataBaseType dataBaseType, String url, String db, String userName, String password, String tableName) {
        List<FieldInfoDTO> result = new ArrayList<>();
        try {
            DatabaseMetaData metaData = getDatabaseMetaData(dataBaseType, url, userName, password);
            System.out.println(metaData);
            ResultSet rs = metaData.getColumns(null, db, tableName, "%");
            while(rs.next()){
                FieldInfoDTO fieldInfoDTO = new FieldInfoDTO();
                String columnName = rs.getString(MetaDataConstants.COLUMN_NAME.getColumnLabel());
                fieldInfoDTO.setFieldNameEn(columnName);
                String remark = rs.getString(MetaDataConstants.REMARKS.getColumnLabel());
                fieldInfoDTO.setFieldNameCn(remark);
                Integer nullable = rs.getInt(MetaDataConstants.NULLABLE.getColumnLabel());
                fieldInfoDTO.setNullFlag(nullable);
                int columnSize = rs.getInt(MetaDataConstants.COLUMN_SIZE.getColumnLabel());
                fieldInfoDTO.setFieldSize(columnSize);
                // 字段SQL类型，可以用于Mybatis的jdbcType
                int dataType = rs.getInt(MetaDataConstants.DATA_TYPE.getColumnLabel());
                fieldInfoDTO.setFieldType(JdbcUtils.getTypeName(dataType));
                result.add(fieldInfoDTO);
            }
        } catch (SQLException e) {
            log.error("获取表字段信息发生异常：{}", e);
            throw new AbsorbException(ERROR.getCode(), "获取字段信息发生异常");
        }
        return result;
    }
}
