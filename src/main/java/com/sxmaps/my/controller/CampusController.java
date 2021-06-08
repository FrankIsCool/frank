/**
 * 
 */
package com.sxmaps.mms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.ICampusService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.CampusVO;
import com.sxmaps.mms.vo.MessageVO;
import com.sxmaps.mms.vo.QueryInfoVO;
import com.sxmaps.mms.vo.req.ReqCampusCodeVO;
import com.sxmaps.mms.vo.req.ReqCampusVO;
import com.sxmaps.mms.vo.req.ReqDeptCodeExistVO;
import com.sxmaps.mms.vo.req.ReqDeptCodeVO;
import com.sxmaps.mms.vo.req.ReqMmsMassVO;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.resp.RespCampuVO;
import com.sxmaps.mms.vo.resp.RespCampusVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author gongqingzhuan
 * @data 2018年3月12日
 *
 */
@RestController
@RequestMapping("/campus")
@Api(value = "分校管理", tags = "分校管理")
public class CampusController extends BaseController {

	@Autowired
	private ICampusService iCampusService;
	// @Autowired
	// private OrgStructureClient orgStructureClient;

	/**
	 * 添加分校管理信息
	 * 
	 * @param reqCampusVo
	 * @return
	 */

	@PostMapping("/saveCampus")
	@ApiOperation(notes = "保存分校管理", value = "保存分校管理", response = RespCampuVO.class)
	@ApiImplicitParam(name = "reqCampusVo", value = "reqCampusVo 实体", dataType = "ReqCampusVO")
	public Object saveCampus(@RequestHeader("token") String token, @RequestBody @Validated ReqCampusVO reqCampusVo) {
		try {
			Map<String, Object> cur = getCurrentUser(token);
			return iCampusService.saveCampus(reqCampusVo, cur);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 查询分校名称是否存在
	 * 
	 * @param reqCampusCodeVo
	 * @return
	 */

	@PostMapping("/findCampusName")
	@ApiOperation(notes = "查询分校名称是否存在", value = "查询分校名称是否存在", response = MessageVO.class)
	@ApiImplicitParam(name = "reqCampusCodeVo", value = "reqCampusCodeVo 实体", dataType = "ReqCampusCodeVO")
	public Object findCampusName(@RequestBody @Validated ReqCampusCodeVO reqCampusCodeVo) {
		try {
			return iCampusService.qryCampusName(reqCampusCodeVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 根据主键id查询单条分校信息
	 * 
	 * @param uid
	 * @return
	 */

	@PostMapping("/findCampusById")
	@ApiOperation(notes = "根据主键id查询单条分校信息", value = "根据主键id查询单条分校信息", response = RespCampusVO.class)
	@ApiImplicitParam(name = "mmsQueryVo", value = "mmsQueryVo 实体", dataType = "ReqMmsQueryVO", paramType = "body")
	public Object findCampusById(@RequestBody @Validated ReqMmsQueryVO mmsQueryVo) {
		try {
			return iCampusService.qryCampusById(mmsQueryVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 删除分校管理信息
	 * 
	 * @param uid
	 * @return
	 */

	@PostMapping("/deleteCampus")
	@ApiOperation(notes = "删除分校管理", value = "删除分校管理", response = MessageVO.class)
	@ApiImplicitParam(name = "mmsMassVo", value = "mmsMassVo 实体", dataType = "ReqMmsMassVO", paramType = "body")
	public Object deleteCampus(@RequestBody @Validated ReqMmsMassVO mmsMassVo) {
		try {
			return iCampusService.deleteCampus(mmsMassVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 分校列表模糊分页查询
	 * 
	 * @param campusVo
	 * @return
	 */

	@PostMapping("/pageCampus")
	@ApiOperation(notes = "分校列表模糊分页查询", value = "分校列表模糊分页查询", response = RespCampusVO.class)
	@ApiImplicitParam(name = "campusVo", value = "campusVo 实体", dataType = "CampusVO")
	public Object pageCampus(@RequestBody @Validated CampusVO campusVo) {
		try {
			return iCampusService.qryPageCampus(campusVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

	/**
	 * 分校列表查询
	 * 
	 * @return
	 */

	@PostMapping("/queryCampus")
	@ApiOperation(notes = "所有分校列表信息", value = "所有分校列表信息", response = RespCampusVO.class)
	public Object queryCampus() {
		try {
			return iCampusService.queryCampus();
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

	/**
	 * 判断部门下是否存在该分校
	 * 
	 * @return
	 */

	@PostMapping("/judgeDeptSchool")
	@ApiOperation(notes = "判断部门下是否存在该分校", value = "判断部门下是否存在该分校")
	@ApiImplicitParam(name = "nameVO", value = "nameVO 实体", dataType = "ReqDeptCodeVO")
	public Object judgeDeptSchool(@RequestBody @Validated ReqDeptCodeVO nameVO) {
		try {
			return iCampusService.deptSchool(nameVO);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

	/**
	 * 根据部门ID查询分校
	 * 
	 * @return
	 */

	@PostMapping("/qryDeptSchool")
	@ApiOperation(notes = "根据部门ID查询分校", value = "根据部门ID查询分校", response = RespCampusVO.class)
	@ApiImplicitParam(name = "qryNameVO", value = "qryNameVO 实体", dataType = "ReqDeptCodeExistVO")
	public Object qryDeptSchool(@RequestBody @Validated ReqDeptCodeExistVO qryNameVO) {
		try {
			return iCampusService.qryDeptSchool(qryNameVO);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}
	
	@PostMapping("/qrySchoolByUser")
	@ApiOperation(notes = "根据登陆用户部门查询所属分校", value = "根据登陆用户部门查询所属分校", response = RespCampusVO.class)
	@ApiImplicitParam(name = "req", value = "QueryInfoVO 实体", dataType = "QueryInfoVO")
	public Object qrySchoolByUser(@RequestHeader("token") String token,@RequestBody QueryInfoVO req) {
		Map<String, Object> cur = getCurrentUser(token);
		return iCampusService.qrySchoolByUser(cur,req);
	}
}
