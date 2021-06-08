package com.sxmaps.mms.mapper;

import java.util.List;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.OrdersMemberFeed;
import com.sxmaps.mms.vo.resp.RespStudentListVO;

public interface OrdersMemberFeedMapper extends CommonMapper<OrdersMemberFeed> {

	List<RespStudentListVO> qryStudentList();
}