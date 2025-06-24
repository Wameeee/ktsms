package cn.wameeee.service;

import cn.wameeee.entity.SysUser;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SysUserServiceTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceTest.class);

    public void testFindList() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("database.xml");
        SysUserService userService = (SysUserService) ctx.getBean("sysUserService");
        SysUser queryCondition = new SysUser();
        queryCondition.setRealName("李");
        queryCondition.setRoleId(2L);
        List<SysUser> userList = userService.findList(queryCondition);
        for (SysUser user : userList) {
            LOGGER.info(user.toString());
        }
    }
}