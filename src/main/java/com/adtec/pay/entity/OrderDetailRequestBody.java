package com.adtec.pay.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class OrderDetailRequestBody {
    // 商品订单号
    private String ORD_NO;

    @JSONField(name = "ORD_NO")
    public String getORD_NO() {
        return ORD_NO;
    }

    public void setORD_NO(String ORD_NO) {
        this.ORD_NO = ORD_NO;
    }

}
