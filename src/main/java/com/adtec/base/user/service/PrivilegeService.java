package com.adtec.base.user.service;

import com.adtec.base.user.entity.Privilege;

import java.util.List;

/**
 * @version V1.0
 * @Description: 菜单权限接口类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface PrivilegeService {

    /**
     * 查询所有权限信息
     *
     * @return
     */
    List<Privilege> getAll();

    /***
     * @Description:
     * @Param: [userId]
     * @return: java.util.List<com.adtec.base.user.entity.Privilege>
     * @Author: 周松
     * @Date: 2020/9/22
     */
    List<Privilege> getPrivilegesByUserId(String userId);

}
