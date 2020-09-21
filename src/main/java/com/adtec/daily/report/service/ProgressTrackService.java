package com.adtec.daily.report.service;

import com.adtec.daily.report.entity.ProgressTrack;

import java.util.List;

/**
 * @version V1.0
 * @Description: 进度控制接口类
 * @author: 王林柱
 * @date: 2018年9月5日 21:02:11
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface ProgressTrackService {
    /**
     * 查询所有需求信息
     */
    List<ProgressTrack> getProgressTrackList(ProgressTrack progressTrack);

    /**
     * 新增需求
     */
    int addProgressTrack(ProgressTrack progressTrack);

    /**
     * 删除需求
     */
    int delProgressTrack(ProgressTrack progressTrack);

    /**
     * 修改需求
     */
    int updateProgressTrack(ProgressTrack progressTrack);

    /**
     * 查询需求详情
     */
    ProgressTrack queryProgressTrack(ProgressTrack progressTrack);
}
