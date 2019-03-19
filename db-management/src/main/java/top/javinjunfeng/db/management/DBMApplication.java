package top.javinjunfeng.db.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = "top.javinjunfeng")
@EnableTransactionManagement(proxyTargetClass = true)//springboot事物代理，配置位true使用cglib代理
@EnableConfigurationProperties
@EnableCaching
@EnableScheduling//开启注解方式定时任务
public class DBMApplication {

    public static void main(String[] args) {
        SpringApplication.run(DBMApplication.class, args);
    }
}
