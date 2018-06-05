package com.anyway.modules.sys.entity;

import com.anyway.common.validator.AddGroup;
import com.anyway.common.validator.UpdateGroup;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 系统用户
 * @author: wang_hui
 * @date: 2018/5/30 上午10:12
 * @since: 1.0.0
 */
@Data
@TableName("sys_user")
public class SysUserDO implements Serializable {
    private static final long serialVersionUID = -4435447139777710419L;

    @TableId
    private Long userId;

    @NotBlank(message = "用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String username;

    @NotBlank(message = "密码不能为空", groups = AddGroup.class)
    private String password;

    private String salt;

    @Email(message = "邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    private String mobile;

    private Integer status;

    @NotBlank(message = "部门不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long deptId;

    @TableField(exist = false)
    private String deptName;

}
