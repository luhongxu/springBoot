package com.lu.common.result;

import lombok.Data;

@Data
public class PageParam {
    private int page = 1;
    private int limit = 10;

    public PageParam(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public PageParam() {
    }
}
