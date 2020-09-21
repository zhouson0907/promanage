package com.adtec.base.system.controller;

import com.adtec.base.common.Message;
import com.adtec.base.system.entity.Code;
import com.adtec.base.system.entity.CodeExample;
import com.adtec.base.system.service.CodeService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/8/28
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Controller
public class CodeController {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private CodeService codeService;

    /**
     * 数字字典列表查询
     */
    @ResponseBody
    @RequestMapping(value = "/system/getCodeList", method = RequestMethod.POST)
    public Message getCodeList(Code code) throws Exception {
        List<Code> tdList = new ArrayList<>();
        try {
            PageHelper.startPage(code.getPage(),  code.getLimit());

            CodeExample example = new CodeExample();
            CodeExample.Criteria cri = example.createCriteria();

            //code名称
            if (!StringUtils.isEmpty(code.getName())) {
                cri.andNameLike("%" + code.getName() + "%");
            }
            //code类别名称
            if (!StringUtils.isEmpty(code.getKindName())) {
                cri.andKindNameLike("%" + code.getKindName() + "%");
            }

            tdList = codeService.queryCodeList(example);

            logger.info(new JSONObject().toJSONString(tdList));

            return Message.success().add(tdList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Message.fail().add(tdList);
        }
    }

    /**
     * 新增数字字典
     */
    @ResponseBody
    @RequestMapping(value = "/system/addCode", method = RequestMethod.POST)
    public Message addCode(@RequestBody Code code) throws Exception {
        List<Code> tdList = new ArrayList<>();
        try {
            //新增前查询是否有重复字典
            CodeExample example = new CodeExample();
            CodeExample.Criteria cri = example.createCriteria();
            cri.andKindCodeEqualTo(code.getKindCode());
            cri.andCodeEqualTo(code.getCode());
            cri.andNameEqualTo(code.getName());
            cri.andDeleteFlagEqualTo("0");
            List<Code> codeList = codeService.queryCodeList(example);

            if (codeList.size() <= 0) {
                //若不存在，则进行新增操作
                code.setDeleteFlag("0");
                code.setCreateTime(new Date());
                codeService.saveCode(code);

                return Message.success();
            } else {
                //若存在，则提示已存在
                return Message.dateExist();
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Message.fail().add(tdList);
        }
    }

    /**
     * 删除数字字典
     */
    @ResponseBody
    @RequestMapping(value = "/system/delCode", method = RequestMethod.POST)
    public Message delCode(@RequestBody Code code) throws Exception {
        List<Code> tdList = new ArrayList<>();
        try {
            codeService.deleteCode(code);

            return Message.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Message.fail().add(tdList);
        }
    }

    public static void main(String[] args) {

    }
}
