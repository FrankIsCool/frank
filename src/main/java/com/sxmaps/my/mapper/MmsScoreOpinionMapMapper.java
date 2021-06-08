package com.sxmaps.mms.mapper;

import java.util.List;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsScoreOpinionMap;
import com.sxmaps.mms.vo.req.ReqScoreVO;
import com.sxmaps.mms.vo.resp.RespScoreOpinionListVO;
import com.sxmaps.mms.vo.resp.RespScoreOpinionMapVO;

public interface MmsScoreOpinionMapMapper extends CommonMapper<MmsScoreOpinionMap> {

	List<RespScoreOpinionMapVO> qryScoreByOpinion(ReqScoreVO scoreVo);

	List<RespScoreOpinionListVO> qryScoreOpinionList();
}