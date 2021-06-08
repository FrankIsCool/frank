package com.sxmaps.mms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.AuthSxDept;
import com.sxmaps.mms.model.MmsCampus;
import com.sxmaps.mms.vo.req.ReqCampusCodeVO;
import com.sxmaps.mms.vo.req.ReqDeptCodeExistVO;
import com.sxmaps.mms.vo.req.ReqDeptCodeVO;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.resp.RespCampusVO;

public interface MmsCampusMapper extends CommonMapper<MmsCampus> {
	List<RespCampusVO> qryInfoCampus();

	int qryCampusName(ReqCampusCodeVO campusCode);

	List<RespCampusVO> queryCampus();

	RespCampusVO qryCampusById(ReqMmsQueryVO mmsQueryVo);

	int qryDeptCode(ReqDeptCodeVO nameVO);

	List<RespCampusVO> qryDeptSchool(ReqDeptCodeExistVO qryNameVO);
	
	//List<RespCampusVO> qrySchoolByUser(@Param("deptId")String deptId);
	
	List<RespCampusVO> qrySchoolByUser(@Param("deptList")String[] deptList);
	
	List<AuthSxDept> queryDeptList();
}