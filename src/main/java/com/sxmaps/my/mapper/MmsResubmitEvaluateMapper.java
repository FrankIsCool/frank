package com.sxmaps.mms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsResubmitEvaluate;
import com.sxmaps.mms.vo.req.ReqResubmitPageVO;
import com.sxmaps.mms.vo.resp.RespEvaluateRantVO;
import com.sxmaps.mms.vo.resp.RespMemberEvaluateVO;

public interface MmsResubmitEvaluateMapper extends CommonMapper<MmsResubmitEvaluate> {

	public List<RespMemberEvaluateVO> getMemberEvaluateByPage(ReqResubmitPageVO pageVO);

	public List<Map<Long, String>> getEvaluateByMitUid(@Param("resubmitUids")List<Long> resubmitUids);

	public List<RespEvaluateRantVO> getHistoryEvaluate(@Param("memberUid") String memberUid);

	public RespEvaluateRantVO getEvaluateRant(@Param("memberUid") String memberUid);
}