package com.adtec.pay.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class CommonResponse<T> extends Response{

    private ResponseHead HEAD;
    private T BODY;

    @JSONField(name = "HEAD")
    public ResponseHead getHEAD() {
        return HEAD;
    }

    public void setHEAD(ResponseHead HEAD) {
        this.HEAD = HEAD;
    }

    @JSONField(name = "BODY")
    public T getBODY() {
        return BODY;
    }

    public void setBODY(T BODY) {
        this.BODY = BODY;
    }
}
