package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.StatisticsAdd;
import org.apache.ibatis.annotations.Param;

public interface StatisticsAddMapper extends CommonMapper<StatisticsAdd> {

    StatisticsAdd getYesterdayData(@Param("farmersUid") Long farmersUid);

}