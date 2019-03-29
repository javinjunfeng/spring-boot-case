package top.javinjunfeng.db.management.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/20 1:04 PM
 */
@Configuration
@MapperScan(basePackages = "top.javinjunfeng.example.dao.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

    @Bean(name = "datasource")
    @Primary
    @ConfigurationProperties(prefix = "datasource.druid")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    // 数据源事务管理器
    @Bean(name="dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        sessionFactoryBean.setTypeAliasesPackage("top.javinjunfeng.example.dao.entity");
        return sessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
