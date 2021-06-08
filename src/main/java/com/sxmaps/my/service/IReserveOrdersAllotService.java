package com.sxmaps.mms.service;

import java.util.List;
import java.util.Map;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.vo.TrackReservationVO;
import com.sxmaps.mms.vo.req.ReqReserveOrdersAllotVO;
import com.sxmaps.mms.vo.req.ReqTrackReservationUidVo;
import com.sxmaps.mms.vo.resp.RespOrdersAllotVO;
import com.sxmaps.mms.vo.resp.RespUserVO;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年3月16日
 */
public interface IReserveOrdersAllotService {

	/**
	 * 保存预约单分配单
	 * 
	 * @param reqReserveOrdersAllotVo
	 * @return
	 * @throws MmsBizException
	 */
	RespOrdersAllotVO saveReserveOrders(ReqReserveOrdersAllotVO reqReserveOrdersAllotVo, Map<String, Object> cur)
			throws Exception;

	/**
	 * 查询子预约单号是否已经存在
	 * 
	 * @param orderItemUid
	 * @return
	 * @throws MmsBizException
	 */
	int qryOrderItemUidById(Long orderItemUid) throws MmsBizException;

	/**
	 * 查询子预约单uid是否已经存在
	 * 
	 * @param orderItemSn
	 * @return
	 * @throws MmsBizException
	 */
	int qryOrderItemSnById(String orderItemSn) throws MmsBizException;

	/**
	 * 获取咨询师信息
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	List<RespUserVO> getReservationConsultantInfo(ReqTrackReservationUidVo vo) throws Exception;
	
	Object qryReserveOrdersInfo(TrackReservationVO trackReservationVo,Map<String, Object> user);

}
