package com.anyway.modules.sys.service;

import com.anyway.modules.sys.entity.SysUserDO;

/**
 * 用户管理
 * @author wang_hui
 * @date 2018/6/9 14:55
 * @since 1.0.0
 **/
public interface SysUserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUserDO getByUsername(String username);
}
