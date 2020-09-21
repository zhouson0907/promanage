package com.adtec.base.privilege.service.impl;

import com.adtec.base.privilege.dao.PrivilegeMapper1;
import com.adtec.base.privilege.entity.Privilege1;
import com.adtec.base.privilege.service.PrivilegeService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhouson
 * @create 2020-09-15 18:54
 */
@Service
public class PrivilegeService1Impl1 implements PrivilegeService1 {
    @Autowired
    private PrivilegeMapper1 privilegeMapper1;

    @Override
    public List<Privilege1> findAll() {
        List<Privilege1> list = privilegeMapper1.findAll();
        //将上级权限id修改为具体的值
        for(Privilege1 p : list){
            if(!StringUtils.isEmpty(p.getParentId())) {
                Privilege1 privilege1 = privilegeMapper1.findById(p.getParentId());
                p.setParentId(privilege1.getName());
            }
        }
        return list;
    }

    @Override
    public Privilege1 findById(String id) {
        return privilegeMapper1.findById(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return privilegeMapper1.deleteByPrimaryKey(id);
    }

    @Override
    public int addAndUpdatePrivilege(Privilege1 privilege1) {
        Privilege1 privilege = privilegeMapper1.findByPrimaryKey(privilege1.getPrivilegeId());
        if(privilege==null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            privilege1.setCreateTime(date);
            return privilegeMapper1.addPrivilege(privilege1);
        }
        return privilegeMapper1.updateByPrimaryKey(privilege1);
    }

    @Override
    public Privilege1 findByPrimaryKey(Integer privilegeId) {
        return privilegeMapper1.findByPrimaryKey(privilegeId);
    }

    @Override
    public List<Privilege1> findIdAndName() {
        return privilegeMapper1.findIdAndName();
    }
}
