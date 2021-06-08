package com.sxmaps.mms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsResubmitList;
import com.sxmaps.mms.vo.resp.RespDistributionLog;

public interface MmsResubmitListMapper extends CommonMapper<MmsResubmitList> {


	public List<RespDistributionLog> getResubmitLog(@Param("memberId")String memberId);
}