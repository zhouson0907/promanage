package com.adtec.pay.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class CommonRequest<T> extends Request {

    private RequestHead HEAD;
    private T BODY;

    public CommonRequest(String trancode, Class<? extends Response> responseClass) {
        super(trancode, responseClass);
    }

    @JSONField(name = "HEAD")
    public RequestHead getHEAD() {
        return new RequestHead();
    }

    public void setHEAD(RequestHead HEAD) {
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
