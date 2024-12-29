package com.lijunxi.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BatchDeleteRequestVo {
    private List<Long> ids;

    // 构造函数、getter和setter
    public BatchDeleteRequestVo() {
    }

    public BatchDeleteRequestVo(List<Long> ids) {
        this.ids = ids;
    }

}
