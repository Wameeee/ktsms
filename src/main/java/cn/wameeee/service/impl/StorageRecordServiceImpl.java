package cn.wameeee.service.impl;

import cn.wameeee.entity.StorageRecord;
import cn.wameeee.mapper.StorageRecordMapper;
import cn.wameeee.service.StorageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service("storageRecordService")
@Transactional
public class StorageRecordServiceImpl implements StorageRecordService {

   @Autowired
    private StorageRecordMapper storageRecordMapper;

    public void setStorageRecordMapper(StorageRecordMapper storageRecordMapper) {
        this.storageRecordMapper = storageRecordMapper;
    }

    @Override
    public int save(StorageRecord storageRecord) {
        storageRecord.setCreatedTime(new Date());
        return storageRecordMapper.insert(storageRecord);
    }

    @Override
    public int update(StorageRecord storageRecord) {
        storageRecord.setUpdatedTime(new Date());
        return storageRecordMapper.update(storageRecord);
    }

    @Override
    public int deleteById(Long id) {
        return storageRecordMapper.deleteById(id);
    }
}
