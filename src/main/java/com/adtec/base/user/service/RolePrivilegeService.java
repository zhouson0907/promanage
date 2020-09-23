package com.adtec.base.user.service;

import com.adtec.base.user.entity.Privilege;
import com.adtec.base.user.entity.PrivilegeVo;
import com.adtec.base.user.entity.RolePrivilege;

import java.util.List;


/**
 * @version V1.0
 * @Description: 角色菜单接口类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface RolePrivilegeService {

    /**
     * 保存角色权限信息
     *
     * @param rolePrivilege
     */
    void savePrivilege(RolePrivilege rolePrivilege);

    /**
     * 删除角色所有权限信息
     *
     * @param roleId
     */
    void deleteById(Integer roleId);

    /**
     * 按照角色id查询权限
     *
     * @param roleId
     * @return
     */
    List<PrivilegeVo> queryPrivilegesByRoleId(String roleId);

    /**
    * 按照用户id查询用户权限列表
    * */
    List<PrivilegeVo> selectMenusByUserId(String userId);


}
