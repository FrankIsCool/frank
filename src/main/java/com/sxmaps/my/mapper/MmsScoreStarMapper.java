package com.sxmaps.mms.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxmaps.mms.vo.resp.RespProtocolInfoVO;
import org.apache.ibatis.annotations.Param;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsScoreStar;
import com.sxmaps.mms.vo.req.ReqProtocolLevelVO;
import com.sxmaps.mms.vo.resp.RespProtocolLevelVO;
import com.sxmaps.mms.vo.resp.RespProtocolVO;
import com.sxmaps.mms.vo.resp.RespScoreStarVO;

public interface MmsScoreStarMapper extends CommonMapper<MmsScoreStar> {

	List<RespScoreStarVO> qryScoreStar();

	/**
	 * 查询订单协议详情
	 * 
	 * @return
	 */
	RespProtocolVO qryProtocolByOrderItemSn(@Param("orderItemSn") String orderItemSn);

	/**
	 * 查询订单协议详情-电审之前获取
	 *
	 * @return
	 */
	RespProtocolInfoVO qryProtocolByOrderItemSn2(@Param("orderItemSn") String orderItemSn);

	RespProtocolLevelVO qryProtocolByProLevel(ReqProtocolLevelVO levelVO);
	
	/**
	 * 查询订单首付金额
	 * @param orderSn
	 * @return
	 */
	BigDecimal qryFirstPayByOrderSn(@Param("orderSn")String orderSn,@Param("percent")Double percent);
	
	/**
	 * 查询订单首付金额
	 * @param orderSn
	 * @return
	 */
	BigDecimal qryLoanPayByOrderSn(@Param("orderSn")String orderSn,@Param("percent")Double percent);
	
	/**
	 * 查询订单金额与子订单金额
	 * @param orderItemId
	 * @return
	 */
	Map<String,Object> qryItemAmountAndPaidAmount(@Param("orderItemSn")String orderItemSn);
	
	/**
	 * 计算订单子订单数量
	 * @param orderSn
	 * @return
	 */
	Integer countOrderItemByOrderSn(@Param("orderSn") String orderSn);
	
	/**
	 * 查询是否有变更过得协议
	 * @param orderItemId
	 * @return
	 */
	Integer countExchangedContract(@Param("orderItemId")Long orderItemId);

}