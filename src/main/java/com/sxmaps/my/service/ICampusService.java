package com.sxmaps.mms.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.vo.CampusVO;
import com.sxmaps.mms.vo.QueryInfoVO;
import com.sxmaps.mms.vo.req.ReqCampusCodeVO;
import com.sxmaps.mms.vo.req.ReqCampusVO;
import com.sxmaps.mms.vo.req.ReqDeptCodeExistVO;
import com.sxmaps.mms.vo.req.ReqDeptCodeVO;
import com.sxmaps.mms.vo.req.ReqMmsMassVO;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.resp.RespCampuVO;
import com.sxmaps.mms.vo.resp.RespCampusVO;

/**
 * 
 * @author gongqingzhuan
 * @data 2018年3月12日
 *
 */
public interface ICampusService {

	/**
	 * 添加分校信息
	 * 
	 * @param reqCampusVo
	 * @param cur
	 * @return
	 * @throws MmsBizException
	 */
	RespCampuVO saveCampus(ReqCampusVO reqCampusVo, Map<String, Object> cur) throws MmsBizException;

	/**
	 * 删除分校信息
	 * 
	 * @param uid
	 * @return
	 * @throws MmsBizException
	 */
	int deleteCampus(ReqMmsMassVO mmsMassVo) throws MmsBizException;

	/**
	 * 查询分校名称是否存在
	 * 
	 * @param reqCampusCodeVo
	 * @return
	 */
	int qryCampusName(ReqCampusCodeVO reqCampusCodeVo);

	/**
	 * 根据id查询单条数据
	 * 
	 * @param uid
	 * @return
	 */
	RespCampusVO qryCampusById(ReqMmsQueryVO mmsQueryVo);

	/**
	 * 模糊查询加分页
	 * 
	 * @param campusVO
	 * @return
	 */

	PageInfo<RespCampusVO> qryPageCampus(CampusVO campusVO);

	/**
	 * 查询分校信息
	 * 
	 * @return
	 */
	List<RespCampusVO> queryCampus();

	/**
	 * 判断该部门下是否存在该分校
	 * 
	 * @param nameVO
	 * @return
	 */
	int deptSchool(ReqDeptCodeVO nameVO);

	/**
	 * 根据部门ID查询分校
	 * 
	 * @param qryNameVO
	 * @return
	 */
	List<RespCampusVO> qryDeptSchool(ReqDeptCodeExistVO qryNameVO);
	
	/**
	 * 根据登陆用户部门查询所属分校
	 * @param user
	 * @return
	 */
	PageInfo<RespCampusVO> qrySchoolByUser(Map<String, Object> user,QueryInfoVO req) throws MmsBizException;
}
