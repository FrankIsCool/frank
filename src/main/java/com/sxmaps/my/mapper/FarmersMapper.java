package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Farmers;
import com.sxmaps.my.vo.req.farmers.ReqFarmersListVO;
import com.sxmaps.my.vo.resp.farmers.RespFarmersListVO;

import java.util.List;

public interface FarmersMapper extends CommonMapper<Farmers> {
    //分期列表
    List<RespFarmersListVO> getFarmersList(ReqFarmersListVO vo);

}