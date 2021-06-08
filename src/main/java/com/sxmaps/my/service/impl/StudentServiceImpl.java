package com.sxmaps.mms.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.OrdersMemberFeedMapper;
import com.sxmaps.mms.model.OrdersMemberFeed;
import com.sxmaps.mms.service.IStudentService;
import com.sxmaps.mms.utils.DateUtil2;
import com.sxmaps.mms.vo.req.ReqStudentVO;
import com.sxmaps.mms.vo.resp.RespStudentListVO;
import com.sxmaps.mms.vo.resp.RespStudentVO;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	OrdersMemberFeedMapper ordersMemberFeedMapper;

	/**
	 * 添加联系学员的记录
	 * 
	 * @param stuVO
	 * @return
	 */
	@Override
	public RespStudentVO saveStudent(ReqStudentVO stuVO) {
		OrdersMemberFeed memberFeed = new OrdersMemberFeed();

		// javaBean赋值
		BeanUtils.copyProperties(stuVO, memberFeed);
		memberFeed.setCreateTime(DateUtil2.currentDate());
		int result = ordersMemberFeedMapper.insert(memberFeed);

		// 添加失败
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "操作失败,添加学员记录失败");
		}

		// 显示返回的添加的参数
		RespStudentVO respStudentVO = new RespStudentVO();
		BeanUtils.copyProperties(stuVO, respStudentVO);
		return respStudentVO;
	}

	/**
	 * 查询联系学员的记录信息
	 * 
	 * @return
	 */
	@Override
	public List<RespStudentListVO> qryStudent() {
		List<RespStudentListVO> StudentListVO = ordersMemberFeedMapper.qryStudentList();
		return StudentListVO;
	}

}
