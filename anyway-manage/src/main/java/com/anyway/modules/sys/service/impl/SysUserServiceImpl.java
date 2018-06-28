package com.anyway.modules.sys.service.impl;

import com.anyway.modules.sys.dao.SysUserMapper;
import com.anyway.modules.sys.entity.SysUserDO;
import com.anyway.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 * @author wang_hui
 * @date 2018/6/9 14:58
 * @since 1.0.0
 **/
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDO> implements SysUserService {

    @Override
    public SysUserDO getByUsername(String username) {
        return baseMapper.getByUsername(username);
    }
}
