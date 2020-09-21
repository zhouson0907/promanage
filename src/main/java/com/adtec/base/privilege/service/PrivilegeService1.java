package com.adtec.base.privilege.service;

import com.adtec.base.privilege.entity.Privilege1;
import java.util.List;

/**
 * @author zhouson
 * @create 2020-09-15 18:53
 */
public interface PrivilegeService1 {
    /**
     * 查询所有
     * @return
     */
    List<Privilege1> findAll();

    /**
     * 根据权限id查询权限名称
     * @param id
     * @return
     */
    Privilege1 findById(String id);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加
     * @param privilege1
     * @return
     */
    int addAndUpdatePrivilege(Privilege1 privilege1);

    /**
     * 根据主键查询
     * @param privilegeId
     * @return
     */
    Privilege1 findByPrimaryKey(Integer privilegeId);

    /**
     * 查询菜单名称
     * @return
     */
    List<Privilege1> findIdAndName();
}
