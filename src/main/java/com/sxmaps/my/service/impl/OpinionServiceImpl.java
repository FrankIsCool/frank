package com.sxmaps.mms.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxmaps.mms.common.OperationConstant;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MmsOpinionMapper;
import com.sxmaps.mms.model.MmsOpinion;
import com.sxmaps.mms.service.IOpinionService;
import com.sxmaps.mms.utils.DateUtil2;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqOpinionVO;
import com.sxmaps.mms.vo.resp.RespOpinionVO;

/**
 * 
 * @author gongqingzhuan
 * @data 2018年3月14日
 *
 */
@Service
public class OpinionServiceImpl implements IOpinionService {

	@Autowired
	private MmsOpinionMapper mmsOpinionMapper;

	/**
	 * 添加评价信息
	 * 
	 * @param reqOpinionVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public RespOpinionVO saveOpinion(ReqOpinionVO reqOpinionVo) throws MmsBizException {
		int result = 0;
		RespOpinionVO opinionVO = new RespOpinionVO();

		ReqOpinionVO codeVO = new ReqOpinionVO();
		// id不为空更新操作
		if (null != reqOpinionVo.getUid()) {
			// 查询数据库是否存在这条记录
			MmsOpinion opinion = mmsOpinionMapper.selectByPrimaryKey(reqOpinionVo.getUid());
			if (null == opinion) {
				throw new MmsBizException(MmsBizException.DB_CODE, "操作失败，请检查uid是否正确");
			}
			// 查询点评项是否存在
			codeVO.setUid(reqOpinionVo.getUid());
			codeVO.setViews(reqOpinionVo.getViews());
			findOpinionViews(codeVO);

			BeanUtils.copyProperties(reqOpinionVo, opinion);
			opinion.setUpdateTime(DateUtil2.currentDate());
			result = mmsOpinionMapper.updateByPrimaryKeySelective(opinion);
			BeanUtils.copyProperties(reqOpinionVo, opinionVO);
			if (result <= 0) {
				throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，更新点评失败");
			}
			return opinionVO;
		}
		// 查询点评项是否存在
		codeVO.setUid(reqOpinionVo.getUid());
		codeVO.setViews(reqOpinionVo.getViews());
		findOpinionViews(codeVO);

		MmsOpinion mmsOpinion = new MmsOpinion();
		BeanUtils.copyProperties(reqOpinionVo, mmsOpinion);
		mmsOpinion.setUid(null);
		mmsOpinion.setCreateTime(DateUtil2.currentDate());
		mmsOpinion.setState(OperationConstant.STATE_NORMAL);
		result = mmsOpinionMapper.insert(mmsOpinion);
		BeanUtils.copyProperties(reqOpinionVo, opinionVO);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，添加点评失败");
		}
		return opinionVO;
	}

	/**
	 * 删除评价信息
	 * 
	 * @param mmsQueryVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public int deleteOpinion(ReqMmsQueryVO mmsQueryVo) throws MmsBizException {
		MmsOpinion opinion = new MmsOpinion();
		opinion.setUid(mmsQueryVo.getUid());
		int result = mmsOpinionMapper.delete(opinion);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库操作异常,删除分校失败");
		}
		return result;
	}

	/**
	 * 查询点评项是否存在
	 * 
	 * @param reqOpinionVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public int findOpinionViews(ReqOpinionVO reqOpinionVo) throws MmsBizException {
		int result = mmsOpinionMapper.qryOpinionViews(reqOpinionVo);
		if (result > 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "该点评项已存在");
		}
		return result;
	}

	/**
	 * 查询评价信息
	 * 
	 * @return
	 */
	@Override
	public List<RespOpinionVO> findOpinion() {
		List<RespOpinionVO> mmsOpinions = mmsOpinionMapper.findOpinion();
		return mmsOpinions;
	}
}