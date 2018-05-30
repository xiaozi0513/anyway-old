package com.anyway.modules.sys.service.impl;

import com.anyway.modules.sys.dao.SysMenuMapper;
import com.anyway.modules.sys.entity.SysMenuDO;
import com.anyway.modules.sys.service.SysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单管理
 * @author: wang_hui
 * @date: 2018/5/30 下午5:27
 * @since:
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuDO> implements SysMenuService {

    @Override
    public List<SysMenuDO> queryListByParentId(Long parentId) {
        return baseMapper.queryListByParentId(parentId);
    }

}
