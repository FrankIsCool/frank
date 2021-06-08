package com.sxmaps.mms.service;

import java.util.List;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqOpinionVO;
import com.sxmaps.mms.vo.resp.RespOpinionVO;

/**
 * 
 * @author gongqingzhuan
 * @data 2018年3月12日
 *
 */
public interface IOpinionService {

	/**
	 * 添加评价信息
	 * 
	 * @param reqMmsOpinionVo
	 * @return
	 * @throws MmsBizException
	 */
	RespOpinionVO saveOpinion(ReqOpinionVO reqMmsOpinionVo) throws MmsBizException;

	/**
	 * 删除评价信息
	 * 
	 * @param mmsQueryVo
	 * @return
	 * @throws MmsBizException
	 */

	int deleteOpinion(ReqMmsQueryVO mmsQueryVo) throws MmsBizException;

	/**
	 * 查询点评项是否存在
	 * 
	 * @param reqOpinionVo
	 * @return
	 * @throws MmsBizException
	 */

	int findOpinionViews(ReqOpinionVO reqOpinionVo) throws MmsBizException;

	/**
	 * 查询评价信息
	 * 
	 * @return
	 * @throws MmsBizException
	 */

	List<RespOpinionVO> findOpinion() throws MmsBizException;

}
