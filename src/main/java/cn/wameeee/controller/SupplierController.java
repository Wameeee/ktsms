package cn.wameeee.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);

    @GetMapping("page")
    public String page(HttpServletRequest request) throws Exception{
        LOGGER.info("查询供货商分页数据");
        return null;
    }
}
