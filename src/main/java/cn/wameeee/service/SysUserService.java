package cn.wameeee.service;

import cn.wameeee.entity.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 查询用户列表
     * @param sysUser 查询条件
     * @return 用户列表
     */
    List<SysUser> findList(SysUser sysUser);

    /**
     * 批量保存用户
     * @param sysUserList 用户列表
     * @return 影响行数
     */
    int saveBatch(List<SysUser> sysUserList);
    
    /**
     * 添加单个用户
     * @param sysUser 用户信息
     * @return 影响行数
     */
    int save(SysUser sysUser);
    
    /**
     * 更新用户信息
     * @param sysUser 用户信息
     * @return 影响行数
     */
    int update(SysUser sysUser);
    
    /**
     * 根据ID删除用户
     * @param id 用户ID
     * @return 影响行数
     */
    int deleteById(Long id);
}
