package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Weight;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;
import com.sxmaps.my.vo.resp.cow.RespCowListWeigthVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WeightMapper extends CommonMapper<Weight> {

    List<RespCowListWeigthVO> getWeights(@Param("cowUids") List<Long> cowUids);

}