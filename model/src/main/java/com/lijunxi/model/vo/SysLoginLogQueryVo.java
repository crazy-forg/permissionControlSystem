package com.lijunxi.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysLoginLogQueryVo {
	
	@ApiModelProperty(value = "用户账号")
	private String username;

	private String createTimeBegin;
	private String createTimeEnd;
	private String pageNum;
	private String pageSize;


}

