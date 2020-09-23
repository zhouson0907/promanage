package com.adtec.base.user.service.impl;

import com.adtec.base.user.dao.PrivilegeMapper;
import com.adtec.base.user.entity.Privilege;
import com.adtec.base.user.entity.PrivilegeExample;
import com.adtec.base.user.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Description: 菜单权限实现类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	@Autowired
    PrivilegeMapper privilegeMapper;

	/**
	 * 查询所有权限信息
	 */
    @Override
	public List<Privilege> getAll() {
		return privilegeMapper.selectByExample(null);
	}

	/***
	 * @Description:
	 * @Param: [userId]
	 * @return: java.util.List<com.adtec.base.user.entity.Privilege>
	 * @Author: 周松
	 * @Date: 2020/9/22
	 */
	@Override
	public List<Privilege> getPrivilegesByUserId(String userId) {
		List<Privilege> list = privilegeMapper.selectPrivilegesByUserId(userId);
		return list;
	}
}
