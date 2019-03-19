package top.javinjunfeng.db.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.javinjunfeng.model.entity.DbInfoDO;
import top.javinjunfeng.service.DbInfoService;


/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/18 1:54 PM
 */

@SpringBootApplication
@RestController
public class TestApp implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }


    @Autowired
    private DbInfoService dbInfoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DbInfoDO select = dbInfoService.select("1");
        System.out.println(select.getDbName());
        System.out.println(select.getId());
        System.out.println(select);
    }

    @RequestMapping("/db")
    public String hello1() {
        return dbInfoService.select("1").toString();
    }



}
