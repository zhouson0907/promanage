package com.adtec.daily.demand.service.impl;


import com.adtec.base.user.dao.UserProjectMapper;
import com.adtec.base.user.entity.UserProject;
import com.adtec.base.user.entity.UserProjectExample;
import com.adtec.daily.demand.dao.DemandTrackMapper;
import com.adtec.daily.demand.entity.DemandTrackExample;
import com.adtec.daily.demand.service.DemandTrackService;
import com.adtec.daily.demand.entity.DemandTrackVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandTrackServiceImpl implements DemandTrackService {

	@Autowired
    DemandTrackMapper demandTrackMapper;

    @Autowired
    UserProjectMapper userProjectMapper;


    @Override
    public List<DemandTrackVo> getDemandTrackList(DemandTrackVo demandTrack) {
        DemandTrackExample de = new DemandTrackExample();

        DemandTrackExample.Criteria ca = de.createCriteria();
        if (!StringUtils.isEmpty(demandTrack.getDemandId())){
            ca.andDemandIdLike("%" + demandTrack.getDemandId() + "%");
        }
        if (!StringUtils.isEmpty(demandTrack.getDemandName())){
            ca.andDemandNameLike("%" + demandTrack.getDemandName() + "%");
        }
        if (!StringUtils.isEmpty(demandTrack.getDemandStat())){
            ca.andDemandStatEqualTo(demandTrack.getDemandStat());
        }
        if (!StringUtils.isEmpty(demandTrack.getDemandRespoId())){
            ca.andDemandRespoIdEqualTo(demandTrack.getDemandRespoId());
        }
        if (!StringUtils.isEmpty(demandTrack.getVersionNum())) {
            ca.andVersionNumLike("%" + demandTrack.getVersionNum() + "%");
        }

        de.setOrderByClause("create_time desc");
        return demandTrackMapper.selectByExample(de);
    }

    /**
     * 根据自定义语句查询
     *
     * @param demandTrack
     * @return
     */
    @Override
    public List<DemandTrackVo> getDemandTrackListBySql(DemandTrackVo demandTrack) {

        // 查询用户所在项目
        UserProjectExample upe = new UserProjectExample();
        UserProjectExample.Criteria uca = upe.createCriteria();
        uca.andUserIdEqualTo(demandTrack.getUserId());
        List<UserProject> userProjectList = userProjectMapper.selectByExample(upe);
        List<String> projectId = new ArrayList<>();
        if (userProjectList.size() > 0) {
            for (UserProject userProject : userProjectList) {
                projectId.add(userProject.getProjectId().toString());
            }
        } else {
            return null;
        }


        DemandTrackExample de = new DemandTrackExample();
        DemandTrackExample.Criteria ca = de.createCriteria();

        if (projectId.size() > 0) {
            ca.andProjectIdIn(projectId);
        } else {
            return null;
        }

        PageHelper.startPage(demandTrack.getPage(), demandTrack.getLimit());

        if (!StringUtils.isEmpty(demandTrack.getDemandId())) {
            ca.andDemandIdLike("%" + demandTrack.getDemandId() + "%");
        }
        if (!StringUtils.isEmpty(demandTrack.getDemandName())) {
            ca.andDemandNameLike("%" + demandTrack.getDemandName() + "%");
        }
        if (!StringUtils.isEmpty(demandTrack.getDemandStat())) {
            ca.andDemandStatEqualTo(demandTrack.getDemandStat());
        }
        if (!StringUtils.isEmpty(demandTrack.getDemandRespoId())) {
            ca.andDemandRespoIdEqualTo(demandTrack.getDemandRespoId());
        }
        if (!StringUtils.isEmpty(demandTrack.getVersionNum())) {
            ca.andVersionNumLike("%" + demandTrack.getVersionNum() + "%");
        }

        return demandTrackMapper.select(de);
    }

    @Override
    public int addDemandTrack(DemandTrackVo demandTrack) {
        return demandTrackMapper.insertSelective(demandTrack);
    }

    @Override
    public int delDemandTrack(DemandTrackVo demandTrack) {
        return demandTrackMapper.deleteByPrimaryKey(demandTrack);
    }

    @Override
    public int updateDemandTrack(DemandTrackVo demandTrack) {
        return demandTrackMapper.updateByPrimaryKeySelective(demandTrack);
    }

    @Override
    public DemandTrackVo queryDemandTrack(DemandTrackVo demandTrack) {
        return demandTrackMapper.selectByPrimaryKey(demandTrack);
    }
}
