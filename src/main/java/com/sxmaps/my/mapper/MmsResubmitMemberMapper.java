package com.sxmaps.mms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.common.InsertUidListMapper;
import com.sxmaps.mms.model.MmsResubmitMember;
import com.sxmaps.mms.vo.req.ReqDistributionVO;
import com.sxmaps.mms.vo.req.ReqResubmitPageVO;
import com.sxmaps.mms.vo.resp.RespExcelResubmitVO;
import com.sxmaps.mms.vo.resp.ResqResubmitVO;

public interface MmsResubmitMemberMapper extends CommonMapper<MmsResubmitMember>{

	public List<Map<String,String>> getResubmitUid(@Param("memberUids")List<String> memberUids);

	public List<ResqResubmitVO> resubmitMemberMapper(ReqResubmitPageVO pageVO);

	public int updateConsultInfo(ReqDistributionVO reqDistributionVO);

	public List<String> getResubmitUids(@Param("memberUid")String memberUid);

	public List<RespExcelResubmitVO> importMemberMapper(ReqResubmitPageVO pageVO);

	@Select("SELECT COUNT(*) FROM `mms_resubmit_member` WHERE `member_uid` = #{memberUid}")
	public int selectCountByMemberUid(@Param("memberUid")String memberUid);
}