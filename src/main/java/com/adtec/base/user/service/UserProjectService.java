package com.adtec.base.user.service;

import com.adtec.base.user.entity.User;
import com.adtec.base.user.entity.UserProject;
import com.adtec.base.user.entity.UserProjectExample;

import java.util.List;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/4/28
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface UserProjectService {

    /**
     * 添加项目成员
     *
     * @param userProject
     */
    void projectUserSave(UserProject userProject);

    /**
     * 查询公司角色为项目经理，新增项目信息时下拉显示项目经理
     *
     * @param roleId        角色ID
     * @param roleType      角色类型
     * @return
     */
    List<User> queryUserByRoleIdForProjectUser(int roleId, String roleType);

    /**
     * 根据条件删除用户项目关联表
     *
     * @param example
     */
    void deleteUserProjectByExample(UserProjectExample example);
}
