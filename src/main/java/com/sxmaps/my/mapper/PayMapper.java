package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Pay;
import com.sxmaps.my.vo.req.pay.ReqPayListVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeListVO;
import com.sxmaps.my.vo.resp.pay.RespPayListVO;
import com.sxmaps.my.vo.resp.pay.RespPayTypeListVO;

import java.util.List;

public interface PayMapper extends CommonMapper<Pay> {

    List<RespPayListVO> getPays(ReqPayListVO vo);

}