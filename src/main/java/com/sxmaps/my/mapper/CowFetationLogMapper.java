package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.CowFetationLog;
import com.sxmaps.my.model.CowIllLog;
import com.sxmaps.my.vo.resp.cow.RespCowAddVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CowFetationLogMapper extends CommonMapper<CowFetationLog> {

    CowFetationLog getFetationLog(@Param("cowUid") Long cowUid);
    //统计新增怀孕数
    List<RespCowAddVO> statisticsFetation(@Param("day") String day);
    //统计新增分娩数
    List<RespCowAddVO> statisticsChildbirth(@Param("day") String day);
}