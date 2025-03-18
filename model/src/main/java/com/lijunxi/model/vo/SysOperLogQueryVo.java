package com.lijunxi.model.vo;

import lombok.Data;

@Data
public class SysOperLogQueryVo {

	private String title;
	private String operName;

	private String createTimeBegin;
	private String createTimeEnd;
	private String pageNum;
	private String pageSize;

}

