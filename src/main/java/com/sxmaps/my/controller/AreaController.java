package com.sxmaps.mms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.IAreaService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.AreaVO;
import com.sxmaps.mms.vo.req.ReqAreaCodeVO;
import com.sxmaps.mms.vo.req.ReqMmsQryNameVO;
import com.sxmaps.mms.vo.resp.RespAreaVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "省市区信息列表查询", value = "area")
@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	IAreaService areaService;

	/**
	 * 省市区数据 redis初始化
	 * 
	 * @param key
	 * @return
	 */
	@PostMapping("/jsonArea")
	@ApiOperation(notes = "jsonArea", value = "jsonArea")
	public Object jsonArea() {
		try {
			List<RespAreaVO> firstAreas = areaService.qryAreaByParentId("0");
			List<AreaVO> areas = new ArrayList<>();
			for (RespAreaVO vo : firstAreas) {
				AreaVO avo = new AreaVO();
				BeanUtils.copyProperties(vo, avo);
				List<RespAreaVO> citys = areaService.qryAreaByParentId(vo.getCodeId());
				List<AreaVO> childs = new ArrayList<>();
				for (RespAreaVO rv : citys) {
					AreaVO cd = new AreaVO();
					BeanUtils.copyProperties(rv, cd);
					List<RespAreaVO> countrys = areaService.qryAreaByParentId(rv.getCodeId());
					List<AreaVO> cts = new ArrayList<>();
					for (RespAreaVO ra : countrys) {
						AreaVO ct = new AreaVO();
						BeanUtils.copyProperties(ra, ct);
						cts.add(ct);
					}
					cd.setChilds(cts);
					childs.add(cd);
				}
				avo.setChilds(childs);
				areas.add(avo);
			}
			return JSONArray.toJSONString(areas);
		} catch (Exception e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, "省市区数据 redis初始化失败");
		}
	}

	/**
	 * 省市区数据 redis初始化
	 * 
	 * @param key
	 * @return
	 */
	@PostMapping("/ininArea")
	@ApiOperation(notes = "省市区数据 redis初始化", value = "省市区数据 redis初始化")
	public Object ininArea() {
		try {
			areaService.ininArea();
			return WebTools.createSuccessMessage("省市区信息redis初始化成功");
		} catch (Exception e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, "省市区数据 redis初始化失败");
		}
	}

	/**
	 * 省市区数据 redis初始化
	 * 
	 * @param key
	 * @return
	 */
	@PostMapping("/jsonCity")
	@ApiOperation(notes = "获取城市json数据", value = "获取城市json数据")
	public Object cityJson() {
		try {
			List<Object> qryCity = areaService.qryCity();
			if (null != qryCity && !qryCity.isEmpty()) {
				return JSONArray.toJSONString(qryCity);
			}
			return "";
		} catch (Exception e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, "城市json数据");
		}
	}

	/**
	 * 省市区列表信息查询
	 * 
	 * @param key
	 * @return
	 */
	@PostMapping("/qryAreaByKey")
	@ApiOperation(notes = "省市区列表信息查询", value = "省市区列表信息查询", response = RespAreaVO.class)
	@ApiImplicitParam(name = "mmsQryNameVo", value = "mmsQryNameVo 实体", dataType = "ReqMmsQryNameVO", paramType = "body")
	public Object qryAreaByKey(@RequestBody @Validated ReqMmsQryNameVO mmsQryNameVo) {
		try {
			return areaService.qryAreaByKey(mmsQryNameVo.getQryName());
		} catch (Exception e) {
			return WebTools.createErrorMessage(MmsBizException.BIZ_CODE, "");
		}
	}

	/**
	 * 根据codeId查询省市区
	 * 
	 * @param key
	 * @return
	 */
	@PostMapping("/qryAreaBycodeId")
	@ApiOperation(notes = "根据CodeId查询省市区信息", value = "根据CodeId查询省市区信息", response = RespAreaVO.class)
	@ApiImplicitParam(name = "mmsQryNameVo", value = "mmsQryNameVo 实体", dataType = "ReqMmsQryNameVO", paramType = "body")
	public Object qryAreaBycodeId(@RequestBody @Validated ReqMmsQryNameVO mmsQryNameVo) {
		try {
			return areaService.qryAreaBycodeId(mmsQryNameVo);
		} catch (Exception e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

	/**
	 * 获取所有城市
	 * 
	 * @param key
	 * @return
	 */
	@PostMapping("/qryCity")
	@ApiOperation(notes = "获取所有城市", value = "获取所有城市", response = RespAreaVO.class)
	public Object qryCity() {
		try {
			return areaService.qryCity();
		} catch (Exception e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

	/**
	 * 获取所有城市
	 *
	 * @param key
	 * @return
	 */
	@GetMapping("/qryCityVO")
	@ApiOperation(notes = "获取所有城市VO", value = "获取所有城市VO", response = RespAreaVO.class)
	public Object qryCityVO() {
		try {
			return areaService.qryCityVO();
		} catch (Exception e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

	/***
	 * 获取所有省份
	 */
	@PostMapping("getAllProvince")
	@ApiOperation(notes = "/获取所有省份",value = "/获取所有省份")
	public Object getAllProvince(@RequestBody ReqAreaCodeVO reqAreaCodeVO) {

		return areaService.getAllProvince(reqAreaCodeVO);
	}

}
