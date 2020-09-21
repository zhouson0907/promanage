package com.adtec.mintai.file.service.impl;

import com.adtec.mintai.file.entity.SysFileExample;
import com.adtec.mintai.file.entity.SysFileVo;
import com.adtec.mintai.file.dao.SysFileMapper;
import com.adtec.mintai.file.service.SystemFileService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SystemFileServiceImpl implements SystemFileService {

    @Autowired
    SysFileMapper sysFileMapper;

    @Override
    public List<SysFileVo> qryAllSystemFileLists(SysFileVo fileVo) {
        SysFileExample de = new SysFileExample();
        SysFileExample.Criteria ca = de.createCriteria();

        if (!StringUtils.isEmpty(fileVo.getPlatDate())) {
            ca.andPlatDateEqualTo(fileVo.getPlatDate());
        }
        if (!StringUtils.isEmpty(fileVo.getStat())) {
            ca.andStatEqualTo(fileVo.getStat());
        }
        if (!StringUtils.isEmpty(fileVo.getFileType())) {
            ca.andFileTypeEqualTo(fileVo.getFileType());
        }
        if (!StringUtils.isEmpty(fileVo.getSysCode())) {
            ca.andSysCodeEqualTo(fileVo.getSysCode());
        }

        de.setOrderByClause("crt_time desc");
        return sysFileMapper.selectByExample(de);
    }

    /**
     * 带分页的查询语句
     *
     * @param fileVo
     * @return
     */
    @Override
    public List<SysFileVo> qrySystemFileListsPages(SysFileVo fileVo) {

        // 查询用户所在项目
        SysFileExample de = new SysFileExample();
        SysFileExample.Criteria ca = de.createCriteria();

        PageHelper.startPage(fileVo.getPage(), fileVo.getLimit());

        if (!StringUtils.isEmpty(fileVo.getPlatDate())) {
            ca.andPlatDateEqualTo(fileVo.getPlatDate().replaceAll("-", ""));
        }
        if (!StringUtils.isEmpty(fileVo.getStat())) {
            ca.andStatEqualTo(fileVo.getStat());
        }
        if (!StringUtils.isEmpty(fileVo.getFileType())) {
            ca.andFileTypeEqualTo(fileVo.getFileType());
        }
        if (!StringUtils.isEmpty(fileVo.getFileNm())) {
            ca.andFileNmEqualTo(fileVo.getFileNm());
        }
        if (!StringUtils.isEmpty(fileVo.getSysCode())) {
            ca.andSysCodeEqualTo(fileVo.getSysCode());
        }

        de.setOrderByClause("crt_time desc");
        return sysFileMapper.selectByExample(de);
    }

    @Override
    public int addSystemFile(SysFileVo fileVo) {
        return sysFileMapper.insertSelective(fileVo);
    }

    @Override
    public int delSystemFile(SysFileVo fileVo) {
        return sysFileMapper.deleteByPrimaryKey(fileVo);
    }

    @Override
    public int updateSystemFile(SysFileVo fileVo) {
        return sysFileMapper.updateByPrimaryKey(fileVo);
    }

    @Override
    public SysFileVo qrySystemFile(SysFileVo fileVo) {
        return sysFileMapper.selectByPrimaryKey(fileVo);
    }
}
