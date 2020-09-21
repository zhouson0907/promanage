package com.adtec.mintai.file.service;

import com.adtec.mintai.file.entity.SysFileVo;

import java.util.List;

/**
 * @version V1.0
 * @Description: 需求信息接口类
 * @author: 王林柱
 * @date: 2020-8-11 12:21:05
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface SystemFileService {

    /**
     * 查询所有需求信息
     */
    List<SysFileVo> qryAllSystemFileLists(SysFileVo fileVo);

    /**
     * 自定义语句查询需求
     *
     */
    List<SysFileVo> qrySystemFileListsPages(SysFileVo fileVo);

    /**
     * 新增需求
     */
    int addSystemFile(SysFileVo fileVo);

    /**
     * 删除需求
     */
    int delSystemFile(SysFileVo fileVo);

    /**
     * 修改需求
     */
    int updateSystemFile(SysFileVo fileVo);

    /**
     * 查询需求详情
     *
     */
    SysFileVo qrySystemFile(SysFileVo fileVo);
}
