package com.anyway.modules.sys.controller;

import com.anyway.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wang_hui
 * @date: 2018/6/8 下午6:21
 * @since:
 */
@RestController
public class TestController {

    @RequestMapping("/json/menu")
    public R test(){
        String str = "[{\"title\":\"系统管理\",\"href\":\"#\",\"children\":[{\"title\":\"菜单管理\",\"href\":\"/sys/menu\"},{\"title\":\"角色管理\",\"href\":\"/sys/role\"}]},{\"title\":\"一级菜单\",\"href\":\"#\",\"children\":[{\"title\":\"二级菜单\",\"href\":\"#\",\"children\":[{\"title\":\"三级菜单\",\"href\":\"/first/snd/thrd\"}]}]}]";
        return R.ok().put("data", str);
    }
}
