/**
 * 
 */
package com.sxmaps.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.IStudentService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.req.ReqStudentVO;
import com.sxmaps.mms.vo.resp.RespStudentListVO;
import com.sxmaps.mms.vo.resp.RespStudentVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年5月2日
 */
@RestController
@RequestMapping("/student")
@Api(value = "联系学员记录管理", tags = "联系学员记录管理")
public class StudentController {

	@Autowired
	private IStudentService iStudentService;

	/**
	 * 添加联系学员的记录
	 * 
	 * @param stuVO
	 * @return
	 */
	@PostMapping(value = "saveStudent")
	@ApiOperation(notes = "保存联系学员记录管理", value = "保存联系学员记录管理", response = RespStudentVO.class)
	@ApiImplicitParam(name = "stuVO", value = "stuVO 实体", dataType = "ReqStudentVO")
	public Object saveStudent(@RequestBody @Validated ReqStudentVO stuVO) {
		try {
			return iStudentService.saveStudent(stuVO);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}

	}

	/**
	 * 查询联系学员的记录信息
	 * 
	 * @param stuVO
	 * @return
	 */
	@PostMapping(value = "qryStudent")
	@ApiOperation(notes = "查询联系学员的记录信息", value = "查询联系学员的记录信息", response = RespStudentListVO.class)
	public Object qryStudent() {
		try {
			return iStudentService.qryStudent();
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}

	}

}
