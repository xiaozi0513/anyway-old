package com.anyway.modules.sys.dao;

import com.anyway.modules.sys.entity.SysUserDO;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 用户管理
 * @author wang_hui
 * @date 2018/6/9 14:45
 * @since 1.0.0
 **/
public interface SysUserMapper  extends BaseMapper<SysUserDO> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUserDO getByUsername(String username);
}
