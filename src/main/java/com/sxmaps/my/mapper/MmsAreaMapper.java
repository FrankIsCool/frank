package com.sxmaps.mms.mapper;

import java.util.List;
import java.util.Map;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsArea;
import com.sxmaps.mms.vo.req.ReqQryAreaIdByAreaNameVO;
import com.sxmaps.mms.vo.resp.RespAreaListVO;
import com.sxmaps.mms.vo.resp.RespAreaVO;

public interface MmsAreaMapper extends CommonMapper<MmsArea> {

	/**
	 * @param parentId
	 * @return
	 */
	List<RespAreaVO> qryByParentId(String parentId);

	/**
	 * 获取城市
	 * 
	 * @return
	 */
	List<Map<String, Object>> qryCity();

	RespAreaVO qryByCodeId(String codeId);

	List<RespAreaListVO> qryAreaList();
	
	/**
	 * 通过城市名称查询城市ID
	 * @param areaName
	 * @return
	 */
	RespAreaVO qryAreaIdByAreaName(ReqQryAreaIdByAreaNameVO req);

	List<RespAreaVO> qryProvince();
}