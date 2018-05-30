package com.anyway.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 系统用户
 *
 * @author: wang_hui
 * @date: 2018/5/30 上午10:12
 * @since: 1.0.0
 */
@TableName("sys_user")
public class SysUserDO {
    private Long userId;
    private String username;
}
