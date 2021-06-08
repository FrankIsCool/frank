package com.sxmaps.mms.mapper;

import java.util.List;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsOpinion;
import com.sxmaps.mms.vo.req.ReqOpinionVO;
import com.sxmaps.mms.vo.resp.RespOpinionVO;

public interface MmsOpinionMapper extends CommonMapper<MmsOpinion> {

	int qryOpinionViews(ReqOpinionVO reqOpinionVo);

	List<RespOpinionVO> findOpinion();
}