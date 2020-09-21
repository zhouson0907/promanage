package com.adtec.pay.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class IcpPayRequestBody {

    private String pay_mode;
    private String order_no;
    private String order_amount;
    private String merchant_no;
    private String pay_tool;
    private String acct_name;
    private String card_no;

    @JSONField(name = "PAY_MODE")
    public String getPay_mod() {
        return pay_mode;
    }

    public void setPay_mode(String pay_mode) {
        this.pay_mode = pay_mode;
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

    @JSONField(name = "MERCHANT_NO")
    public String getMerchant_no() {
        return merchant_no;
    }

    public void setMerchant_no(String merchant_no) {
        this.merchant_no = merchant_no;
    }

    @JSONField(name = "PAY_TOOL")
    public String getPay_tool() {
        return pay_tool;
    }

    public void setPay_tool(String pay_tool) {
        this.pay_tool = pay_tool;
    }

    @JSONField(name = "ACCT_NAME")
    public String getAcct_name() {
        return acct_name;
    }

    public void setAcct_name(String acct_name) {
        this.acct_name = acct_name;
    }

    @JSONField(name = "CARD_NO")
    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }
}
