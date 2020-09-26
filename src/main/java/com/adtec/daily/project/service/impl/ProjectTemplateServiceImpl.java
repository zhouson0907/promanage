package com.adtec.daily.project.service.impl;

import com.adtec.daily.project.dao.ProjectTemplateMapper;
import com.adtec.daily.project.entity.ProjectTemplate;
import com.adtec.daily.project.entity.ProjectTemplateExample;
import com.adtec.daily.project.service.ProjectTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTemplateServiceImpl implements ProjectTemplateService {

    @Autowired
    ProjectTemplateMapper projectTemplateMapper;

    /**
     * 查询项目信息
     */
    @Override
    public List<ProjectTemplate> selectByExample(ProjectTemplateExample example) {
        List<ProjectTemplate> list =  projectTemplateMapper.selectByExample(example);
        return list;
    }

    /**
     * 项目模板保存
     */
    @Override
    public void save(ProjectTemplate projectTemplate) {
        projectTemplateMapper.insertSelective(projectTemplate);
    }

    /**
     * 查询项目模板信息
     * @param projectIds
     * @param templateType
     * @return
     */
    @Override
    public List<ProjectTemplate> queryByExample(List<Integer> projectIds, String templateType) {
        return projectTemplateMapper.queryByExample(projectIds,templateType);
    }
}
