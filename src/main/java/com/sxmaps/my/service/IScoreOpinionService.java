package com.sxmaps.mms.service;

import java.util.List;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.vo.req.ReqScoreOpinionMapVO;
import com.sxmaps.mms.vo.req.ReqScoreVO;
import com.sxmaps.mms.vo.resp.RespScoreMapVO;
import com.sxmaps.mms.vo.resp.RespScoreOpinionListVO;
import com.sxmaps.mms.vo.resp.RespScoreOpinionMapVO;

/**
 * 
 * @author gongqingzhuan
 * @data 2018年3月12日
 *
 */
public interface IScoreOpinionService {

	/**
	 * 添加星级点评信息管理
	 * 
	 * @param reqScoreOpinionMapVo
	 * @return
	 * @throws MmsBizException
	 */
	RespScoreMapVO saveScoreOpinion(ReqScoreOpinionMapVO reqScoreOpinionMapVo) throws MmsBizException;

	/**
	 * 根据评分星级获取评价信息
	 * 
	 * @param scoreId
	 * @return
	 * @throws MmsBizException
	 */
	List<RespScoreOpinionMapVO> qryScoreByOpinion(ReqScoreVO scoreVo) throws MmsBizException;

	/**
	 * 根据星级查询所有点评信息
	 * 
	 * @return
	 */
	List<RespScoreOpinionListVO> qryScoreOpinionList();
}
