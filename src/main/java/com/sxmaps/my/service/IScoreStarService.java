package com.sxmaps.mms.service;

import java.util.List;

import com.sxmaps.mms.vo.resp.RespScoreStarVO;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年3月21日
 */
public interface IScoreStarService {
	/**
	 * 获取评分星级列表
	 * 
	 * @param
	 * @return
	 */
	List<RespScoreStarVO> qryScoreStar();
}
