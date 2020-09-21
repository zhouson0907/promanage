package com.adtec.mintai.file.controller;

import com.adtec.base.common.Message;
import com.adtec.base.util.ToolUtil;
import com.adtec.mintai.file.entity.SysFileVo;
import com.adtec.mintai.file.service.SystemFileService;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * File: SystemFileController
 *
 * @Author 王林柱
 * @Since 2020年8月11日11:22:45
 * @Ver 1.0
 */
@Controller
public class SystemFileController {
    private final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private SystemFileService systemFileService;

    @ResponseBody
    @RequestMapping(value = "/systemFile/querySystemFileLists", method = RequestMethod.POST)
    public Message querySystemFileLists(SysFileVo fileVo) {
        // 文件基本信息
        List<SysFileVo> tdList = systemFileService.qrySystemFileListsPages(fileVo);

        logger.info(new JSONObject().toJSONString(tdList));
        return Message.success().add(tdList);
    }

    @ResponseBody
    @RequestMapping(value = "/systemFile/addSystemFile", method = RequestMethod.POST)
    public Message addSystemFile(@RequestBody SysFileVo fileVo) {

        SysFileVo demand = systemFileService.qrySystemFile(fileVo);
        String nowTime = ToolUtil.dateFormateString(new Date(), ToolUtil.PATTERN_YYYYMMDDHHMMSS);
        if (demand != null) {
            fileVo.setUptTime(nowTime);
            systemFileService.updateSystemFile(fileVo);
            return Message.success();
        }

        fileVo.setStat("0");
        fileVo.setCrtTime(nowTime);
        try {
            systemFileService.addSystemFile(fileVo);
            return Message.success();
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            return Message.fail();
        }
    }


    @ResponseBody
    @RequestMapping(value = "/systemFile/delSystemFile", method = RequestMethod.POST)
    public Message delSystemFile(@RequestBody SysFileVo fileVo) {

        try {
            systemFileService.delSystemFile(fileVo);
            return Message.success();
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            return Message.fail();
        }
    }


    // 查询文件详细信息
    @ResponseBody
    @RequestMapping(value = "/systemFile/qrySystemFile", method = RequestMethod.POST)
    public Message qrySystemFile(@RequestBody SysFileVo fileVo) {

        try {
            SysFileVo result = systemFileService.qrySystemFile(fileVo);
            return Message.success().addExtend("data", result);
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            return Message.fail();
        }
    }

}
