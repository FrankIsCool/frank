package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.EarningsType;
import com.sxmaps.my.vo.req.earnings.ReqEarningsTypeListVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsTypeAllVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsTypeListVO;

import java.util.List;

public interface EarningsTypeMapper extends CommonMapper<EarningsType> {

    EarningsType getEarningsTypeBySaleCow();

    List<RespEarningsTypeAllVO> getTypeAll();

    List<RespEarningsTypeListVO> getTypes(ReqEarningsTypeListVO vo);
}