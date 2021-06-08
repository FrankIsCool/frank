package com.sxmaps.mms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MmsScoreOpinionMapMapper;
import com.sxmaps.mms.model.MmsScoreOpinionMap;
import com.sxmaps.mms.service.IScoreOpinionService;
import com.sxmaps.mms.utils.ValidatorUtil;
import com.sxmaps.mms.vo.req.ReqScoreOpinionMapVO;
import com.sxmaps.mms.vo.req.ReqScoreVO;
import com.sxmaps.mms.vo.resp.RespScoreMapVO;
import com.sxmaps.mms.vo.resp.RespScoreOpinionListVO;
import com.sxmaps.mms.vo.resp.RespScoreOpinionMapVO;

/**
 */
@Service
public class ScoreOpinionServiceImpl implements IScoreOpinionService {

	@Autowired
	MmsScoreOpinionMapMapper scoreOpinionMapMapper;

	/**
	 * 添加星级点评信息管理
	 * 
	 * @param reqScoreOpinionMapVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class }, timeout = 3000)
	public RespScoreMapVO saveScoreOpinion(ReqScoreOpinionMapVO reqScoreOpinionMapVo) throws MmsBizException {
		int result = 0;
		List<MmsScoreOpinionMap> scoreOpinionListVos = new ArrayList<MmsScoreOpinionMap>();
		RespScoreMapVO aMapVO = new RespScoreMapVO();
		// OpinionList不为空添加操作
		if (ValidatorUtil.isNotEmpty(reqScoreOpinionMapVo.getOpinionList())) {
			for (Long opinionMapVo : reqScoreOpinionMapVo.getOpinionList()) {
				MmsScoreOpinionMap mmsScoreOpinionMap = new MmsScoreOpinionMap();
				mmsScoreOpinionMap.setOpinionUid(opinionMapVo);
				mmsScoreOpinionMap.setScoreUid(reqScoreOpinionMapVo.getScoreUid());
				scoreOpinionListVos.add(mmsScoreOpinionMap);
			}
			MmsScoreOpinionMap mmsScoreOpinionMap = new MmsScoreOpinionMap();
			mmsScoreOpinionMap.setScoreUid(reqScoreOpinionMapVo.getScoreUid());
			scoreOpinionMapMapper.delete(mmsScoreOpinionMap);
			result = scoreOpinionMapMapper.insertList(scoreOpinionListVos);
			BeanUtils.copyProperties(reqScoreOpinionMapVo, aMapVO);
		} else {
			// OpinionList为空清空数据
			MmsScoreOpinionMap mmsScoreOpinionMap = new MmsScoreOpinionMap();
			mmsScoreOpinionMap.setScoreUid(reqScoreOpinionMapVo.getScoreUid());
			int count = scoreOpinionMapMapper.selectCount(mmsScoreOpinionMap);
			if (count <= 0) {
				throw new MmsBizException(MmsBizException.DB_CODE, "数据已清空");
			}
			result = scoreOpinionMapMapper.delete(mmsScoreOpinionMap);
			BeanUtils.copyProperties(reqScoreOpinionMapVo, aMapVO);
		}
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，添加星级点评项失败");
		}
		return aMapVO;
	}

	/**
	 * 根据评分星级获取评价信息
	 * 
	 * @param scoreVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public List<RespScoreOpinionMapVO> qryScoreByOpinion(ReqScoreVO scoreVo) throws MmsBizException {
		List<RespScoreOpinionMapVO> scoreOpinionMapVos = scoreOpinionMapMapper.qryScoreByOpinion(scoreVo);
		return scoreOpinionMapVos;
	}

	/**
	 * 根据星级查询所有点评信息
	 * 
	 * @return
	 */
	@Override
	public List<RespScoreOpinionListVO> qryScoreOpinionList() {
		List<RespScoreOpinionListVO> listVOs = scoreOpinionMapMapper.qryScoreOpinionList();
		return listVOs;
	}

}