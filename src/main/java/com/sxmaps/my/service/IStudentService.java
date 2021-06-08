package com.sxmaps.mms.service;

import java.util.List;

import com.sxmaps.mms.vo.req.ReqStudentVO;
import com.sxmaps.mms.vo.resp.RespStudentListVO;
import com.sxmaps.mms.vo.resp.RespStudentVO;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年5月2日
 */
public interface IStudentService {

	/**
	 * 添加联系学员的记录
	 * 
	 * @param stuVO
	 * @return
	 */
	RespStudentVO saveStudent(ReqStudentVO stuVO);

	/**
	 * 查询联系学员的记录信息
	 * 
	 * @return
	 */
	List<RespStudentListVO> qryStudent();

}
