package com.sxmaps.mms.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.mms.common.OperationConstant;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MmsCampusMapper;
import com.sxmaps.mms.model.AuthSxDept;
import com.sxmaps.mms.model.MmsCampus;
import com.sxmaps.mms.service.ICampusService;
import com.sxmaps.mms.utils.ConvertUtil;
import com.sxmaps.mms.utils.DateUtil2;
import com.sxmaps.mms.utils.RandomCode;
import com.sxmaps.mms.utils.ValidatorUtil;
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

import tk.mybatis.mapper.entity.Example;

@Service
public class CampusServiceImpl implements ICampusService {

	@Autowired
	private MmsCampusMapper campusMapper;

	/**
	 * 添加分校信息
	 * 
	 * @param rCampusVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public RespCampuVO saveCampus(ReqCampusVO rCampusVo, Map<String, Object> cur) throws MmsBizException {
		int result = 0;
		RespCampuVO respCampuVO = new RespCampuVO();
		ReqDeptCodeVO deptCodeVO = new ReqDeptCodeVO();
		// 判断分校是否存在
		ReqCampusCodeVO codeVO = new ReqCampusCodeVO();
		// id不为空，更新操作
		if (null != rCampusVo.getUid()) {
			// 查询数据库是否存在这个id
			MmsCampus camp = campusMapper.selectByPrimaryKey(rCampusVo.getUid());
			if (null == camp) {
				throw new MmsBizException(MmsBizException.DB_CODE, "操作失败，请检查uid是否正确");
			}
			// 判断分校是否存在
			codeVO.setUid(rCampusVo.getUid());
			codeVO.setCampusName(rCampusVo.getCampusName());
			qryCampusName(codeVO);
			// 判断部门下是否存在分校
			deptCodeVO.setUid(rCampusVo.getUid());
			deptCodeVO.setDeptCode(rCampusVo.getDeptCode());
			deptSchool(deptCodeVO);

			BeanUtils.copyProperties(rCampusVo, camp);
			if (ValidatorUtil.isMobileVirtual(camp.getPhone()) || ValidatorUtil.isTel(camp.getPhone())) {
				camp.setUpdateTime(DateUtil2.currentDate());
				camp.setState(OperationConstant.STATE_NORMAL);
				String address = "";
				if (ValidatorUtil.isEmpty(camp.getCountyName())) {
					address = camp.getProvinceName() + camp.getCityName() + camp.getStreet();
				} else {
					address = camp.getProvinceName() + camp.getCityName() + camp.getCountyName() + camp.getStreet();
				}
				camp.setAddress(address);
				camp.setOperatorUid(ConvertUtil.toStringIgnoreBlank(cur.get("userId")));
				camp.setOperatorName(ConvertUtil.toStringIgnoreBlank(cur.get("userName")));
				result = campusMapper.updateByPrimaryKeySelective(camp);
				BeanUtils.copyProperties(rCampusVo, respCampuVO);
				if (result <= 0) {
					throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，更新分校失败");
				}
				return respCampuVO;
			} else {
				throw new MmsBizException(MmsBizException.BIZ_CODE, "联系电话号码有误，请重新输入");
			}
		}
		// 判断分校是否存在
		codeVO.setUid(rCampusVo.getUid());
		codeVO.setCampusName(rCampusVo.getCampusName());
		qryCampusName(codeVO);
		// 判断部门下是否存在分校
		deptCodeVO.setUid(rCampusVo.getUid());
		deptCodeVO.setDeptCode(rCampusVo.getDeptCode());
		deptSchool(deptCodeVO);
		MmsCampus campus = new MmsCampus();
		BeanUtils.copyProperties(rCampusVo, campus);
		if (ValidatorUtil.isMobileVirtual(campus.getPhone()) || ValidatorUtil.isTel(campus.getPhone())) {
			campus.setUid(null);
			campus.setCreateTime(DateUtil2.currentDate());
			campus.setState(OperationConstant.STATE_NORMAL);
			campus.setCampusCode(judgeCampusCode(RandomCode.getSixRandCode()));
			campus.setOperatorUid(ConvertUtil.toStringIgnoreBlank(cur.get("userId")));
			campus.setOperatorName(ConvertUtil.toStringIgnoreBlank(cur.get("userName")));
			String address = "";
			if (ValidatorUtil.isEmpty(campus.getCountyName())) {
				address = campus.getProvinceName() + campus.getCityName() + campus.getStreet();
			} else {
				address = campus.getProvinceName() + campus.getCityName() + campus.getCountyName() + campus.getStreet();
			}
			campus.setAddress(address);
			result = campusMapper.insert(campus);
			BeanUtils.copyProperties(rCampusVo, respCampuVO);
			if (result <= 0) {
				throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，添加分校失败");
			}
			return respCampuVO;
		} else {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "联系电话号码有误，请重新输入");
		}
	}

	/**
	 * 删除分校信息
	 * 
	 * @param massVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public int deleteCampus(ReqMmsMassVO massVo) throws MmsBizException {
		Example example = new Example(MmsCampus.class);
		example.createCriteria().andIn("uid", Arrays.asList(massVo.getUid()));
		List<MmsCampus> campusList = campusMapper.selectByExample(example);
		if (null == campusList || campusList.isEmpty()) {
			throw new MmsBizException(MmsBizException.DB_CODE, "查无数据，请检查参数");
		}
		if (campusList.size() != Arrays.asList(massVo.getUid()).size()) {
			throw new MmsBizException(MmsBizException.DB_CODE, "查询数据有误");
		}
		int result = campusMapper.deleteByExample(example);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库操作异常,删除分校失败");
		}
		return result;
	}

	/**
	 * 查询分校名称是否存在
	 * 
	 * @param reqCampusCodeVo
	 * @return
	 */
	@Override
	public int qryCampusName(ReqCampusCodeVO reqCampusCodeVo) {
		int result = campusMapper.qryCampusName(reqCampusCodeVo);
		if (result > 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "操作失败,该分校名称已经存在");
		}
		return result;
	}

	/**
	 * 根据id查询单条数据
	 * 
	 * @param mmsQueryVo
	 * @return
	 */
	@Override
	public RespCampusVO qryCampusById(ReqMmsQueryVO mmsQueryVo) {
		RespCampusVO campu = campusMapper.qryCampusById(mmsQueryVo);
		if (ValidatorUtil.isEmpty(campu)) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库查无数据");
		}
		return campu;
	}

	/**
	 * 模糊查询加分页
	 * 
	 * @param campusVO
	 * @return
	 */
	@Override
	public PageInfo<RespCampusVO> qryPageCampus(CampusVO campusVO) {
		PageHelper.startPage(campusVO.getPageNum(), campusVO.getPageSize());
		PageHelper.orderBy("uid DESC");
		List<RespCampusVO> campusVos = campusMapper.qryInfoCampus();
		return new PageInfo<RespCampusVO>(campusVos);
	}

	/**
	 * 查询分校信息
	 * 
	 * @return
	 */
	@Override
	public List<RespCampusVO> queryCampus() {
		List<RespCampusVO> campusVos = campusMapper.queryCampus();
		return campusVos;
	}

	/**
	 * 判断该部门下是否存在该分校
	 * 
	 * @param nameVO
	 * @return
	 */
	@Override
	public int deptSchool(ReqDeptCodeVO nameVO) {
		int result = campusMapper.qryDeptCode(nameVO);
		if (result > 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "操作失败,该部门下已存在分校");
		}
		return result;
	}

	/**
	 * 根据部门ID查询分校
	 * 
	 * @param qryNameVO
	 * @return
	 */
	@Override
	public List<RespCampusVO> qryDeptSchool(ReqDeptCodeExistVO qryNameVO) {
		List<RespCampusVO> campusVos = campusMapper.qryDeptSchool(qryNameVO);
		return campusVos;
	}

	/**
	 * 判断code是否重复
	 * 
	 * @param campusCode
	 * @return
	 */
	public String judgeCampusCode(String campusCode) {
		MmsCampus mmsCampus = new MmsCampus();
		mmsCampus.setCampusCode(campusCode);
		int count = campusMapper.selectCount(mmsCampus);
		if (count <= 0) {
			return campusCode;
		}
		return judgeCampusCode(RandomCode.getSixRandCode());
	}

	public PageInfo<RespCampusVO> qrySchoolByUser(Map<String, Object> user,QueryInfoVO req) throws MmsBizException{
		String deptId = (String)user.get("sxDeptId");
		if(deptId == null) {
			throw new MmsBizException(404, "您没有被分配部门,请与部门主管联系");
		}
		String[] deptList = getDeptList(deptId);
		if(deptList == null || deptList.length == 0) {
			throw new MmsBizException(404, "您的部门信息有误,请与部门主管联系");
		}
		PageHelper.startPage(req.getPageNum(), 100);
		List<RespCampusVO> qryList = campusMapper.qrySchoolByUser(deptList);
		List<RespCampusVO> respList = new ArrayList<RespCampusVO>();
		for(RespCampusVO vo:qryList) {
			if(vo.getDeptCode() != null) {
				respList.add(vo);
			}
		}
		return new PageInfo<RespCampusVO>(respList);
	}
	
	public String[] getDeptList(String deptId) {
        List<AuthSxDept> depts = campusMapper.queryDeptList();
        List<AuthSxDept> tmp = new ArrayList<AuthSxDept>();
        String str = null;
        for (AuthSxDept authDept : depts) {
            if (authDept.getDeptId().equals(deptId)) {
                tmp.add(authDept);
                treeDept(depts, authDept, tmp);
            }
        }
        StringBuffer buffer = new StringBuffer();
        if (tmp.size() == 0) {
            return null;
        }
        for (AuthSxDept authDept : tmp) {
            buffer.append(authDept.getDeptId() + ",");
        }
        str = buffer.substring(0, buffer.length() - 1);

        String[] result = str.split(",");
        return result;
    }

    /*
     * 获取当前部门下所有的子部门
     */
    public void treeDept(List<AuthSxDept> depts, AuthSxDept authDept, List<AuthSxDept> tmp) {
        for (AuthSxDept tm : depts) {
            if (authDept.getDeptId().equals(tm.getParentId())) {
                tmp.add(tm);
                treeDept(depts, tm, tmp);
            }
        }

    }
}
