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
import com.sxmaps.mms.service.IOpinionService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.MessageVO;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqOpinionVO;
import com.sxmaps.mms.vo.resp.RespOpinionVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author gongqingzhuan
 * @data 2018年3月12日
 *
 */
@RestController
@RequestMapping("/opinion")
@Api(value = "评价管理", tags = "评价管理")
public class OpinionController {

	@Autowired
	private IOpinionService iOpinionService;

	/**
	 * 保存评价信息
	 * 
	 * @param reqOpinionVo
	 * @return
	 */
	@PostMapping("/saveOpinion")
	@ApiOperation(notes = "保存评价信息", value = "保存评价信息", response = RespOpinionVO.class)
	@ApiImplicitParam(name = "reqOpinionVo", value = "reqOpinionVo 实体", dataType = "ReqOpinionVO")
	public Object saveOpinion(@RequestBody @Validated ReqOpinionVO reqOpinionVo) {
		try {
			return iOpinionService.saveOpinion(reqOpinionVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 删除评价信息
	 * 
	 * @param uid
	 * @return
	 */
	@PostMapping("/deleteOpinion")
	@ApiOperation(notes = "删除评价信息", value = "删除评价信息", response = MessageVO.class)
	@ApiImplicitParam(name = "mmsQueryVo", value = "mmsQueryVo 实体", dataType = "ReqMmsQueryVO", paramType = "body")
	public Object deleteOpinion(@RequestBody @Validated ReqMmsQueryVO mmsQueryVo) {
		try {
			return iOpinionService.deleteOpinion(mmsQueryVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 查询点评项是否存在
	 * 
	 * @param reqOpinionVo
	 * @return
	 */
	@PostMapping("/findOpinionViews")
	@ApiOperation(notes = "查询点评项是否存在", value = "查询点评项是否存在", response = MessageVO.class)
	@ApiImplicitParam(name = "reqOpinionVo", value = "reqOpinionVo 实体", dataType = "ReqOpinionVO")
	public Object findOpinionViews(@RequestBody @Validated ReqOpinionVO reqOpinionVo) {
		try {
			return iOpinionService.findOpinionViews(reqOpinionVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 查询评价信息
	 * 
	 * @return
	 */
	@PostMapping("/findOpinion")
	@ApiOperation(notes = "查询评价信息", value = "查询评价信息", response = RespOpinionVO.class)
	public Object findOpinion() {
		try {
			return iOpinionService.findOpinion();
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

}
