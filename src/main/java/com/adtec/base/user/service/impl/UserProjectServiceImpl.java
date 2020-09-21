package com.adtec.base.user.service.impl;

import com.adtec.base.user.dao.UserMapper;
import com.adtec.base.user.dao.UserProjectMapper;
import com.adtec.base.user.entity.User;
import com.adtec.base.user.entity.UserProject;
import com.adtec.base.user.entity.UserProjectExample;
import com.adtec.base.user.service.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/4/28
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Service
public class UserProjectServiceImpl implements UserProjectService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserProjectMapper userProjectMapper;

    /**
     * 根据条件删除用户项目关联表
     */
    @Override
    public void deleteUserProjectByExample(UserProjectExample example){
        userProjectMapper.deleteByExample(example);
    }

    /**
     * 添加项目成员
     */
    @Override
    public void projectUserSave(UserProject userProject) {
        userProjectMapper.insertSelective(userProject);
    }

    /**
     * 查询公司角色为项目经理，新增项目信息时下拉显示项目经理
     */
    @Override
    public List<User> queryUserByRoleIdForProjectUser(int roleId, String roleType) {
        List<User> list = userMapper.selectUserByRoleIdForProjectUser(roleId, roleType);
        return list;
    }

}
