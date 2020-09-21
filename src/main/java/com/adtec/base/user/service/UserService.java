package com.adtec.base.user.service;

import com.adtec.base.user.entity.User;
import com.adtec.base.user.entity.UserExample;
import com.adtec.base.user.entity.UserProject;

import java.util.List;

/**
 * @version V1.0
 * @Description: 用户信息接口类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> getAll(String roleType);

    /**
     * 检验用户名密码是否可用
     *
     * @param email
     * @return  true：代表当前姓名可用   fasle：不可用
     */
    User checkUser(String email,String passwd);

    /**
     * 检验邮箱是否可用
     *
     * @param email
     * @return  true：代表当前姓名可用   fasle：不可用
     */
    boolean userCheck(String email);

    /**
     * 用户保存
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 按照用户id查询用户
     *
     * @param id
     * @return
     */
    User getUser(String id, String roleType);

    /**
     * 按照用户名查询用户
     *
     * @param email
     * @return
     */
    User getUser(String email);

    /**
     * 按照用户姓名查询用户
     *
     * @param userName
     * @return
     */
    List<User> getUserInfoByUserName(String userName);

    /**
     * 用户登录查询
     *
     * @param user
     * @return
     */
    User getLoginUser(User user);

    /**
     * 用户更新
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 通过userId获取用户
     *
     * @param userId
     */
    User getByUserId(String userId);

    /**
     * 用户删除
     *
     * @param id
     */
    void deleteUser(String id);

    /**
     * 批量删除用户
     *
     * @param ids
     */
    void deleteBatch(List<String> ids);

    /**
     * 日报列表查询
     *
     * @param example
     * @return
     */
    List<User> getUserInfoList(UserExample example);

    /**
     * 根据项目id及公司id查询项目下所有用户
     *
     * @param projectId
     * @param companyId
     * @param roleType
     * @return
     */
    List<User> getAllUserByProjectIdAndCompanyId(int projectId, int companyId, String roleType);

    /**
     * 根据用户id删除项目成员
     *
     * @param userId
     */
    void deleteByUserId(String userId,Integer userRoleId);

    /**
     * 添加项目成员
     *
     * @param userProject
     */
    void projectUserSave(UserProject userProject);

}
