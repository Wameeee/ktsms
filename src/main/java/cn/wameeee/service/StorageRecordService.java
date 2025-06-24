package cn.wameeee.service;

import cn.wameeee.entity.StorageRecord;

public interface StorageRecordService {

    /**
     * 添加单个入库信息
     * @param storageRecord 入库信息
     * @return 影响行数
     */
    int save(StorageRecord storageRecord);

    /**
     * 更新入库信息
     * @param storageRecord 入库信息
     * @return 影响行数
     */
    int update(StorageRecord storageRecord);

    /**
     * 根据ID删除入库信息
     * @param id 入库ID
     * @return 影响行数
     */
    int deleteById(Long id);
}
