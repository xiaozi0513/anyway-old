package com.anyway.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色信息
 * @author: wang_hui
 * @date: 2018/6/1 下午2:52
 * @since: 1.0.0
 */
@Data
@TableName("sys_role")
public class SysRoleDO implements Serializable {
    private static final long serialVersionUID = 4119004630111561279L;

    @TableId
    private Long roleId;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
