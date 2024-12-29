package com.lijunxi.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class BatchDeleteRequestVo {
    private List<Long> ids;

    // 构造函数、getter和setter
    public BatchDeleteRequestVo() {
    }

    public BatchDeleteRequestVo(List<Long> ids) {
        this.ids = ids;
    }

}
