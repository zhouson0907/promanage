package com.adtec.base.privilege.dao;

import com.adtec.base.privilege.entity.Privilege1;

import com.adtec.base.system.entity.Code;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhouson
 * @create 2020-09-15 18:53
 */
@Mapper
public interface PrivilegeMapper1 {
    /**
     * 查询所有（分页）
     * @return
     */
    List<Privilege1> findAll();

    Privilege1 findById(String id);

    /**
     * 根据主键id删除数据
     * @param id
     * @return
     */
    @Delete("delete from t_privilege where privilege_id = #{privilegeId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加
     * @param privilege1
     * @return
     */
    int addPrivilege(Privilege1 privilege1);

    /**
     * 更新
     * @param privilege1
     * @return
     */
    int updateByPrimaryKey(Privilege1 privilege1);

    /**
     * 根据主键查询
     * @param privilegeId
     * @return
     */
    Privilege1 findByPrimaryKey(Integer privilegeId);

    /**
     * 查询所有名称
     * @return name集合
     */
    @Select("select privilege_id,name from t_privilege where menu_flag = '1'")
    List<Privilege1> findIdAndName();
}
