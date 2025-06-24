package cn.wameeee.config;

import cn.wameeee.entity.SysUser;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaConfigTest.class);


    public void testJavaConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        SysUser user = (SysUser) context.getBean("user");
        LOGGER.debug(user.getRealName());
        LOGGER.debug(user.getAccount());
        LOGGER.debug(user.getPassword());
        LOGGER.debug(user.getSex().toString());
    }
}