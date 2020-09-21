package com.adtec.mintai.thirdPara.controller;

import com.adtec.base.common.Message;
import com.adtec.mintai.thirdPara.entity.SysThirdPara;
import com.adtec.mintai.thirdPara.entity.SysThirdParaVo;
import com.adtec.mintai.thirdPara.service.SysThirdService;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
@Controller
public class SysThirdParaController {
    private final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Resource
    private SysThirdService sysThirdService;

    @ResponseBody
    @RequestMapping(value = "/systemThird/querySystemParaLists", method = RequestMethod.POST)
    public Message querySystemFileLists(SysThirdParaVo thirdParaVo) {
        // 第三方登记表的基本信息
        List<SysThirdParaVo> tdList = sysThirdService.qryThirdParaPages(thirdParaVo);
        logger.info(new JSONObject().toJSONString(tdList));
        return Message.success().add(tdList);
    }

    @RequestMapping(value = "/EditThird/editThirdPara",method = RequestMethod.POST)
    @ResponseBody
    public Message querySystemFileLists(@RequestBody SysThirdPara sysThirdPara) {
        // 第三方登记表的基本信息
        System.out.println("====================ftpServer=============="+sysThirdPara.getFtpServer());
        int ret = sysThirdService.updateThirdPara(sysThirdPara);
        System.out.println("========================"+ret);
        return Message.success();
    }
}