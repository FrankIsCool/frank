package com.sxmaps.mms.service;

import java.util.List;

import com.sxmaps.mms.vo.req.ReqAreaCodeVO;
import com.sxmaps.mms.vo.req.ReqMmsQryNameVO;
import com.sxmaps.mms.vo.req.ReqQryAreaIdByAreaNameVO;
import com.sxmaps.mms.vo.resp.RespAreaListVO;
import com.sxmaps.mms.vo.resp.RespAreaVO;
import com.sxmaps.mms.vo.resp.RespCityVO;

public interface IAreaService {

	/**
	 * 获取所有城市
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Object> qryCity() throws Exception;

	/**
	 * 通过redis缓存去读取省市区
	 * 
	 * @param key
	 * @return
	 * @throws Execption
	 */
	List<Object> qryAreaByKey(String key) throws Exception;

	/**
	 * 初始化省市区数据到redis
	 * 
	 * @return
	 * @throws Exception
	 */
	void ininArea() throws Exception;

	/**
	 * 省市区查询
	 * 
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	List<RespAreaVO> qryAreaByParentId(String parentId) throws Exception;

	/**
	 * 根据codeId查询省市区
	 * 
	 * @param mmsQueryVo
	 * @return
	 * @throws Exception
	 */
	RespAreaVO qryAreaBycodeId(ReqMmsQryNameVO mmsQryNameVo) throws Exception;

	/**
	 * 获取所有的省市区
	 * 
	 * @return
	 */
	List<RespAreaListVO> qryAreaList();
	
	/**
	 * 通过城市名称查询城市ID
	 * @param areaName
	 * @return
	 */
	RespAreaVO qryAreaIdByAreaName(ReqQryAreaIdByAreaNameVO req);

	List<RespCityVO> qryCityVO() throws Exception;

	/**
	 * 获取所有省份
	 * @return
	 */
	Object getAllProvince(ReqAreaCodeVO reqAreaCodeVO);
}
