package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.EarningsType;

public interface EarningsTypeMapper extends CommonMapper<EarningsType> {

    EarningsType getEarningsTypeBySaleCow();

}