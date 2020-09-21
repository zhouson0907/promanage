package com.adtec.daily.project.service.impl;


import com.adtec.daily.project.dao.DepartmentMapper;
import com.adtec.daily.project.entity.Department;
import com.adtec.daily.project.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/4/9
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询部门信息
     */
    @Override
    public List<Department> getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }

    /**
     * 登陆带出部门信息
     */
    @Override
    public Department selectByUserId(String userId) {
        Department dept = departmentMapper.selectByUserId(userId);
        return  dept;
    }

    /**
     * 查询所属公司的部门信息
     */
    @Override
    public List<Department> getDepartmentsByCompanyId(Integer companyId) {
        List<Department> list = departmentMapper.getDepartmentsByCompanyId(companyId);
        return list;
    }
}
