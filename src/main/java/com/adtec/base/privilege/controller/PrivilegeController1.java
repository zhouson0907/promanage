package com.adtec.base.privilege.controller;

import com.adtec.base.common.Message;
import com.adtec.base.common.Msg;
import com.adtec.base.privilege.entity.Privilege1;
import com.adtec.base.privilege.service.PrivilegeService1;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhouson
 * @create 2020-09-15 18:52
 */
@Controller
public class PrivilegeController1 {
    @Autowired
    private PrivilegeService1 privilegeService1;

    private final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @ResponseBody
    @RequestMapping(value = "/privilege/findPrivilege",method = RequestMethod.GET)
    /**
     * 查询所有的权限信息
     */
    public Message findAllPvl(Privilege1 privilege1){
        PageHelper.startPage(privilege1.getPage(), privilege1.getLimit());
        List<Privilege1> list = privilegeService1.findAll();
        return Message.success().add(list);
    }
    @ResponseBody
    @RequestMapping(value = "/privilege/{privilegeId}",method = RequestMethod.GET)
    /**
     * 根据主键id查询
     */
    public Msg findByPrimaryKey(@PathVariable("privilegeId")Integer privilegeId){
            Privilege1 privilegeByPrimaryKey = null;
        try {
             privilegeByPrimaryKey = privilegeService1.findByPrimaryKey(privilegeId);
        }catch (Exception e){
            logger.info(e.getStackTrace());
            return Msg.fail();
        }
        return Msg.success().add("privilegeByPrimaryKey",privilegeByPrimaryKey);
    }
    /**
     * 删除
     * @param privilegeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/privilege/{privilegeId}",method = RequestMethod.DELETE)
    public Msg deletePvl(@PathVariable("privilegeId") Integer privilegeId){
        try {
            privilegeService1.deleteByPrimaryKey(privilegeId);
        }catch (Exception e){
            logger.info(e.getStackTrace());
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 增加、修改
     * @param privilege1
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/privilege/updatePrivilege",method = {RequestMethod.POST,RequestMethod.PUT})
    public Msg updatePvl(Privilege1 privilege1){
        try {
            privilegeService1.addAndUpdatePrivilege(privilege1);
        }catch (Exception e){
            logger.info(e.getStackTrace());
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 查询所有名称和id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/privilege/findIdAndName",method = RequestMethod.GET)
    public Msg findIdAndName(){
        return Msg.success().add("idAndNameList",privilegeService1.findIdAndName());
    }
}
