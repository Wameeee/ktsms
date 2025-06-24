package cn.wameeee.config;

import cn.wameeee.entity.SysRole;
import cn.wameeee.entity.SysUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:user.properties", encoding = "UTF-8")
public class JavaConfig {

    @Value("${user.realName}")
    private String realName;
    @Value("${user.account}")
    private String account;
    @Value("${user.password}")
    private String password;
    @Value("${user.sex}")
    private Integer sex;

    @Bean
    public SysUser user(@Qualifier("managerRole") SysRole role){
        SysUser user = new SysUser();
        user.setRealName(realName);
        user.setAccount(account);
        user.setPassword(password);
        user.setSex(sex);
        user.setSysRole(role);
        return user;
    }

    @Bean
    @Primary
    public SysRole adminRole(){
        SysRole role = new SysRole();
        role.setId(1L);
        role.setRoleName("管理员");
        role.setCode("ADMIN");
        return role;
    }

    @Bean
    public SysRole managerRole(){
        SysRole role = new SysRole();
        role.setId(2L);
        role.setRoleName("店长");
        role.setCode("MANAGER");
        return role;
    }
}
