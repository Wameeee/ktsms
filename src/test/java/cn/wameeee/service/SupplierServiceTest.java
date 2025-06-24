package cn.wameeee.service;

import cn.wameeee.entity.Supplier;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SupplierServiceTest extends TestCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(SupplierServiceTest.class);

    public void testFindList() {
        ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SupplierService supplierService = (SupplierService) atx.getBean("supplierService");
        Supplier supplier = new Supplier();
        List<Supplier> supplierList = supplierService.findList(supplier);
        for (Supplier s : supplierList) {
            LOGGER.info(s.toString());
        }
    }
}