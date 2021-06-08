package com.sxmaps.mms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MmsAreaMapper;
import com.sxmaps.mms.service.IAreaService;
import com.sxmaps.mms.utils.JacksonUtil;
import com.sxmaps.mms.utils.RedisUtils;
import com.sxmaps.mms.utils.RetOut;
import com.sxmaps.mms.utils.ValidatorUtil;
import com.sxmaps.mms.vo.req.ReqAreaCodeVO;
import com.sxmaps.mms.vo.req.ReqMmsQryNameVO;
import com.sxmaps.mms.vo.req.ReqQryAreaIdByAreaNameVO;
import com.sxmaps.mms.vo.resp.RespAreaListVO;
import com.sxmaps.mms.vo.resp.RespAreaVO;
import com.sxmaps.mms.vo.resp.RespCityVO;

/**
 * 
 * 
 * @author chendehua
 *
 */
@Service
public class AreaServiceImpl implements IAreaService {

	@Autowired
	MmsAreaMapper mmsAreaMapper;

	@Autowired
	RedisUtils redisUtils;

	/**
	 * 初始化省市区数据到redis
	 * 
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RespAreaVO> qryAreaByParentId(String parentId) throws Exception {
		return mmsAreaMapper.qryByParentId(parentId);
	}

	/**
	 * 初始化省市区数据到redis
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public void ininArea() throws Exception {
		List<RespAreaVO> firstAreas = qryAreaByParentId("0");
		if (null != firstAreas && !firstAreas.isEmpty()) {
			redisUtils.del(RetOut.AREA);
			redisUtils.lSet(RetOut.AREA, firstAreas);
			for (RespAreaVO province : firstAreas) {
				List<RespAreaVO> secondAreas = qryAreaByParentId(province.getCodeId());
				if (null != secondAreas && !secondAreas.isEmpty()) {
					redisUtils.del(RetOut.AREA + province.getCodeId());
					redisUtils.lSet(RetOut.AREA + province.getCodeId(), secondAreas);
					for (RespAreaVO city : secondAreas) {
						List<RespAreaVO> threeAreas = qryAreaByParentId(city.getCodeId());
						if (null != threeAreas && !threeAreas.isEmpty()) {
							redisUtils.del(RetOut.AREA + city.getCodeId());
							redisUtils.lSet(RetOut.AREA + city.getCodeId(), threeAreas);
						}
					}
				}
			}
		}

	}

	/**
	 * 通过redis缓存去读取省市区
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Object> qryAreaByKey(String key) throws Exception {
		List<Object> areas = new ArrayList<>();
		if (StringUtils.isEmpty(key) || key.equals("0")) {
			areas = redisUtils.lGet(RetOut.AREA, 0, -1);
			if (null == areas || areas.isEmpty()) {
				ininArea();
			}
		} else {
			List<Object> areaList = redisUtils.lGet(RetOut.AREA, 0, -1);
			if (null == areaList || areaList.isEmpty()) {
				ininArea();
			}
			areas = redisUtils.lGet(RetOut.AREA + key, 0, -1);
		}
		return areas;
	}

	/**
	 * 根据codeId查询省市区
	 * 
	 * @param mmsQueryVo
	 * @return
	 * @throws Exception
	 */
	@Override
	public RespAreaVO qryAreaBycodeId(ReqMmsQryNameVO mmsQueryVo) throws Exception {
		RespAreaVO areaVO = mmsAreaMapper.qryByCodeId(mmsQueryVo.getQryName());
		if (ValidatorUtil.isEmpty(areaVO)) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库查无数据");
		}
		return areaVO;
	}

	@Override
	public List<RespAreaListVO> qryAreaList() {
		List<RespAreaListVO> areaListVOs = mmsAreaMapper.qryAreaList();
		return areaListVOs;
	}

	@Override
	public List<Object> qryCity() throws Exception {
		List<Object> citys = redisUtils.lGet(RetOut.CITY, 0, -1);
		if (null != citys && !citys.isEmpty()) {
			
			return citys;
		}
		List<Map<String, Object>> qryCity = mmsAreaMapper.qryCity();
		if (null != qryCity && !qryCity.isEmpty()) {
			redisUtils.del(RetOut.CITY);
			redisUtils.lSet(RetOut.CITY, qryCity);
			return redisUtils.lGet(RetOut.CITY, 0, -1);
		}
		return new ArrayList<>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RespCityVO> qryCityVO() throws Exception {
		List<RespCityVO> result = new ArrayList<RespCityVO>();
		List<Object> citys = redisUtils.lGet(RetOut.CITY, 0, -1);
		if (null != citys && !citys.isEmpty()) {
			List list = (List)citys.get(0);
			list.stream().forEach(city -> {
			Map	pp = (Map)city;
			result.add(RespCityVO.builder()
					.regionCode(pp.get("regionCode").toString())
					.regionName(pp.get("regionName").toString()).build());
				});
				return result;
			};
		List<Map<String, Object>> qryCity = mmsAreaMapper.qryCity();
		if (null != qryCity && !qryCity.isEmpty()) {
			redisUtils.del(RetOut.CITY);
			redisUtils.lSet(RetOut.CITY, qryCity);
			qryCity.stream().forEach(city -> {result.add(RespCityVO.builder()
					.regionCode(city.get("regionCode").toString())
					.regionName(city.get("regionName").toString()).build());
				});
			  
			return result;
		}
		return new ArrayList<>();
	}
	

	@Override
	public RespAreaVO qryAreaIdByAreaName(ReqQryAreaIdByAreaNameVO req) {
		RespAreaVO resp = mmsAreaMapper.qryAreaIdByAreaName(req);
		if (resp == null) {
			resp = new RespAreaVO();
		}
		return resp;
	}

	@Override
	public Object getAllProvince(ReqAreaCodeVO reqAreaCodeVO) {
		if(ValidatorUtil.isEmpty(reqAreaCodeVO.getAreaCode())) {
			return mmsAreaMapper.qryProvince();
		}
		
		return mmsAreaMapper.qryByParentId(reqAreaCodeVO.getAreaCode());
	}

}