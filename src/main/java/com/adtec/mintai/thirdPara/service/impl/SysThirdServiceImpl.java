package com.adtec.mintai.thirdPara.service.impl;

import com.adtec.mintai.thirdPara.entity.SysThirdPara;
import com.adtec.mintai.thirdPara.entity.SysThirdParaExample;
import com.adtec.mintai.thirdPara.entity.SysThirdParaVo;
import com.adtec.mintai.thirdPara.dao.SysThirdParaMapper;
import com.adtec.mintai.thirdPara.service.SysThirdService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class SysThirdServiceImpl implements SysThirdService {
    @Autowired
    SysThirdParaMapper sysThirdParaMapper;        /*Service接口调用的是dao层里面数据库的方法*/


    @Override
    public List<SysThirdParaVo> qryThirdParaPages(SysThirdParaVo thirdParaVo) {
        //根据条件查询所有第三方登记表的所有信息.
        SysThirdParaExample de = new SysThirdParaExample();
        SysThirdParaExample.Criteria ca = de.createCriteria();

        PageHelper.startPage(thirdParaVo.getPage(), thirdParaVo.getLimit());

        if (!StringUtils.isEmpty(thirdParaVo.getSysCode())) {     //校验系统编码是否为空
            ca.andSysCodeEqualTo(thirdParaVo.getSysCode());
        }

        if (!StringUtils.isEmpty(thirdParaVo.getStat())) {        //检验系统状态是否为空
            ca.andStatEqualTo(thirdParaVo.getStat());
        }

        if (!StringUtils.isEmpty(thirdParaVo.getBusiNo())) {      //校验行业编码是否为空
            ca.andBusiNoEqualTo(thirdParaVo.getBusiNo());
        }

        if (!StringUtils.isEmpty(thirdParaVo.getSysCode())) {    //校验系统编号是否为空
            ca.andSysCodeEqualTo(thirdParaVo.getSysCode());
        }
        de.setOrderByClause("create_time desc");
        return sysThirdParaMapper.selectByExample(de);
    }

   @Override
    public int updateThirdPara(SysThirdPara sysThirdPara) {
        return sysThirdParaMapper.updateThirdParaBySysCode(sysThirdPara);
    }
}
