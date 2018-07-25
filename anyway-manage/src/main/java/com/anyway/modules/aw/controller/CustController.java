package com.anyway.modules.aw.controller;

import com.anyway.common.utils.PageUtils;
import com.anyway.common.utils.R;
import com.anyway.modules.aw.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 客户信息管理
 * @author: wang_hui
 * @date: 2018/7/19 下午6:13
 * @since:
 */
@RestController
@RequestMapping("/anyway/cust")
public class CustController {

    @Autowired
    private CustService custService;

    /**
     * 客户信息分页查询
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = custService.queryPage(params);
        return R.ok().put("page", page);
    }
}
