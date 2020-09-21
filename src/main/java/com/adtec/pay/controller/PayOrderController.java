package com.adtec.pay.controller;

import com.adtec.pay.entity.*;
import com.adtec.pay.util.Constants;
import com.adtec.pay.util.Message;
import com.adtec.pay.util.SecretUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping(value = "/pay")
public class PayOrderController {

    @RequestMapping("/init")
    public String payChoose(HttpServletRequest request) {

//      http://localhost/pay/init?ORDER_NO=201911150001
        String order_no = request.getParameter("a");
        String sign = request.getParameter("b");

        if (!StringUtils.isEmpty(sign)) {
            try {
                sign = URLEncoder.encode(sign, "UTF-8");
                sign = URLDecoder.decode(sign, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String verifyStr = "a=" + order_no;
        System.out.println("sign=" + sign);
        System.out.println("verifyStr=" + verifyStr);
        // RSA验签
        boolean flag = SecretUtil.verifySign(Constants.APP_PUBLIC_KEY, verifyStr, sign);

        if (!flag) {
            System.out.println("验签失败");
            return "error";
        }
        CommonRequest post = new CommonRequest<OrderDetailRequestBody>("QryOrderDetail", CommonResponse.class);
        OrderDetailRequestBody body = new OrderDetailRequestBody();
        body.setORD_NO(order_no);
        post.setBODY(body);
        CommonResponse response = (CommonResponse) post.send(post);
        if (response != null) {
            System.out.println(JSONObject.toJSONString(response));
            if (response.getHEAD().getRET_CODE().equals("00000000")) {
                OrderDetailResponseBody responseBody = JSONObject.parseObject(response.getBODY().toString(), OrderDetailResponseBody.class);
                request.setAttribute("orderNo", order_no);
                request.setAttribute("totAmt", responseBody.getTOT_AMT());
                request.setAttribute("ACCT_BAL", responseBody.getACCT_BAL());
                request.setAttribute("merchantName", responseBody.getMERCHANT_NAME());
                request.setAttribute("merchantCode", responseBody.getMERCHANT_CODE());
                return "pay/choosepay.html";
            }
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/payRequest", method = RequestMethod.POST)
    public Message payRequest(@RequestBody JSONObject jsonStr) {
        System.out.println(jsonStr.toJSONString());
        String orderNo = jsonStr.getString("orderNo");
        String payMode = jsonStr.getString("payMode");
        String orderAmount = jsonStr.getString("orderAmount");
        String merchantCode = jsonStr.getString("merchantCode");

        CommonRequest post = new CommonRequest<IcpPayResponseBody>("IcpPayReq", CommonResponse.class);
        IcpPayRequestBody requestBody = new IcpPayRequestBody();
        requestBody.setPay_mode(payMode);
        requestBody.setOrder_no(orderNo);
        requestBody.setOrder_amount(orderAmount);
        requestBody.setMerchant_no(merchantCode);
        post.setBODY(requestBody);
        CommonResponse response = (CommonResponse) post.send(post);
        if (response != null) {
            System.out.println(JSONObject.toJSONString(response));
            String retCode = response.getHEAD().getRET_CODE();
            String retMSG = response.getHEAD().getRET_MSG();
            if (retCode.equals("00000000")) {
                IcpPayResponseBody responseBody = JSONObject.parseObject(response.getBODY().toString(), IcpPayResponseBody.class);
                String payUrl = responseBody.getPay_url();
                System.out.println("支付地址：" + payUrl);
                return Message.success().addExtend("url", responseBody.getPay_url());
            } else if (retCode.equals("20000000")) {
                return Message.fail(retMSG);
            }
        }
        return Message.fail("支付请求失败");
    }


    @RequestMapping("/success")
    public String success() {
        return "success";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    @RequestMapping("/passwd")
    public String password() {
        return "passwd/password.html";
    }

}
