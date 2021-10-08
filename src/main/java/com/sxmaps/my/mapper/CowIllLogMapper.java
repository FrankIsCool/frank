package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.CowIllLog;
import com.sxmaps.my.vo.resp.cow.RespCowAddVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CowIllLogMapper extends CommonMapper<CowIllLog> {

    CowIllLog getIllLog(@Param("cowUid") Long cowUid);
    //统计新增生病数
    List<RespCowAddVO> statisticsIll(@Param("day") String day);
    //统计新增治愈数
    List<RespCowAddVO> statisticsCure(@Param("day") String day);
}