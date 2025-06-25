package cn.wameeee.config;

import cn.wameeee.MainApplication;
import cn.wameeee.entity.SysUser;
import cn.wameeee.service.SysUserService;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JavaConfigTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaConfigTest.class);


    public void testJavaConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainApplication.class);
        SysUser user = (SysUser) context.getBean("user");
        LOGGER.debug(user.getRealName());
        LOGGER.debug(user.getAccount());
        LOGGER.debug(user.getPassword());
        LOGGER.debug(user.getSex().toString());
        LOGGER.debug(user.getSysRole().getRoleName());
    }

    public void testImportResource(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainApplication.class);

        SysUserService userService = (SysUserService) context.getBean("sysUserService");
        List<SysUser> userList = userService.findList(null);
        LOGGER.debug(String.valueOf(userList.size()));
    }
}