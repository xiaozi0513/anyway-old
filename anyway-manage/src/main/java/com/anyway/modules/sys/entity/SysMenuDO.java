package com.anyway.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 系统菜单
 * @author: wang_hui
 * @date: 2018/5/30 下午4:49
 * @since: 1.0.0
 */
@Data
@TableName("sys_menu")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysMenuDO implements Serializable {
    private static final long serialVersionUID = 7160622958910551008L;

    @TableId
    private Long id;

    private Long parentId;

    @TableField(exist = false)
    private String parentName;

    private String name;

    private String url;

    private Integer type;

    private String icon;

    private Integer orderNum;

    private Integer status;

    @TableField(exist = false)
    private Boolean open;

    @TableField(exist = false)
    private List<SysMenuDO> children;

}
