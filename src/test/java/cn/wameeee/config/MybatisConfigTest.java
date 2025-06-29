package cn.wameeee.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MybatisConfigTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisConfigTest.class);

    @Test
    public void testDevDataSource() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
        
        // 检查是否存在devDataSource bean
        if (!context.containsBean("devDataSource")) {
            LOGGER.info("数据源 'devDataSource' 未启用，跳过测试");
            return; // 数据源未启用时跳过测试
        }
        
        DataSource dataSource = (DataSource) context.getBean("devDataSource");
        Assert.assertNotNull(dataSource);
        LOGGER.info("数据源类型: {}", dataSource.getClass().getName());
        
        // 测试数据源连接
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Assert.assertNotNull(conn);
            LOGGER.info("数据库连接成功");
            LOGGER.info("数据库URL: {}", ((BasicDataSource) dataSource).getUrl());
            LOGGER.info("数据库用户名: {}", ((BasicDataSource) dataSource).getUsername());
            LOGGER.info("初始连接数: {}", ((BasicDataSource) dataSource).getInitialSize());
            LOGGER.info("最大连接数: {}", ((BasicDataSource) dataSource).getMaxTotal());
        } catch (SQLException e) {
            LOGGER.error("获取数据库连接失败", e);
            Assert.fail("获取数据库连接失败: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error("关闭数据库连接失败", e);
                }
            }
        }
    }
    
    @Test
    public void testTestDataSource() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
        
        // 检查是否存在testDataSource bean
        if (!context.containsBean("testDataSource")) {
            LOGGER.info("数据源 'testDataSource' 未启用，跳过测试");
            return; // 数据源未启用时跳过测试
        }
        
        DataSource dataSource = (DataSource) context.getBean("testDataSource");
        Assert.assertNotNull(dataSource);
        LOGGER.info("测试数据源类型: {}", dataSource.getClass().getName());
        
        // 测试数据源连接
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Assert.assertNotNull(conn);
            LOGGER.info("测试数据库连接成功");
            LOGGER.info("测试数据库URL: {}", ((BasicDataSource) dataSource).getUrl());
            LOGGER.info("测试数据库用户名: {}", ((BasicDataSource) dataSource).getUsername());
            LOGGER.info("初始连接数: {}", ((BasicDataSource) dataSource).getInitialSize());
            LOGGER.info("最大连接数: {}", ((BasicDataSource) dataSource).getMaxTotal());
        } catch (SQLException e) {
            LOGGER.error("获取测试数据库连接失败", e);
            Assert.fail("获取测试数据库连接失败: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error("关闭测试数据库连接失败", e);
                }
            }
        }
    }
} 