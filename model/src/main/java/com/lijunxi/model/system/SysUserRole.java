package com.lijunxi.model.system;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.lijunxi.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户角色")
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private String roleId;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private String userId;

    @TableField("is_deleted")
    private Integer isDeleted;

}

