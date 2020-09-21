package com.adtec.daily.project.service;

import com.adtec.daily.project.entity.ProjectTemplate;
import com.adtec.daily.project.entity.ProjectTemplateExample;

import java.util.List;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
public interface ProjectTemplateService {
    /**
     *  查询项目模板信息
     *
     * @param example
     * @return
     */
    List<ProjectTemplate> selectByExample(ProjectTemplateExample example);

    /**
     * 项目模板保存
     *
     * @param projectTemplate
     */
    void save(ProjectTemplate projectTemplate);
}
