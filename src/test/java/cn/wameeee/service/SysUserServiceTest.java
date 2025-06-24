package cn.wameeee.service;

import cn.wameeee.entity.SysUser;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SysUserServiceTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceTest.class);
    private ApplicationContext ctx;
    private SysUserService userService;
    
    @Override
    protected void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (SysUserService) ctx.getBean("sysUserService");
    }

    public void testFindList() {
        SysUser queryCondition = new SysUser();
        queryCondition.setRealName("李");
        queryCondition.setRoleId(2L);
        List<SysUser> userList = userService.findList(queryCondition);
        for (SysUser user : userList) {
            LOGGER.info(user.toString());
        }
    }

    public void testTransaction(){
        SysUser user1 = new SysUser();
        user1.setAccount("xiaoma");
        user1.setRealName("测试小马");
        SysUser user2 = new SysUser();
        user2.setAccount("xiaoniu");
        user2.setRealName("测试小牛");
        List<SysUser> userList = Arrays.asList(user1,user2);
        userService.saveBatch(userList);
    }
    
    /**
     * 测试添加单个用户
     */
    public void testSave() {
        SysUser user = new SysUser();
        user.setAccount("zhangsan");
        user.setRealName("张三");
        user.setPassword("123456");
        user.setSex(1);
        user.setBirthday(new Date());
        user.setPhone("13800138000");
        user.setAddress("北京市朝阳区");
        user.setRoleId(2L);
        user.setCreatedUserId(1L);
        
        int result = userService.save(user);
        LOGGER.info("添加用户结果：{}", result);
        assertTrue(result > 0);
    }
    
    /**
     * 测试更新用户信息
     */
    public void testUpdate() {
        // 先查询一个用户
        SysUser queryCondition = new SysUser();
        List<SysUser> userList = userService.findList(queryCondition);
        if (userList != null && !userList.isEmpty()) {
            SysUser user = userList.get(0);
            // 更新用户信息
            user.setRealName(user.getRealName() + "_更新");
            user.setPhone("13900139000");
            user.setUpdatedUserId(1L);
            
            int result = userService.update(user);
            LOGGER.info("更新用户结果：{}", result);
            assertTrue(result > 0);
        } else {
            LOGGER.info("没有可更新的用户");
        }
    }
    
    /**
     * 测试删除用户
     */
    public void testDeleteById() {
        // 先查询一个用户
        SysUser queryCondition = new SysUser();
        queryCondition.setRealName("张三");
        List<SysUser> userList = userService.findList(queryCondition);
        if (userList != null && !userList.isEmpty()) {
            SysUser user = userList.get(0);
            int result = userService.deleteById(user.getId());
            LOGGER.info("删除用户结果：{}", result);
            assertTrue(result > 0);
        } else {
            LOGGER.info("没有可删除的用户");
        }
    }
    
    /**
     * 测试完整的CRUD流程
     */
    public void testCRUD() {
        // 1. 创建用户
        SysUser user = new SysUser();
        user.setAccount("lisi");
        user.setRealName("李四");
        user.setPassword("123456");
        user.setSex(1);
        user.setBirthday(new Date());
        user.setPhone("13700137000");
        user.setAddress("上海市浦东新区");
        user.setRoleId(2L);
        user.setCreatedUserId(1L);
        
        int saveResult = userService.save(user);
        LOGGER.info("添加用户结果：{}", saveResult);
        assertTrue(saveResult > 0);
        
        // 2. 查询用户
        SysUser queryCondition = new SysUser();
        queryCondition.setAccount("lisi");
        List<SysUser> userList = userService.findList(queryCondition);
        assertNotNull(userList);
        assertTrue(userList.size() > 0);
        
        // 获取用户ID
        Long userId = userList.get(0).getId();
        
        // 3. 更新用户
        SysUser updateUser = userList.get(0);
        updateUser.setAddress("上海市黄浦区");
        updateUser.setUpdatedUserId(1L);
        
        int updateResult = userService.update(updateUser);
        LOGGER.info("更新用户结果：{}", updateResult);
        assertTrue(updateResult > 0);
        
        // 4. 删除用户
        int deleteResult = userService.deleteById(userId);
        LOGGER.info("删除用户结果：{}", deleteResult);
        assertTrue(deleteResult > 0);
    }
}