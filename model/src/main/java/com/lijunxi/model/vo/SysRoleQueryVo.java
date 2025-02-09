
package com.lijunxi.model.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class SysRoleQueryVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String roleName;

	private Long pageSize;

	private Long pageNum;

}

