package com.adtec.mintai.thirdPara.service;


import com.adtec.mintai.thirdPara.entity.SysThirdPara;
import com.adtec.mintai.thirdPara.entity.SysThirdParaVo;

import java.util.List;

public interface SysThirdService {
    /**
     * 自定义语句查询需求(查询t_sys_third_para表中所有数据)
     *
     * @return
     */
    List<SysThirdParaVo> qryThirdParaPages(SysThirdParaVo fileVo);

    /**
     * 自定义语句查询需求(根据SYSCODE更改表记录)
     *
     * @return
     */
    int updateThirdPara(SysThirdPara sysThirdPara);
}
