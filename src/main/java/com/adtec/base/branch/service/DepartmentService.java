package com.adtec.base.branch.service;

import com.adtec.base.branch.entity.Department;

import java.util.List;

/**
 * @version V1.0
 * @Description: 公司部门信息接口类
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface DepartmentService {

    /**
     * 查询部门信息
     *
     * @return
     */
    List<Department> getDepts();

    /**
     * 登陆带出部门信息
     *
     * @param userId
     * @return
     */
    Department selectByUserId(String userId);

    /**
     * 查询所属公司的所有部门信息
     *
     * @return
     */
    List<Department> getDepartmentsByCompanyId(Integer companyId);
}
