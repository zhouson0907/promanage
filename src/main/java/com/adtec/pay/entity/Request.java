package com.adtec.pay.entity;

import com.adtec.pay.util.CommUtil;
import com.alibaba.fastjson.JSONObject;

public class Request {

    protected String url;
    protected Class<? extends Response> responseClass;

    public Request(String tranCode, Class<? extends Response> responseClass) {
//            if (env.equals("dev")){
                if (tranCode.equals("HosOrderQuery")) {
                    this.url = "http://serverhost:13008/HttpServer/MEDICAL_MNG_SVR/QryOrderDetail";
                } else if (tranCode.equals("IcpPayReq")) {
                    this.url = "http://serverhost:13008/HttpServer/MEDICAL_MNG_SVR/IcpPayReq";
                } else if (tranCode.equals("QryOrderDetail")) {
                    this.url = "http://serverhost:13008/HttpServer/MEDICAL_MNG_SVR/QryOrderDetail";
                }
//            } else {
//                System.out.println("请求服务码：" + tranCode);
////                zkListener.findTranUrl(tranCode);
////                String path = zkListener.getPath();
//                String path = "";
//                ZKStatusEntity zkStatus = JSONObject.parseObject(path, ZKStatusEntity.class);
//                String zkUrl = zkStatus.getCOM_HTTP().getURL() + "/" + tranCode;
//                System.out.println("获取请求地址：" + zkUrl);
//                this.url = zkUrl;
//            }

            this.responseClass = responseClass;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setResponseClass(Class<? extends Response> responseClass) {
        this.responseClass = responseClass;
    }

    public <T> Response send(Request request) {
        return CommUtil.httpRequestJSON(url, request, responseClass);
    }

}
