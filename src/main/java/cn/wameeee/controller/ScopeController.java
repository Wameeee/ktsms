package cn.wameeee.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope("prototype")
public class ScopeController {
    private int count = 0;

    @GetMapping("/count")
    public String count() {
        String scope = this.getClass().getAnnotation(Scope.class).value();
        System.out.println(scope+"-count="+ ++count);
        return null;
    }

    @Autowired
    private WebApplicationContext context;

    @GetMapping("/scope")
    public String testScope(HttpSession session) {
        printBeanInfo("scope", session);
        return "forward:/forward";
    }

    @GetMapping("/forward")
    public String forward(HttpSession session) {
        printBeanInfo("forward", session);
        return null;
    }

    private void printBeanInfo(String type ,HttpSession session) {
        System.out.println(type+"=================sessionId="+session.getId());

        Object roleSingleton = context.getBean("roleSingleton");
        System.out.println(roleSingleton.getClass().getName());
        Object rolePrototype =  context.getBean("rolePrototype");
        System.out.println(rolePrototype.getClass().getName());
        Object roleRequest = context.getBean("roleRequest");
        System.out.println(roleRequest.getClass().getName());
        Object roleSession = context.getBean("roleSession");
        System.out.println(roleSession.getClass().getName());
    }
}
