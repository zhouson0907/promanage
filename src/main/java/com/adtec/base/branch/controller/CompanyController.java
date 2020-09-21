package com.adtec.base.branch.controller;

import com.adtec.base.common.Msg;
import com.adtec.base.branch.entity.Company;
import com.adtec.base.branch.service.CompanyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CompanyController {

    /**
     * @version V1.0
     * @Description: 公司信息
     * @author: 张琪
     * @date: 2018/4/16
     * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
     */

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

        @Autowired
        private CompanyService companyService;

        /**
         * 返回所有的公司信息
         */
        @RequestMapping(value = "/company/getAllCompany", method = RequestMethod.POST)
        @ResponseBody
        public Msg getAllCompany() {
            //查出所有公司信息
            List<Company> list = companyService.getAllCompany();
            return Msg.success().add("AllCompany", list);
        }
    }

