package com.adtec.daily.demand.controller;


import com.adtec.base.common.Message;
import com.adtec.daily.demand.service.DemandTrackService;
import com.adtec.daily.demand.vo.DemandTrackVo;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * File: DemandController
 *
 * @Author 王林柱
 * @Since 2018/8/9 14:06
 * @Ver 1.0
 */
@Controller
public class DemandTrackController {
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private DemandTrackService demandTrackService;

    @ResponseBody
    @RequestMapping(value = "/demandTrack/getDemandTrackList", method = RequestMethod.POST)
    public Message getDemandTrackList(DemandTrackVo demandTrack) {

        // 需求基本信息
        List<DemandTrackVo> tdList = demandTrackService.getDemandTrackListBySql(demandTrack);

        logger.info(toJSONString(tdList));
        return Message.success().add(tdList);
    }

    @ResponseBody
    @RequestMapping(value = "/demandTrack/addDemandTrack", method = RequestMethod.POST)
    public Message addDemandTrack(@RequestBody DemandTrackVo demandTrack) {

        DemandTrackVo demand = demandTrackService.queryDemandTrack(demandTrack);
        if (demand != null){
            demandTrack.setUpdateUserId(demandTrack.getUserId());
            demandTrack.setUpdateTime(new Date());
            demandTrackService.updateDemandTrack(demandTrack);
            return Message.success();
        }

        if (!StringUtils.isEmpty(demandTrack.getDemandRespoId())) {
            demandTrack.setDemandStat("1");
        } else {
            demandTrack.setDemandStat("0");
        }
        demandTrack.setCreateUserId(demandTrack.getUserId());
        demandTrack.setCreateTime(new Date());

        try {
            int result = demandTrackService.addDemandTrack(demandTrack);
            return Message.success();
        }catch (Exception e){
            logger.info(e.getStackTrace());
            return Message.fail();
        }
    }


    @ResponseBody
    @RequestMapping(value = "/demandTrack/delDemandTrack", method = RequestMethod.POST)
    public Message delDemandTrack(@RequestBody DemandTrackVo demandTrack) {

        try {
            int result = demandTrackService.delDemandTrack(demandTrack);
            return Message.success();
        }catch (Exception e){
            logger.info(e.getStackTrace());
            return Message.fail();
        }
    }


    // 查询需求详细信息
    @ResponseBody
    @RequestMapping(value = "/demandTrack/queryDemandTrack", method = RequestMethod.POST)
    public Message queryDemandTrack(@RequestBody DemandTrackVo demandTrack) {

        try {
            DemandTrackVo result = demandTrackService.queryDemandTrack(demandTrack);
            return Message.success().addExtend("data",result);
        }catch (Exception e){
            logger.info(e.getStackTrace());
            return Message.fail();
        }
    }

}
