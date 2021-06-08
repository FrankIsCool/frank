/**
 * 
 */
package com.sxmaps.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.ISettingService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.MessageVO;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqSettingNameVO;
import com.sxmaps.mms.vo.req.ReqSettingVO;
import com.sxmaps.mms.vo.resp.RespSettVO;
import com.sxmaps.mms.vo.resp.RespSettingVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author gongqingzhuan
 * @data 2018年3月12日
 *
 */
@RestController
@RequestMapping("/setting")
@Api(value = "类别管理", tags = "类别管理")
public class SettingController {

	@Autowired
	private ISettingService iSettingService;

	/**
	 * 保存类别
	 * 
	 * @param settingVo
	 * @return
	 */
	@PostMapping("/saveSetting")
	@ApiOperation(notes = "保存类别", value = "保存类别", response = RespSettVO.class)
	@ApiImplicitParam(name = "settingVo", value = "settingVo 实体", dataType = "ReqSettingVO")
	public Object saveSetting(@RequestBody @Validated ReqSettingVO settingVo) {
		try {
			return iSettingService.saveSetting(settingVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 删除类别
	 * 
	 * @param mmsQueryVo
	 * @return
	 */
	@PostMapping("/deleteSetting")
	@ApiOperation(notes = "删除类别", value = "删除类别", response = MessageVO.class)
	@ApiImplicitParam(name = "mmsQueryVo", value = "mmsQueryVo 实体", dataType = "ReqMmsQueryVO")
	public Object deleteSetting(@RequestBody @Validated ReqMmsQueryVO mmsQueryVo) {
		try {
			return iSettingService.deleteSetting(mmsQueryVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 查询类别信息
	 * 
	 * @param mmsQueryVo
	 * @return
	 */
	@PostMapping("/findSetting")
	@ApiOperation(notes = "查询类别信息", value = "查询类别信息", response = RespSettingVO.class)
	public Object findSetting() {
		try {
			return iSettingService.findSetting();
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

	/**
	 * 查询类别名称是否存在
	 * 
	 * @param mmsQueryVo
	 * @return
	 */
	@PostMapping("/qrySettingName")
	@ApiOperation(notes = "查询类别名称是否存在", value = "查询类别名称是否存在", response = MessageVO.class)
	@ApiImplicitParam(name = "settingNameVo", value = "settingNameVo 实体", dataType = "ReqSettingNameVO")
	public Object qrySettingName(@RequestBody @Validated ReqSettingNameVO settingNameVo) {
		try {
			return iSettingService.qrySettingName(settingNameVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 根据类型ID查询类别值
	 * 
	 * @param mmsQueryVo
	 * @return
	 */
	@PostMapping("/qrySettingByCategoryId")
	@ApiOperation(notes = "根据类型ID查询类别值", value = "根据类型ID查询类别值", response = RespSettingVO.class)
	@ApiImplicitParam(name = "mmsQueryVo", value = "mmsQueryVo 实体", dataType = "ReqMmsQueryVO")
	public Object qrySettingByCategoryId(@RequestBody @Validated ReqMmsQueryVO mmsQueryVo) {
		try {
			return iSettingService.qrySettingByCategoryId(mmsQueryVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}
}
