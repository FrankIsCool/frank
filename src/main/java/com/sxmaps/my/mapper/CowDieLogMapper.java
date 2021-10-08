package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.CowDieLog;
import com.sxmaps.my.vo.resp.cow.RespCowAddVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CowDieLogMapper extends CommonMapper<CowDieLog> {

    //统计新增怀孕数
    List<RespCowAddVO> statisticsDie(@Param("day") String day);

}