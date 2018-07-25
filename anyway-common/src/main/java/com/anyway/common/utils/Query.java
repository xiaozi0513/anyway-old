package com.anyway.common.utils;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 * @author: wang_hui
 * @date: 2018/7/19 下午5:57
 * @since:
 */
public class Query<T> extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 5427027701957522922L;

    /**
     * MyBatis-Plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        if (params.get("page") != null) {
            currPage = Integer.parseInt((String) params.get("page"));
        }
        if (params.get("limit") != null) {
            limit = Integer.parseInt((String) params.get("limit"));
        }

        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);

        this.page = new Page<>(currPage, limit);
    }

    public Page<T> getPage() {
        return page;
    }
}
