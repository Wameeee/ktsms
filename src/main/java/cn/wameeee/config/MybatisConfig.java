package cn.wameeee.config;

import cn.wameeee.cond.ConditionOnPropertyEnable;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "database.properties")
public class MybatisConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Value("${dataSource.type:dev}")
    private String dataSourceType;
    
    @Autowired
    private ApplicationContext applicationContext;


    @Bean(name = "devDataSource")
    @Conditional(ConditionOnPropertyEnable.OnEnableCondition.class)
    @ConditionOnPropertyEnable(enableProperty = "dev.enable")
    public DataSource devDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
        return dataSource;
    }

    @Bean(name = "testDataSource")
    @Conditional(ConditionOnPropertyEnable.OnEnableCondition.class)
    @ConditionOnPropertyEnable(enableProperty = "test.enable")
    public DataSource testDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(3);
        dataSource.setMaxTotal(8);
        return dataSource;
    }

    @Bean
    @Conditional(ConditionOnPropertyEnable.OnEnableCondition.class)
    @ConditionOnPropertyEnable(enableProperty = "SqlSessionFactoryBean.enable")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        
        // 根据配置选择使用哪个数据源
        DataSource targetDataSource = null;
        if ("dev".equalsIgnoreCase(dataSourceType) && applicationContext.containsBean("devDataSource")) {
            targetDataSource = (DataSource) applicationContext.getBean("devDataSource");
        } else if ("test".equalsIgnoreCase(dataSourceType) && applicationContext.containsBean("testDataSource")) {
            targetDataSource = (DataSource) applicationContext.getBean("testDataSource");
        } else {
            // 默认使用可用的数据源
            if (applicationContext.containsBean("devDataSource")) {
                targetDataSource = (DataSource) applicationContext.getBean("devDataSource");
            } else if (applicationContext.containsBean("testDataSource")) {
                targetDataSource = (DataSource) applicationContext.getBean("testDataSource");
            } else {
                throw new IllegalStateException("没有可用的数据源");
            }
        }
        
        sqlSessionFactoryBean.setDataSource(targetDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("cn.wameeee.entity");
        return sqlSessionFactoryBean;
    }
}
