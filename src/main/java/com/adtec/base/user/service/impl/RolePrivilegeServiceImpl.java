package com.adtec.base.user.service.impl;

import com.adtec.base.user.dao.PrivilegeMapper;
import com.adtec.base.user.dao.RolePrivilegeMapper;
import com.adtec.base.user.entity.*;
import com.adtec.base.user.service.RolePrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @version V1.0
 * @Description: 角色菜单实现类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Service
public class RolePrivilegeServiceImpl implements RolePrivilegeService {

    @Autowired
    RolePrivilegeMapper rolePrivilegeMapper;
    @Autowired
    PrivilegeMapper privilegeMapper;

    /**
     * 保存角色权限信息
     */
    @Override
    public void savePrivilege(RolePrivilege rolePrivilege) {
        rolePrivilegeMapper.insert(rolePrivilege);
    }

    /**
     * 删除角色所有权限信息
     */
    @Override
    public void deleteById(Integer roleId) {
        RolePrivilegeExample example = new RolePrivilegeExample();
        RolePrivilegeExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        int t = rolePrivilegeMapper.deleteByExample(example);
        System.out.println(t);
    }

    /**
     * 按照角色id查询权限
     */
    @Override
    public List<PrivilegeVo> queryPrivilegesByRoleId(String roleId) {
        List<PrivilegeVo> privilegeVolists = new LinkedList<>();
        // 角色权限
        List<Privilege> rolePrivileges = privilegeMapper.selectPrivilegesByRoleId(roleId);

        // 全部权限
        List<Privilege> allRolePrivileges = privilegeMapper.selectByExample(null);


        HashMap<String, PrivilegeVo> map = new HashMap<>();
        allRolePrivileges.forEach(ap -> {
            PrivilegeVo pv = new PrivilegeVo();
            pv.setId(String.valueOf(ap.getPrivilegeId()));
            pv.setCode(ap.getCode());
//            pv.setEnable(ap.getEnabled() == 1 ? "true" : "false");
            pv.setHref(ap.getUrl());
            pv.setTitle(ap.getName());
            pv.setIcon(ap.getMenuImage());
            pv.setSortNo(ap.getSortNo());
            pv.setChecked(rolePrivileges.contains(ap));
            pv.setParentId(ap.getParentId());
            map.put(pv.getId(), pv);
        });

        // 处理子菜单
        map.forEach((key, value) -> {
            if (!StringUtils.isEmpty(value.getParentId())) {
                String parentId = value.getParentId();
                map.get(parentId).getChildren().add(value);
            }
        });

        // 处理父菜单
        map.forEach((key, value) -> {
            if (StringUtils.isEmpty(value.getParentId())) {
                privilegeVolists.add(value);
            }
        });

        // 根据sortNo排序
        Collections.sort(privilegeVolists, new Comparator<PrivilegeVo>() {
            @Override
            public int compare(PrivilegeVo o1, PrivilegeVo o2) {
                int i = Integer.valueOf(o1.getSortNo()) - Integer.valueOf(o2.getSortNo());
                return i;
            }
        });

        return privilegeVolists;
    }


    /**
     * 按照用户id查询权限列表
     */
    @Override
    public List<PrivilegeVo> selectMenusByUserId(String userId) {
        List<PrivilegeVo> privilegeVoslist = new LinkedList<>();
        List<Privilege> parents = privilegeMapper.selectPrivilegesByUserId(userId);

        for (Privilege parent : parents) {
            PrivilegeVo privilegeVo = new PrivilegeVo();
            if (parent.getParentId() == null) {
                privilegeVo.setCode(parent.getCode());
                if (parent.getEnabled() == 1) {
                    privilegeVo.setEnable("true");
                } else {
                    privilegeVo.setEnable("false");
                }
                privilegeVo.setParentId(parent.getParentId());
                privilegeVo.setTitle(parent.getName());
                privilegeVo.setId(parent.getSortNo());
                privilegeVo.setIcon(parent.getMenuImage());
                privilegeVo.setHref(parent.getUrl());

                String menuId = parent.getPrivilegeId().toString();
                for (Privilege parent1 : parents) {
                    if (menuId.equals(parent1.getParentId())) {
                        PrivilegeVo privilegeVoSon = new PrivilegeVo();
                        int i = 0;
                        privilegeVoSon.setCode(parent1.getCode());
                        if (parent1.getEnabled() == 1) {
                            privilegeVoSon.setEnable("true");
                        } else {
                            privilegeVoSon.setEnable("false");
                        }
                        privilegeVoSon.setParentId(parent1.getParentId());
                        privilegeVoSon.setTitle(parent1.getName());
                        privilegeVoSon.setId(parent1.getSortNo());
                        privilegeVoSon.setIcon(parent1.getMenuImage());
                        privilegeVoSon.setHref(parent1.getUrl());

                        privilegeVo.getChildren().add(privilegeVoSon);
                    }
                }
                privilegeVoslist.add(privilegeVo);
            } else {
                continue;
            }
        }
        return privilegeVoslist;
    }

}
