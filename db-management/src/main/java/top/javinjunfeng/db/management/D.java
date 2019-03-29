package top.javinjunfeng.db.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import top.javinjunfeng.db.management.util.DBUtils;
import top.javinjunfeng.db.management.dto.FieldInfoDTO;
import top.javinjunfeng.db.management.dto.TableInfoDTO;
import top.javinjunfeng.example.dao.entity.DbInfo;
import top.javinjunfeng.rdbms.util.DBUtil;
import top.javinjunfeng.rdbms.util.DataBaseType;
import top.javinjunfeng.rdbms.util.JdbcConnectionFactory;
import top.javinjunfeng.service.DbInfoService;

import java.sql.Connection;
import java.util.List;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/20 12:42 PM
 */

@SpringBootApplication
@ComponentScan(basePackages = "top.javinjunfeng")
public class D  implements ApplicationRunner {

    @Autowired
    DbInfoService dbInfoService;

    private String url = "jdbc:mysql://127.0.0.1:3306/Spring?characterEncoding=utf-8&useSSL=false&zeroDateTimeBehavior=convertToNull";
    private String db = "Spring";

    private String tablePrefix = "";

    public static void main(String[] args) {
        SpringApplication.run(D.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DbInfo dbInfo = dbInfoService.selectByDbCode(1);
        System.out.println(dbInfo.getDbIp());

        DBUtils dbUtils = new DBUtils();
        List<String> strings = dbUtils.showBizTables(DataBaseType.MySql,url,db,"root","katarina");
        strings.forEach(System.out::println);
//        System.out.println(strings);
        List<FieldInfoDTO> teale_info = dbUtils.showColumns(DataBaseType.MySql,url,db,"root","katarina","db_info");
        teale_info.forEach(System.out::println);
        List<TableInfoDTO> tableInfoDTOS = dbUtils.showTablesInfo(DataBaseType.MySql, url, db, "root", "katarina");
        tableInfoDTOS.forEach(System.out::println);



        JdbcConnectionFactory jdbcConnectionFactory = new JdbcConnectionFactory(DataBaseType.MySql,url,"root", "katarina");
        Connection connection = jdbcConnectionFactory.getConnecttion();
        DBUtil.getMySqlTableInfoByConn(DataBaseType.MySql,connection,"db_info");


    }
}
