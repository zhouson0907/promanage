package com.adtec.base.user.controller;

import com.adtec.base.branch.entity.Company;
import com.adtec.base.branch.entity.Department;
import com.adtec.base.branch.service.CompanyService;
import com.adtec.base.common.Message;
import com.adtec.base.user.entity.PrivilegeVo;
import com.adtec.base.user.entity.User;
import com.adtec.base.user.entity.UserRole;
import com.adtec.base.user.service.RolePrivilegeService;
import com.adtec.base.user.service.UserProjectService;
import com.adtec.base.user.service.UserRoleService;
import com.adtec.base.user.service.UserService;
import com.adtec.base.util.Constants;
import com.adtec.daily.project.entity.Project;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Description: 用户管理
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Controller
public class UserController {

    private final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    // 公钥地址
//    @Value("${conf.pubKey}")
//    private String publicKey;
    // 私钥地址
//    @Value("${conf.priKey}")
//    private String privateKey;

    @Autowired
    private UserService userService;
    @Autowired
    private UserProjectService userProjectService;
    @Autowired
    private RolePrivilegeService rolePrivilegeService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 检查邮箱是否可用
     *
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/userCheck")
    public Message userCheck(@RequestParam("email") String email) {

        //数据库邮箱重复校验
        boolean b = userService.userCheck(email);
        if (b) {
            return Message.success();
        } else {
            return Message.fail().addExtend("va_msg", "邮箱不可用");
        }
    }

    /**
     * 员工保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     *
     * @return
     */
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    @ResponseBody
    public Message saveUser(User user, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
            Map<String, Object> map = new HashMap<String, Object>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Message.fail().addExtend("errorFields", map);
        } else {
            Date updateTime = new Date();
            user.setUserId(String.valueOf(System.currentTimeMillis()));
            user.setCreateTime(updateTime);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(user.getRoleId());
            userRole.setCreateTime(updateTime);
            userRoleService.saveUserRole(userRole);
            return Message.success();
        }
    }

    /**
     * * 单个批量二合一
     * * 批量删除：1-2-3
     * * 单个删除：1
     *
     * @param ids
     * @param userRoleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/delete/{ids}/{userRoleId}", method = RequestMethod.DELETE)
    public Message updateUser(@PathVariable("ids") String ids, @PathVariable("userRoleId") Integer userRoleId) {
        //删除用户
        userService.deleteUser(ids);
        //删除用户对应的部门角色
        userRoleService.deleteUserRole(userRoleId);

        return Message.success();
    }


    /**
     * 用户更新方法
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/update/{userId}", method = RequestMethod.PUT)
    public Message updateUser(User user, HttpServletRequest request) {
        user.setUpdateTime(new Date());
        userService.updateUser(user);
        if (user.getRoleId() != null) {
            UserRole userRole = new UserRole();
            userRole.setId(user.getUserRoleId());
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(user.getRoleId());
            userRole.setUpdateTime(new Date());
            List<UserRole> userRoles = userRoleService.selectUserRole(user);
            if (userRoles.size()>0){
                userRoleService.updateUserRole(userRole);
            }else {
                userRoleService.saveUserRole(userRole);
            }
        }
        return Message.success();
    }

    /**
     * 根据id查询员工
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/selectUserById", method = RequestMethod.POST)
    public Message getUser(String id, String roleType) {
        User user = userService.getUser(id, roleType);
        return Message.success().addExtend("user", user);
    }


    /**
     * 导入jackson包。
     *
     * @param
     * @return
     */
    @RequestMapping("/user/getUsers")
    @ResponseBody
    public Message getUserWithJson(User user) {
        PageHelper.startPage(user.getPage(), user.getLimit());
        List<User> pros = userService.getAll(user.getRoleType());
        return Message.success().add(pros);
    }

    /**
     * 根据id查询用户，并分页
     *
     * @param user
     * @return
     */
    @RequestMapping("/user/getUserInfoByUserName")
    @ResponseBody
    public Message getUserInfoByUserName(User user) {
        PageHelper.startPage(user.getPage(), user.getLimit());
        List<User> pros = userService.getUserInfoByUserName(user.getUserName());
        return Message.success().add(pros);
    }

    @ResponseBody
    @RequestMapping(value = "/user/queryMenu", method = RequestMethod.POST)
    public Message queryMenu(HttpServletRequest request) {
        List<PrivilegeVo> menus = rolePrivilegeService.selectMenusByUserId(request.getParameter("userId"));

        return Message.success().add(menus);
    }

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/user/userExit", method = RequestMethod.POST)
    @ResponseBody
    public Message userExit(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return Message.fail();
        } else {
            request.getSession().removeAttribute("user");
            request.getSession().removeAttribute("project");
            request.getSession().removeAttribute("department");
            return Message.success();
        }
    }

    /**
     * 用户修改密码
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/updatePasswprd", method = RequestMethod.POST)
    public Message updatePasswprd(User user) throws Exception {
        // 查询原始用户信息
        User oriUser = userService.getByUserId(user.getUserId());
        // 原始用户密码
        String oriPassword = oriUser.getPassword();
        // 新密码
        String newPassword = user.getPassword();
        if (passwordEncoder.matches(passwordEncoder.encode(user.getOldPassword()), oriPassword)) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userService.updateUser(user);
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    /**
     * 查询公司角色为项目经理，新增项目信息时下拉显示项目经理
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/queryUserByRoleIdForProjectUser", method = RequestMethod.POST)
    public Message queryUserByRoleIdForProjectUser() {
        List<User> list = userProjectService.queryUserByRoleIdForProjectUser(Integer.parseInt(Constants.ROLE_ID_COMPANY_LEADER), Constants.ROLE_TYPE_DEPARTMENT);
        return Message.success().addExtend("pros", list);
    }

}
