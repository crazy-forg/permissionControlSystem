//
//
package com.lijunxi.model.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class SysRoleAddVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String roleName;

	private String roleCode;

	private String description;

}

