package cn.wameeee.service.impl;

import cn.wameeee.entity.SysUser;
import cn.wameeee.mapper.SysUserMapper;
import cn.wameeee.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service("sysUserService")
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public List<SysUser> findList(SysUser sysUser) {
        return sysUserMapper.getSysUserList(sysUser);
    }

    @Override
    public int saveBatch(List<SysUser> sysUserList) {
        int rows = 0;
        for (int i = 0; i < sysUserList.size(); i++) {
            SysUser sysUser = sysUserList.get(i);
            if (i == 1) {
                throw new RuntimeException("数据库异常");
            }
            rows += sysUserMapper.insert(sysUser);
        }
        return rows;
    }
    
    @Override
    public int save(SysUser sysUser) {
        // 设置创建时间
        sysUser.setCreatedTime(new Date());
        return sysUserMapper.insert(sysUser);
    }
    
    @Override
    public int update(SysUser sysUser) {
        // 设置更新时间
        sysUser.setUpdatedTime(new Date());
        return sysUserMapper.update(sysUser);
    }
    
    @Override
    public int deleteById(Long id) {
        return sysUserMapper.deleteById(id);
    }
}
