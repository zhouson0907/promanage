package com.adtec.base.branch.controller;

import com.adtec.base.branch.entity.Department;
import com.adtec.base.common.Message;
import com.adtec.base.common.Msg;
import com.adtec.base.branch.entity.Company;
import com.adtec.base.branch.service.CompanyService;
import com.adtec.base.user.entity.User;
import com.adtec.base.user.service.UserService;
import com.adtec.base.util.Constants;
import com.adtec.daily.project.entity.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        @Autowired
        private UserService userService;

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

    /**
     * 查询当前用户所属项目下的所有用户
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/getProjectUserList", method = RequestMethod.POST)
    public Message getProjectUserList(HttpServletRequest request, HttpServletResponse response) {
        try {
            Project project = (Project) request.getSession().getAttribute("project");
            Department department = (Department) request.getSession().getAttribute("department");
            Company company = companyService.selectByDeptId(department.getDeptId());
            //TUser user = (TUser)request.getSession().getAttribute("user");
            List<User> users = userService.getAllUserByProjectIdAndCompanyId(project.getId(), company.getCompanyId(), Constants.ROLE_TYPE_PROJECT);
            return Message.success().add(users);
        } catch (NullPointerException e) {
            e.printStackTrace();
            logger.info("项目为空，查询失败");
        }
        return null;
    }
}

