package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Earnings;
import com.sxmaps.my.vo.req.earnings.ReqEarningsListVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsCollectInfoVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EarningsMapper extends CommonMapper<Earnings> {

    List<RespEarningsListVO> getEarnings(ReqEarningsListVO vo);

    List<RespEarningsCollectInfoVO> earningsCollect(@Param("earningsTypeUids") List<Long> earningsTypeUids, @Param("farmersUid") Long farmersUid);


}