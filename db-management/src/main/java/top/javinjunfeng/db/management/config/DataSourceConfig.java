package top.javinjunfeng.db.management.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import top.javinjunfeng.db.management.util.PageHelperUtils;

import javax.sql.DataSource;

/**
 * 数据源配置类
 */
@Configuration
@MapperScan(value = "top.javinjunfeng.model.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

    /**
     * 德鲁伊数据源配置
     * @return
     */
    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    //数据源事务管理器
    @Bean(name="dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);

        sessionFactoryBean.setPlugins(new Interceptor[]{PageHelperUtils.createPageHelperPlugin()});

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:top/javinjunfeng/model/xml/*.xml"));
        return sessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}
