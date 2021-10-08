package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.StatisticsAdd;
import com.sxmaps.my.model.StatisticsNum;
import org.apache.ibatis.annotations.Param;

public interface StatisticsNumMapper extends CommonMapper<StatisticsNum> {

    //增加死亡数
    StatisticsNum getStatisticsNum(@Param("farmersUid") Long farmersUid);
    //增加死亡数
    Integer addDieNum(@Param("farmersUid") Long farmersUid);
    //增加生病数
    Integer addIllNum(@Param("farmersUid") Long farmersUid);
    //增加治愈数
    Integer addCureNum(@Param("farmersUid") Long farmersUid);
    //增加售卖数
    Integer addSaleNum(@Param("farmersUid") Long farmersUid);
    //增加怀孕数
    Integer addFetationNum(@Param("farmersUid") Long farmersUid);
    //增加出生数
    Integer addBirthNum(@Param("farmersUid") Long farmersUid);
    //增加购买数
    Integer addBuyNum(@Param("farmersUid") Long farmersUid);
}