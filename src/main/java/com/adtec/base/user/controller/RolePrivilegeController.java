package com.adtec.base.user.controller;

import com.adtec.base.common.Message;
import com.adtec.base.user.entity.PrivilegeVo;
import com.adtec.base.user.entity.RolePrivilege;
import com.adtec.base.user.service.RolePrivilegeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Description: 角色权限管理
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Controller
public class RolePrivilegeController {

    @Autowired
    RolePrivilegeService rolePrivilegeService;

    /**
     * 角色权限更新
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     *
     * @return
     */
    @RequestMapping(value = "/rolePrivilege/savePrivilege", method = RequestMethod.POST)
    @ResponseBody
    public Message savePrivileges(@RequestBody JSONObject jsonStr) {

        System.out.println(jsonStr.toJSONString());
        int roleId = Integer.parseInt(jsonStr.getString("roleId"));
        JSONArray privileges = jsonStr.getJSONArray("privilegeList");
        System.out.println("获取JSON权限： \n" + privileges.toJSONString());
        privileges.forEach(privilege -> {
            System.out.println(privilege.toString());
        });

        List<PrivilegeVo> privilegesLists = privileges.toJavaList(PrivilegeVo.class);

//        List<PrivilegeVo> privilegeVos = JSONArray.parseArray(privileges, PrivilegeVo.class);
//        List<PrivilegeVo> privilegeVos = JSON.parseObject(privileges, new TypeReference<List<PrivilegeVo>>() {});
        //先删除角色的权限
        rolePrivilegeService.deleteById(roleId);
        privilegesLists.forEach(privilegeVo -> {
            doPrivilege(roleId,privilegeVo);
        });
        return Message.success();
    }

    public boolean doPrivilege(int roleId, PrivilegeVo privilegeVo) {
        RolePrivilege rolePrivilege = new RolePrivilege();
        Integer privilegeId = Integer.parseInt(privilegeVo.getId());
        rolePrivilege.setPrivilegeId(privilegeId);
        rolePrivilege.setRoleId(roleId);
        rolePrivilege.setCreateTime(new Date());
        rolePrivilegeService.savePrivilege(rolePrivilege);
        for (int i = 0; i < privilegeVo.getChildren().size(); i++) {
            doPrivilege(roleId, privilegeVo.getChildren().get(i));
        }
        return true;
    }

    /**
     * 根据角色查询菜单权限
     *
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/rolePrivilege/getPrivileges", method = RequestMethod.GET)
    @ResponseBody
    public Message getPrivilegesByRoleId(String roleId, Principal user) {
        List<PrivilegeVo> list = rolePrivilegeService.queryPrivilegesByRoleId(roleId);
        return Message.success().add(list);
    }



}
