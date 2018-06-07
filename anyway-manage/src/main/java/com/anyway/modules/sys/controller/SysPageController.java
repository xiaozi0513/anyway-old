package com.anyway.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 系统页面视图
 * @author: wang_hui
 * @date: 2018/6/7 上午11:21
 * @since: 1.0.0
 */
@Controller
public class SysPageController {

    /**
     * 跳转到登录页
     * @return
     */
    @GetMapping(value = {"/", "/login.html"})
    public String toLogin() {
        return "login";
    }

    /**
     * 跳转到主页
     * @return
     */
    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

}
