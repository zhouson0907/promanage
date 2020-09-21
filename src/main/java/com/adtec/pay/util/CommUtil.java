package com.adtec.pay.util;


import com.adtec.pay.entity.Request;
import com.adtec.pay.entity.Response;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

public class CommUtil {

    public static Response httpRequestJSON(String url, Request bean, Class<? extends Response> classtype) {
        TypeUtils.compatibleWithJavaBean = true;
        String json = JSONObject.toJSONString(bean);
        String response = doPost(url, json);
        if (StringUtils.isEmpty(response)){
            return null;
        }
        return JSON.parseObject(response, classtype);
    }

    public static String doPost(String url, String json) {
        System.out.println("请求URL: " + url);
        System.out.println("请求JSON: " + json);
        String response = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
            StringEntity sendbody = new StringEntity(json, "utf-8");
            httpPost.setEntity(sendbody);
            HttpResponse result = httpClient.execute(httpPost);
            if (result != null) {
                HttpEntity resEntity = result.getEntity();
                if (resEntity != null) {
                    response = EntityUtils.toString(resEntity, "utf-8");
                }
            }
            System.out.println("返回数据：" + response);
            return response;

        } catch (Exception e) {
            return e.toString();
        }
    }
}
