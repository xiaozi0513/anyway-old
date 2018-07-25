package com.anyway.modules.sys.service.impl;

import com.anyway.modules.sys.dao.SysMenuMapper;
import com.anyway.modules.sys.entity.SysMenuDO;
import com.anyway.modules.sys.service.SysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 菜单管理
 * @author: wang_hui
 * @date: 2018/5/30 下午5:27
 * @since:
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuDO> implements SysMenuService {

    /**
     * 根据父菜单ID获取子类菜单
     * @param parentId 父菜单ID
     * @return
     */
    @Override
    public List<SysMenuDO> queryListByParentId(Long parentId) {
        return baseMapper.queryListByParentId(parentId);
    }

    /**
     * 获取层级菜单列表
     * @return
     */
    @Override
    public List<SysMenuDO> queryMenuList() {
        List<SysMenuDO> menuList = queryListByParentId(0L);
        //递归
        getMenuTreeList(menuList);
        return menuList;
    }

    /**
     * 递归获取菜单
     * @param menuList
     * @return
     */
    private List<SysMenuDO> getMenuTreeList(List<SysMenuDO> menuList) {
        List<SysMenuDO> children = new LinkedList<>();
        for (SysMenuDO menu : menuList) {
            if (menu.getType() == 0) {
                menu.setChildren(getMenuTreeList(queryListByParentId(menu.getId())));
            }
            children.add(menu);
        }
        return children;
    }

}
