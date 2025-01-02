//
//
package com.lijunxi.model.vo;


import lombok.Data;

import java.io.Serializable;

/**
 * 用户新增实体
 */
@Data
public class SysUserAddVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String password;
	private String username;
	private String name;
	private String phone;
	private String headUrl;

}

