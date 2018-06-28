package com.anyway.modules.sys.controller;

import com.anyway.common.utils.R;
import com.anyway.modules.sys.entity.SysMenuDO;
import com.anyway.modules.sys.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统菜单
 * @author: wang_hui
 * @date: 2018/5/30 下午5:11
 * @since: 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("/nav")
    public R nav() {
        List<SysMenuDO> menuList = sysMenuService.queryMenuList();
        return R.ok().put("data", menuList);
    }
}
