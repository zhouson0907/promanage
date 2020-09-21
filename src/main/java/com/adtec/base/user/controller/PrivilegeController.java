package com.adtec.base.user.controller;

import com.adtec.base.common.Msg;
import com.adtec.base.user.entity.Privilege;
import com.adtec.base.user.service.PrivilegeService;
import com.adtec.base.user.service.RolePrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version V1.0
 * @Description: 权限相关类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Controller
public class PrivilegeController {


    @Autowired
    PrivilegeService privilegeService;
    @Autowired
    RolePrivilegeService rolePrivilegeService;

    /**
     * 获取权限列表。
     *
     * @return
     */
    @RequestMapping("/privilege/getPrivileges")
    @ResponseBody
    public Msg getPrivileges() {
        List<Privilege> pros = privilegeService.getAll();
        return Msg.success().add("resultList", pros);
    }


}
