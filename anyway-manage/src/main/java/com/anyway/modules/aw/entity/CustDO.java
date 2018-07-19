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

    @TableId
    private Long id;

    private String custName;

    private String phone;

    private Integer gender;

    private Date createdAt;

    private Date updatedAt;

    private String remark;

}
