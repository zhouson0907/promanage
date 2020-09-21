package com.adtec.pay.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class IcpPayResponseBody {

    private String tran_type;
    private String pay_url;
    private String merchant_no;
    private String order_no;
    private String order_amount;
    private String tran_date;
    private String tran_time;
    private String prepay_id;
    private String third_reorder_no;
    private String third_order_no;

    @JSONField(name = "TRAN_TYPE")
    public String getTran_type() {
        return tran_type;
    }

    public void setTran_type(String tran_type) {
        this.tran_type = tran_type;
    }

    @JSONField(name = "PAY_URL")
    public String getPay_url() {
        return pay_url;
    }

    public void setPay_url(String pay_url) {
        this.pay_url = pay_url;
    }

    @JSONField(name = "MERCHANT_NO")
    public String getMerchant_no() {
        return merchant_no;
    }

    public void setMerchant_no(String merchant_no) {
        this.merchant_no = merchant_no;
    }

    @JSONField(name = "ORDER_NO")
    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    @JSONField(name = "ORDER_AMOUNT")
    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    @JSONField(name = "TRAN_DATE")
    public String getTran_date() {
        return tran_date;
    }

    public void setTran_date(String tran_date) {
        this.tran_date = tran_date;
    }

    @JSONField(name = "TRAN_TIME")
    public String getTran_time() {
        return tran_time;
    }

    public void setTran_time(String tran_time) {
        this.tran_time = tran_time;
    }

    @JSONField(name = "PREPAY_ID")
    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    @JSONField(name = "THIRD_REORDER_NO")
    public String getThird_reorder_no() {
        return third_reorder_no;
    }

    public void setThird_reorder_no(String third_reorder_no) {
        this.third_reorder_no = third_reorder_no;
    }

    @JSONField(name = "THIRD_ORDER_NO")
    public String getThird_order_no() {
        return third_order_no;
    }

    public void setThird_order_no(String third_order_no) {
        this.third_order_no = third_order_no;
    }
}
