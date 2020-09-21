package com.adtec.base.user.service.impl;

import com.adtec.base.user.dao.UserRoleMapper;
import com.adtec.base.user.entity.User;
import com.adtec.base.user.entity.UserRole;
import com.adtec.base.user.entity.UserRoleExample;
import com.adtec.base.user.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @version V1.0
 * @Description: 用户角色实现类
 * @author: 张琪
 * @date: 2018/4/19
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
    UserRoleMapper userRoleMapper;

    /**
     * 保存用户角色信息
     */
    @Override
	public void saveUserRole(UserRole userRole) {
        userRoleMapper.insert(userRole);
	}

    /**
     * 用户角色更新
     */
    @Override
    public void updateUserRole(UserRole userRole) {
        userRoleMapper.updateByPrimaryKeySelective(userRole);
    }

	/**
	 * 根据roleId删除用户的部门角色信息
	 */
    @Override
	public void deleteUserRole(Integer userRoleId){
		userRoleMapper.deleteByPrimaryKey(userRoleId);
	}

    /**
     * 查询用户角色信息表
     */
    @Override
    public List<UserRole> selectUserRole(User user) {
        UserRoleExample ue = new UserRoleExample();
        UserRoleExample.Criteria uc = ue.createCriteria();
        uc.andCreateUserIdEqualTo(user.getUserId());
        uc.andRoleIdEqualTo(user.getRoleId());
        return userRoleMapper.selectByExample(ue);
    }

    /**
     * 根据条件删除用户的部门角色信息
     */
    @Override
    public void deleteUserRoleByExample(UserRoleExample example){
        userRoleMapper.deleteByExample(example);
    }

    /**
     * 查询用户角色信息表
     */
    @Override
    public List<UserRole> selectUserRole(UserRoleExample example) {
        return userRoleMapper.selectByExample(example);
    }

}
