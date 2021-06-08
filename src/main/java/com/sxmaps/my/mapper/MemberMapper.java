package com.sxmaps.mms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.Member;

public interface MemberMapper extends CommonMapper<Member> {

	List<Map<String,String>> getCellPhoneByUid(@Param("memberUids")List<String> memberUids);
}