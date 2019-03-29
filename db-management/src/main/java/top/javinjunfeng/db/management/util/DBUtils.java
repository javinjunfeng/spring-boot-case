package com.sztech.absorb.core.util;

import com.alibaba.druid.util.JdbcUtils;
import com.sztech.absorb.core.config.BakTableConfiguration;
import com.sztech.absorb.core.config.TableInfoConfiguration;
import com.sztech.absorb.core.dao.SqlPerformer;
import com.sztech.absorb.core.exception.AbsorbException;
import com.sztech.absorb.core.vo.FieldVO;
import com.sztech.absorb.core.vo.FormVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.sztech.absorb.core.constant.Constants.ResultEnums.*;

/**
 * 元数据sql工具类
 *
 * Created by zhongjunkai on 18/10/23.
 */
@Slf4j
@Component
public class DBUtils {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private SqlPerformer sqlPerformer;

    @Value("${biz.database}")
    private String db;

    @Value("${biz.table-prefix}")
    private String tablePrefix;

    @Autowired
    private BakTableConfiguration bakTableConfiguration;

    @Autowired
    private TableInfoConfiguration tableInfoConfiguration;

    /**
     * 获取数据库元数据对象
     *
     * @return
     * @throws SQLException
     */
    private DatabaseMetaData getDatabaseMetaData() throws SQLException {

        // to prevent resource leak
        try(Connection connection = sqlSessionFactory.openSession().getConnection()){
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            return databaseMetaData;
        }
    }

    /**
     * 展示数据库业务表，展示以tablePrefix开头的所有表信息
     *
     * @return 业务表列表
     */
    public List<String> showBizTables() {
        List<String> result = new ArrayList<>();
        try {
            DatabaseMetaData metaData = getDatabaseMetaData();
            ResultSet rs = metaData.getTables(null, db, tablePrefix + "%", new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME").toLowerCase();
                result.add(tableName);
            }
        } catch (SQLException e) {
            log.error("获取表信息异常：{}", e);
            throw new AbsorbException(ERROR.getCode(), "获取表信息发生异常");
        }
        return result;
    }

    /**
     * 展示数据库业务表，展示以tablePrefix开头的所有表信息
     *
     * @return 业务表列表
     */
    public List<FormVO> showBizTablesForm() {
        List<FormVO> result = new ArrayList<>();

        try {
            DatabaseMetaData metaData = getDatabaseMetaData();
            ResultSet rs = metaData.getTables(null, db, tablePrefix + "%", new String[]{"TABLE"});
            while (rs.next()) {
                FormVO formVO = new FormVO();
                //表名
                String tableName = rs.getString("TABLE_NAME").toLowerCase();
                formVO.setFormNameEn(tableName);
                //获取表的主键
                ResultSet pkSet = metaData.getPrimaryKeys(null, "absorb", tableName);
                while (pkSet.next()) {
                    //主键字段
                    String columnName = pkSet.getString("COLUMN_NAME");
                    formVO.setPrimaryKey(columnName);
                }
                result.add(formVO);
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
    public List<FieldVO> showColumns(String tableName) {
        List<FieldVO> result = new ArrayList<>();
        try {
            DatabaseMetaData metaData = getDatabaseMetaData();
            ResultSet rs = metaData.getColumns(null, db, tableName, "%");
            while(rs.next()){
                FieldVO fieldVO = new FieldVO();
                String columnName = rs.getString("COLUMN_NAME");
                fieldVO.setFieldNameEn(columnName);
                String remark = rs.getString("REMARKS");
                fieldVO.setFieldNameCn(remark);
                Integer nullable = rs.getInt("NULLABLE");//0：不能为空，1：可以为空
                fieldVO.setNullFlag(nullable);
                int columnSize = rs.getInt("COLUMN_SIZE");
                fieldVO.setFieldSize(String.valueOf(columnSize));
                int dataType = rs.getInt("DATA_TYPE");//字段SQL类型，可以用于Mybatis的jdbcType
                fieldVO.setFieldType(JdbcUtils.getTypeName(dataType));
                fieldVO.setBelongTable(tableName);
                result.add(fieldVO);
            }
        } catch (SQLException e) {
            log.error("获取表字段信息发生异常：{}", e);
            throw new AbsorbException(ERROR.getCode(), "获取字段信息发生异常");
        }
        return result;
    }

    /**
     * 创建tableName表的备份表,生成的备份表的表名为原表名后加"_bak"后缀
     *
     * @param tableName 要创建备份表的原表
     */
    public void createBakTable(String tableName) {
        //备份表的表名
        String bakTableName = generateBakTableName(tableName);
        //drop备份表
        String dropSql = "drop table if exists " + bakTableName;
        sqlPerformer.performUpdateNoContent(dropSql);
        //复制表的语句
        String bakSql = "create table " + bakTableName + " as select * from " + tableName + " where 1=2";
        sqlPerformer.performUpdateNoContent(bakSql);
        //为id字段添加主键
        String pkSql = "alter table " + bakTableName + " add constraint primary key (" + tableInfoConfiguration.getIdColumn() + ")";
        sqlPerformer.performUpdateNoContent(pkSql);
        //为主键添加自增
        String aiSql = "alter table " + bakTableName + " modify " + tableInfoConfiguration.getIdColumn() + " int auto_increment";
        sqlPerformer.performUpdateNoContent(aiSql);
        //为表添加业务主键(原表ID)
        bakSql = "alter table " + bakTableName + " add " +  bakTableConfiguration.getAddColumnsBizId() + " int not null";
        sqlPerformer.performUpdateNoContent(bakSql);
        //添加业务操作标记(增删改等操作)
        bakSql = "alter table " + bakTableName + " add " + bakTableConfiguration.getAddColumnsBizOp() + " varchar(32) not null";
        sqlPerformer.performUpdateNoContent(bakSql);
        //添加操作时间字段，记录用户在更变数据的时间
        bakSql = "alter table " + bakTableName + " add " + bakTableConfiguration.getAddColumnsBizOpTime() + " datetime not null";
        sqlPerformer.performUpdateNoContent(bakSql);
    }

    /**
     * 生成备份表的表名
     *
     * @param tableName
     * @return
     */
    public String generateBakTableName(String tableName) {
        return "bak_" + tableName;
    }


}
