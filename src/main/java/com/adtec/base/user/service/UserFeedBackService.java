package com.adtec.base.user.service;

import com.adtec.base.user.entity.UserFeedBack;

import java.util.List;

/**
 * @version V1.0
 * @Description: 意见反馈
 * @author: 胡浪
 * @date: 2018/4/25
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface UserFeedBackService {

    /**
     * 意见反馈
     *
     * @param userFeedBack
     */
    void putFeedBack(UserFeedBack userFeedBack);

    /**
     * 查询意见反馈信息
     */
    UserFeedBack queryUserFeedBack(String fbUser);

    /**
     * 获取反馈信息列表
     */
    List<UserFeedBack> getUserFeedBackList(final String fbDate, final String fbType, final String resultFlag);

    /**
     * 忽略反馈信息
     * @param fdId
     * @return
     */
    boolean ignoreFeedback(int fdId);

    /**
     * 处理反馈信息
     * @param fdId
     * @return
     */
    boolean fixedIssueFeedback(int fdId);
}
