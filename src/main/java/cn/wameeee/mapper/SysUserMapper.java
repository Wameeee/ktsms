package cn.wameeee.mapper;

import cn.wameeee.entity.SysUser;

import java.util.List;

public interface SysUserMapper {
    /**
     * 查询用户
     * @param sysUser
     * @return
     */
    public List<SysUser> getSysUserList(SysUser sysUser);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 更新用户信息
     * @param sysUser
     * @return
     */
    int update(SysUser sysUser);

    /**
     * 根据用户Id删除用户信息
     * @param id
     * @return
     */
    int deleteById(Long id);
}
