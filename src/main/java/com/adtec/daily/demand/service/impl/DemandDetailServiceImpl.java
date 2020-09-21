package com.adtec.daily.demand.service.impl;


import com.adtec.daily.demand.dao.DemandDetailMapper;
import com.adtec.daily.demand.entity.DemandDetail;
import com.adtec.daily.demand.service.DemandDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DemandDetailServiceImpl implements DemandDetailService {

	@Autowired
	DemandDetailMapper demandDetailMapper;

	/**
	 * 查询所有项目信息
	 */
    @Override
	public List<DemandDetail> getDemandDetail(DemandDetail demandDetail) {
		return demandDetailMapper.selectByDemandId(demandDetail);
	}

}
