package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.PayType;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeListVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;
import com.sxmaps.my.vo.resp.pay.RespPayTypeAllVO;
import com.sxmaps.my.vo.resp.pay.RespPayTypeListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayTypeMapper extends CommonMapper<PayType> {

    List<RespPayTypeAllVO> getPayTypeAll();

    List<RespPayTypeListVO> getPayTypes(ReqPayTypeListVO vo);

    List<RespPayTypeAllVO> getPayTypesByType(@Param("payType") Integer payType);
}