package cn.wameeee.service;

import cn.wameeee.entity.StorageRecord;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class StorageRecordServiceTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageRecordServiceTest.class);
    private ApplicationContext ctx;
    private StorageRecordService storageRecordService;
    
    @Override
    protected void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        storageRecordService = (StorageRecordService) ctx.getBean("storageRecordService");
    }
    
    /**
     * 测试添加入库记录
     */
    public void testSave() {
        StorageRecord record = new StorageRecord();
        // 设置入库记录信息
        record.setSrCode("SR" + System.currentTimeMillis());
        record.setSupplierId(1L);
        record.setGoodsName("测试商品");
        record.setGoodsDesc("测试商品描述");
        record.setGoodsUnit("个");
        record.setGoodsCount(100);
        record.setTotalAmount(9999.00);
        record.setPayStatus(0); // 0-未支付，1-已支付
        record.setCreatedUserId(1L);
        record.setCreatedTime(new Date());
        
        int result = storageRecordService.save(record);
        LOGGER.info("添加入库记录结果：{}", result);
        assertTrue(result > 0);
    }
    
    /**
     * 测试更新入库记录
     */
    public void testUpdate() {
        // 假设我们知道一个存在的入库记录ID
        Long recordId = 1L; // 根据实际情况修改
        
        StorageRecord record = new StorageRecord();
        record.setId(recordId);
        record.setGoodsCount(150); // 更新数量
        record.setTotalAmount(14998.50); // 更新总价
        record.setPayStatus(1); // 更新为已支付
        record.setUpdatedUserId(1L);
        record.setUpdatedTime(new Date());
        
        int result = storageRecordService.update(record);
        LOGGER.info("更新入库记录结果：{}", result);
        assertTrue(result > 0);
    }
    
    /**
     * 测试删除入库记录
     */
    public void testDeleteById() {
        // 假设我们知道一个存在的入库记录ID
        Long recordId = 1L; // 根据实际情况修改
        
        int result = storageRecordService.deleteById(recordId);
        LOGGER.info("删除入库记录结果：{}", result);
        assertTrue(result > 0);
    }
    
    /**
     * 测试完整的CRUD流程
     * 注意：此测试需要配合StorageRecordService中的查询方法一起使用
     * 如果服务中没有查询方法，此测试可能无法完整执行
     */
    public void testCRUD() {
        // 1. 创建入库记录
        StorageRecord record = new StorageRecord();
        record.setSrCode("SR" + System.currentTimeMillis());
        record.setSupplierId(2L);
        record.setGoodsName("测试商品2");
        record.setGoodsDesc("测试商品2描述");
        record.setGoodsUnit("箱");
        record.setGoodsCount(200);
        record.setTotalAmount(17776.00);
        record.setPayStatus(0);
        record.setCreatedUserId(1L);
        record.setCreatedTime(new Date());
        
        int saveResult = storageRecordService.save(record);
        LOGGER.info("添加入库记录结果：{}", saveResult);
        assertTrue(saveResult > 0);
        
        // 在完整CRUD测试中，这里通常会有查询步骤
        // 由于StorageRecordService接口没有提供查询方法，此处省略
        
        // 假设我们已经知道了保存的记录ID
        Long recordId = record.getId(); // 如果实体类设计支持回写ID
        if (recordId == null) {
            LOGGER.info("实体类不支持ID回写，跳过后续测试");
            return;
        }
        
        // 3. 更新入库记录
        record.setGoodsCount(220);
        record.setTotalAmount(19553.60);
        record.setPayStatus(1); // 更新为已支付
        record.setUpdatedUserId(1L);
        record.setUpdatedTime(new Date());
        
        int updateResult = storageRecordService.update(record);
        LOGGER.info("更新入库记录结果：{}", updateResult);
        assertTrue(updateResult > 0);
        
        // 4. 删除入库记录
        int deleteResult = storageRecordService.deleteById(recordId);
        LOGGER.info("删除入库记录结果：{}", deleteResult);
        assertTrue(deleteResult > 0);
    }
} 