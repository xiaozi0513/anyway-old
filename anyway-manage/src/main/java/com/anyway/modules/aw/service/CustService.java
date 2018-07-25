package com.anyway.modules.aw.service;

import com.anyway.common.utils.PageUtils;

import java.util.Map;

/**
 * @author: wang_hui
 * @date: 2018/7/19 下午4:52
 * @since:
 */
public interface CustService {
    /**
     * 客户信息分页查询
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);
}
