package com.adtec.pay.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 返回的参数公共部分
 */
public class ResponseHead {
    private String RESP_SEQ;
    private String RET_CODE;
    private String RET_MSG;
    private String RESP_TIME;

    @JSONField(name = "RESP_SEQ")
    public String getRESP_SEQ() {
        return RESP_SEQ;
    }

    public void setRESP_SEQ(String RESP_SEQ) {
        this.RESP_SEQ = RESP_SEQ;
    }

    @JSONField(name = "RET_CODE")
    public String getRET_CODE() {
        return RET_CODE;
    }

    public void setRET_CODE(String RET_CODE) {
        this.RET_CODE = RET_CODE;
    }

    @JSONField(name = "RET_MSG")
    public String getRET_MSG() {
        return RET_MSG;
    }

    public void setRET_MSG(String RET_MSG) {
        this.RET_MSG = RET_MSG;
    }

    @JSONField(name = "RESP_TIME")
    public String getRESP_TIME() {
        return RESP_TIME;
    }

    public void setRESP_TIME(String RESP_TIME) {
        this.RESP_TIME = RESP_TIME;
    }
}
