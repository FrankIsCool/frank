package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Farmers;
import com.sxmaps.my.vo.req.farmers.ReqFarmersListVO;
import com.sxmaps.my.vo.resp.farmers.RespFarmersListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FarmersMapper extends CommonMapper<Farmers> {
    //牧场列表
    List<RespFarmersListVO> getFarmersList(ReqFarmersListVO vo);

    //牧场列表
    List<Farmers> getFarmersAll(@Param("lastTime") String lastTime);
}