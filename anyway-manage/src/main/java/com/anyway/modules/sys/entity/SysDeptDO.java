package com.anyway.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 部门信息
 * @author: wang_hui
 * @date: 2018/6/1 下午2:58
 * @since: 1.0.0
 */
@Data
@TableName("sys_dept")
public class SysDeptDO implements Serializable {
    private static final long serialVersionUID = -2472460596602190085L;

    @TableId
    private Long deptId;

    private Long parentId;

    @TableField(exist = false)
    private String parentName;

    private String name;

    private Integer orderNum;

    private Integer delFlag;
}
