package com.adtec.base.security.handle;

import com.adtec.base.common.Message;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        //返回json数据
        Message result = null;
        if (e instanceof AccountExpiredException) {
            //账号过期
            result = Message.fail("账号过期");
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            result = Message.fail("密码错误");
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = Message.fail("密码过期");
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = Message.fail("账号不可用");
        } else if (e instanceof LockedException) {
            //账号锁定
            result = Message.fail("账号锁定");
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = Message.fail("用户不存在");
        }else{
            //其他错误
            result = Message.fail("其他错误");
        }
        //处理编码方式，防止中文乱码的情况
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        response.getWriter().write(JSON.toJSONString(result));
    }
}
