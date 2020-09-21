package com.adtec.pay.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 通用报文头
 */
public class RequestHead {
      private String req_time;
      private String req_seq;
      private String busi_type;
      private String busi_no;
      private String entr_no;
      private String lega_no;
      private String tran_code;
      private String chnl_no;
      private String sys_chnl;



    @JSONField(name = "REQ_TIME")
    public String getReq_time() {
        return req_time = String.valueOf(System.currentTimeMillis());
    }

    public void setReq_time(String req_time) {
        this.req_time = req_time;
    }

    @JSONField(name = "REQ_SEQ")
    public String getReq_seq() {
        return req_seq = String.valueOf(System.currentTimeMillis());
    }

    public void setReq_seq(String req_seq) {
        this.req_seq = req_seq;
    }

    @JSONField(name = "BUSI_TYPE")
    public String getBusi_type() {
        return busi_type;
    }

    public void setBusi_type(String busi_type) {
        this.busi_type = busi_type;
    }

    @JSONField(name = "BUSI_NO")
    public String getBusi_no() {
        return busi_no;
    }

    public void setBusi_no(String busi_no) {
        this.busi_no = busi_no;
    }

    @JSONField(name = "ENTR_NO")
    public String getEntr_no() {
        return entr_no;
    }

    public void setEntr_no(String entr_no) {
        this.entr_no = entr_no;
    }

    @JSONField(name = "LEGA_NO")
    public String getLega_no() {
        return lega_no;
    }

    public void setLega_no(String lega_no) {
        this.lega_no = lega_no;
    }

    @JSONField(name = "TRAN_CODE")
    public String getTran_code() {
        return tran_code;
    }

    public void setTran_code(String tran_code) {
        this.tran_code = tran_code;
    }

    @JSONField(name = "CHNL_NO")
    public String getChnl_no() {
        return "1";
    }

    public void setChnl_no(String chnl_no) {
        this.chnl_no = chnl_no;
    }

    @JSONField(name = "SYS_CHNL")
    public String getSys_chnl() {
        return "medical";
    }

    public void setSys_chnl(String sys_chnl) {
        this.sys_chnl = sys_chnl;
    }
}
