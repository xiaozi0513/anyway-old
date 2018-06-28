package com.anyway.modules.sys.service;

import com.anyway.modules.sys.entity.SysMenuDO;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * 菜单管理
 * @author: wang_hui
 * @date: 2018/5/30 下午5:13
 * @since: 1.0.0
 */
public interface SysMenuService extends IService<SysMenuDO> {

    /**
     * 根据父菜单查询子菜单
     * @param parentId
     * @return
     */
    List<SysMenuDO> queryListByParentId(Long parentId);

    /**
     * 获取菜单列表
     * @return
     */
    List<SysMenuDO> queryMenuList();
}
