package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Cow;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;
import org.apache.ibatis.annotations.Param;

public interface CowMapper extends CommonMapper<Cow> {

    Cow getCow(ReqCowIdVO vo);

    Cow getCowByNum(@Param("num") String num,@Param("farmersUid") Long farmersUid);
}