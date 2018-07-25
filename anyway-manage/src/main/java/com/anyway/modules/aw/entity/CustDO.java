package com.anyway.modules.aw.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户信息
 * @author: wang_hui
 * @date: 2018/7/19 下午4:24
 * @since:
 */
@Data
@TableName("aw_cust")
public class CustDO implements Serializable {
    private static final long serialVersionUID = 5255014973528254637L;

    /**
     * 主键，客户ID
     */
    @TableId
    private Long id;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别 0-未知，1-男，2-女
     */
    private Integer gender;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 备注
     */
    private String remark;

}
