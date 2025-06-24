package cn.wameeee.mapper;

import cn.wameeee.entity.StorageRecord;

public interface StorageRecordMapper {

    /**
     * 添加入库记录
     * @param record
     * @return
     */
    int insert(StorageRecord record);

    /**
     * 更新入库记录信息
     * @param record
     * @return
     */
    int update(StorageRecord record);

    /**
     * 根据id删除入库记录信息
     * @param id
     * @return
     */
    int deleteById(Long id);
}
