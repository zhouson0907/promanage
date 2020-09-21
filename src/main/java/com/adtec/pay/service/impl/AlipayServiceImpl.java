package com.adtec.pay.service.impl;

import com.adtec.pay.service.IPayService;
import com.adtec.pay.util.Constants;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

public class AlipayServiceImpl implements IPayService {
    @Override
    public void payOrder() {
//构造client
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
//设置网关地址
        certAlipayRequest.setServerUrl("https://openapi.alipaydev.com/gateway.do");
//设置应用Id
        certAlipayRequest.setAppId(Constants.APP_ID);
//设置应用私钥
        certAlipayRequest.setPrivateKey(Constants.APP_PRIVATE_KEY);
//设置请求格式，固定值json
        certAlipayRequest.setFormat("json");
//设置字符集
        certAlipayRequest.setCharset(Constants.CHARSET);
//设置签名类型
        certAlipayRequest.setSignType("RSA2");
//设置应用公钥证书路径
        certAlipayRequest.setCertPath("E:\\Tools\\alipaykeytool\\appCertPublicKey_2016090900468072.crt");
//设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath("E:\\Tools\\alipaykeytool\\alipayCertPublicKey_RSA2.crt");
//设置支付宝根证书路径
        certAlipayRequest.setRootCertPath("E:\\Tools\\alipaykeytool\\alipayRootCert.crt");
        try {
//构造client
            AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);

//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("我是测试数据");
            model.setSubject("App支付测试Java");
            model.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
            model.setTimeoutExpress("30m");
            model.setTotalAmount("0.01");
            model.setProductCode("QUICK_MSECURITY_PAY");

            request.setBizModel(model);
            request.setNotifyUrl("");

            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            //调用成功，则处理业务逻辑
            if (response.isSuccess()) {
                System.out.println("生成订单成功");
                System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
            } else {
                System.out.println("生成订单失败");

            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }
}
