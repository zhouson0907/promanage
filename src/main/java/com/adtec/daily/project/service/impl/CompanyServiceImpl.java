package com.adtec.daily.project.service.impl;

import com.adtec.daily.project.dao.CompanyMapper;

import com.adtec.daily.project.entity.Company;
import com.adtec.daily.project.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyMapper companyMapper;

    /**
     * 根据部门id查询所属公司信息
     */
    @Override
    public Company selectByDeptId(int dept) {
        Company company = companyMapper.selectByDeptId(dept);
        return  company;
    }

    /**
     * 查询所有公司信息
     */
    @Override
    public List<Company> getAllCompany() {
        List<Company> list = companyMapper.selectAllCompany();
        return  list;
    }
}
