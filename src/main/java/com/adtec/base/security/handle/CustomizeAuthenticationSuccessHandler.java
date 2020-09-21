package com.adtec.base.security.handle;

import com.adtec.base.common.Message;
import com.adtec.base.user.service.UserService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //更新用户表上次登录时间、更新人、更新时间等字段
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.adtec.base.user.entity.User user = userService.getByUserId(userDetails.getUsername());

        logger.info("登录成功，获取用户信息：" + user.toString());
//        user.setUpdateTime(new Date());
//        user.setUpdateUserId(user.getUserId());
//        userService.updateUser(user);

        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展
        request.setAttribute("user",user);
        response.sendRedirect(request.getContextPath() + "/main.html");

//        //返回json数据
//        Message result = Message.success();
//        //处理编码方式，防止中文乱码的情况
//        response.setContentType("application/json;charset=utf-8");
//        result.addExtend("auth" ,authentication);
//        //塞到HttpServletResponse中返回给前台
//        response.getWriter().write(JSON.toJSONString(result));
    }
}
