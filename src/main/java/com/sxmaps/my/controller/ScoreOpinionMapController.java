package com.sxmaps.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.IScoreOpinionService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.req.ReqScoreOpinionMapVO;
import com.sxmaps.mms.vo.req.ReqScoreVO;
import com.sxmaps.mms.vo.resp.RespScoreMapVO;
import com.sxmaps.mms.vo.resp.RespScoreOpinionMapVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/scoreOpinionMap")
@Api(tags = "星级点评信息管理", value = "星级点评信息管理")
public class ScoreOpinionMapController {

	@Autowired
	private IScoreOpinionService iScoreOpinionService;

	/**
	 * 新增星级点评信息
	 * 
	 * @param reqScoreOpinionMapVo
	 * @return
	 */
	@PostMapping("/saveScoreOpinion")
	@ApiOperation(notes = "新增星级点评信息", value = "新增星级点评信息", response = RespScoreMapVO.class)
	@ApiImplicitParam(name = "reqScoreOpinionMapVo", value = "reqScoreOpinionMapVo 实体", dataType = "ReqScoreOpinionMapVO")
	public Object saveScoreOpinion(@RequestBody @Validated ReqScoreOpinionMapVO reqScoreOpinionMapVo) {
		try {
			return iScoreOpinionService.saveScoreOpinion(reqScoreOpinionMapVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 查询星级点评信息
	 * 
	 * @param scoreId
	 * @return
	 */
	@PostMapping("/qryScoreOpinion")
	@ApiOperation(notes = "查询星级点评信息", value = "查询星级点评信息", response = RespScoreOpinionMapVO.class)
	@ApiImplicitParam(name = "scoreVo", value = "scoreVo 实体", dataType = "ReqScoreVO", paramType = "body")
	public Object qryScoreOpinion(@RequestBody @Validated ReqScoreVO scoreVo) {
		try {
			return iScoreOpinionService.qryScoreByOpinion(scoreVo);
		} catch (Exception e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}
}
