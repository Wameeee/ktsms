package cn.wameeee.controller;

import cn.wameeee.entity.SysUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.Map;

@Controller
@RequestMapping("/dev")
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping("/hello")
    protected ModelAndView hello (@RequestParam(name = "realName" ,required = false) String name) throws Exception {

        LOGGER.info("你好{}，欢迎学习SpringMVC!",name);
        ModelAndView mv = new ModelAndView();
        mv.addObject("realName", name);
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping("/welcome")
    protected String welcome (HttpServletRequest request) throws Exception {
        LOGGER.info("进入控制器welcome方法，请求路径为{}", request.getRequestURI());

        return "hello";
    }

    @RequestMapping("/model")
    public String model(Model model , @RequestParam(name="realName",required=false) String name, Map map)  throws Exception {
        LOGGER.info("你好{},在参数注入model1对象也可以出参！",name);
        map.put("realName", name);
        SysUser sysUser = new SysUser();
        sysUser.setRealName(name);
        map.put("sysUser", sysUser);
        return "hello";
    }
}
