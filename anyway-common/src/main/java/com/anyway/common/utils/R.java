package com.anyway.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * @author: wang_hui
 * @date: 2018/6/6 下午2:55
 * @since: 1.0.0
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = -4757194637503559705L;

    public R() {
        put("code", 200);
        put("msg", "OK");
    }

    public static R ok() {
        return new R();
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R error() {
        return error("未知异常");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
