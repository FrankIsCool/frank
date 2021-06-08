/**
 * 
 */
package com.sxmaps.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.IScoreStarService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.resp.RespScoreStarVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年3月21日
 */
@RestController
@RequestMapping("/scoreStar")
@Api(value = "评分星级管理", tags = "评分星级管理")
public class ScoreStarController {
	@Autowired
	private IScoreStarService iScoreStarService;

	/**
	 * 获取评分星级列表
	 * 
	 * @return
	 */

	@PostMapping("/qryScoreStar")
	@ApiOperation(notes = "获取评分星级列表", value = "获取评分星级列表", response = RespScoreStarVO.class)
	public Object qryScoreStar() {
		try {
			return iScoreStarService.qryScoreStar();
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}
}
