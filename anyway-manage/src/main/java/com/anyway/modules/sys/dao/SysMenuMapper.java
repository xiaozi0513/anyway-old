package com.anyway.modules.sys.dao;

import com.anyway.modules.sys.entity.SysMenuDO;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 菜单管理
 * @author: wang_hui
 * @date: 2018/5/30 下午4:48
 * @since: 1.0.0
 */
public interface SysMenuMapper extends BaseMapper<SysMenuDO> {

    /**
     * 根据父菜单,查询子菜单
     * @param parentId
     * @return
     */
    List<SysMenuDO> queryListByParentId(Long parentId);

}
