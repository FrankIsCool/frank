package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.CowIllLog;
import org.apache.ibatis.annotations.Param;

public interface CowIllLogMapper extends CommonMapper<CowIllLog> {

    CowIllLog getIllLog(@Param("cowUid") Long cowUid);

}