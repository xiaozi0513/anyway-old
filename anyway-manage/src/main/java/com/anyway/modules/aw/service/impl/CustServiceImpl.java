package com.anyway.modules.aw.service.impl;

import com.anyway.common.utils.PageUtils;
import com.anyway.common.utils.Query;
import com.anyway.modules.aw.dao.CustMapper;
import com.anyway.modules.aw.entity.CustDO;
import com.anyway.modules.aw.service.CustService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Map;

/**
 * 客户信息
 * @author: wang_hui
 * @date: 2018/7/19 下午4:53
 * @since:
 */
public class CustServiceImpl extends ServiceImpl<CustMapper, CustDO> implements CustService {

    /**
     * 客户信息分页查询
     * @param params 查询条件
     * @return
     */
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CustDO> page = this.selectPage(
                new Query<CustDO>(params).getPage(),
                new EntityWrapper<>()
        );

        return new PageUtils(page);
    }

}
