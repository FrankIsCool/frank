package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Cow;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;

public interface CowMapper extends CommonMapper<Cow> {

    Cow getCow(ReqCowIdVO vo);

}