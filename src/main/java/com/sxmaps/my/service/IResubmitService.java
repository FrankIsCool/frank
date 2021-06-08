package com.sxmaps.mms.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.sxmaps.mms.model.MmsCallBack;
import com.sxmaps.mms.vo.req.ReqCallBackVO;
import com.sxmaps.mms.vo.req.ReqDistributionVO;
import com.sxmaps.mms.vo.req.ReqEvaluateVO;
import com.sxmaps.mms.vo.req.ReqMemberResubmitVO;
import com.sxmaps.mms.vo.req.ReqResubmitPageVO;
import com.sxmaps.mms.vo.req.ReqResubmitUidVO;
import com.sxmaps.mms.vo.resp.RespExcelResubmitVO;
import com.sxmaps.mms.vo.resp.RespMemberEvaluateVO;
import com.sxmaps.mms.vo.resp.ResqResubmitVO;

public interface IResubmitService {

	/****
	 * 转续报
	 * @param token
	 * @param req
	 * @return
	 */
	public int saveResubmitList(Map<String,Object> userInfo, List<ReqMemberResubmitVO> req);

	/****
	 * 分页查询续报学员
	 * @param pageVO
	 * @return
	 */
	PageInfo<ResqResubmitVO> getResubmitMemberByPage(ReqResubmitPageVO pageVO);

	/*****
	 * 分配学员
	 * @param userInfo
	 * @param reqDistributionVO
	 * @return
	 */
	public int allocationMember(Map<String, Object> userInfo, ReqDistributionVO reqDistributionVO);

	/****
	 * 查看分配日志
	 * @param memberUidVO
	 * @return
	 */
	public Object getResubmitLogById(ReqResubmitUidVO memberUidVO);

	/******
	 * 分页查询续报学员评价
	 * @param userInfo
	 * @param pageVO
	 * @return
	 */
	PageInfo<RespMemberEvaluateVO> getMemberEvaluateByPage(ReqResubmitPageVO pageVO);

	/*****
	 * 评价续保学员意向等级
	 * @param userInfo
	 * @param reqEvaluateVO
	 * @return
	 */
	public int evaluateMember(Map<String, Object> userInfo, ReqEvaluateVO reqEvaluateVO);

	/*****
	 *
	 * 查询咨询师评价历史信息
	 * @param reqEvaluateVO
	 * @return
	 */
	public Object getEvaluateHistoryInfo(ReqEvaluateVO reqEvaluateVO);

	/****
	 * 判断学员是否转续报
	 * @param memberUids
	 * @return
	 */
	public Object getResubmitMember(List<String> memberUids);

	/***
	 * 提交回訪記錄
	 * @param userInfo
	 * @param callBackVO
	 * @return Object
	 */
	Object saveCallInfo(Map<String, Object> userInfo, ReqCallBackVO callBackVO);

	/*****
	 *
	 * @param uidVO
	 * @return
	 */
	List<MmsCallBack> qryCallBackInfo(ReqResubmitUidVO uidVO);


	List<RespExcelResubmitVO> queryResubmitMember(ReqResubmitPageVO req);

	/***
	 * 根据子订单号导入续报学员
	 * @param userInfo
	 * @param map
	 * @return
	 */
	public void improtMemberByOrderItemSn(Map<String, Object> userInfo,List<Map<String,Object>> data) throws Exception;

}
