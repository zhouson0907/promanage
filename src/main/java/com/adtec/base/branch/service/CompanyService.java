package com.adtec.base.branch.service;

import com.adtec.base.branch.entity.Company;

import java.util.List;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface CompanyService {

    /**
     * 根据部门id查询所属公司信息
     *
     * @param dept
     * @return
     */
    Company selectByDeptId(int dept);

    /**
     * 查出所有的公司信息
     *
     *
     * @return
     */
    List<Company> getAllCompany();


}
