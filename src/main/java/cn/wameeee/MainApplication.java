package cn.wameeee;

import cn.wameeee.config.JavaConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ComponentScan(basePackages = {"cn.wameeee.config", "cn.wameeee.service"})
@Import({JavaConfig.class})
@ImportResource("classpath:applicationContext.xml")
public class MainApplication {
}
