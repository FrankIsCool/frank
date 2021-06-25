package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Cow;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;
import com.sxmaps.my.vo.req.cow.ReqCowListVO;
import com.sxmaps.my.vo.resp.cow.RespCowCollectVO;
import com.sxmaps.my.vo.resp.cow.RespCowListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CowMapper extends CommonMapper<Cow> {

    Cow getCow(@Param("cowUid") Long cowUid,@Param("farmersUid") Long farmersUid);

    Cow getCowByNum(@Param("num") String num,@Param("farmersUid") Long farmersUid);

    Integer getCowAllCount(@Param("farmersUid") Long farmersUid);

    Integer getCowLivestockNum(@Param("farmersUid") Long farmersUid);

    Integer getCowLifeCount(@Param("cowLife") Integer cowLife,@Param("farmersUid") Long farmersUid);

    Integer getCowIllCount(@Param("illState") Integer illState,@Param("farmersUid") Long farmersUid);

    Integer getCowFetationCount(@Param("fetationState") Integer fetationState,@Param("farmersUid") Long farmersUid);

    Integer getCowNormalCount(@Param("farmersUid") Long farmersUid);

    List<RespCowCollectVO> getCowCountCollect(@Param("farmersUids") List<Long> farmersUids,@Param("kindUids") List<Long> kindUids, @Param("createTime") String createTime);

    Integer getCowCountBySex(@Param("sex") Integer sex,@Param("farmersUid") Long farmersUid);

    List<RespCowListVO> getCows(ReqCowListVO vo);
}