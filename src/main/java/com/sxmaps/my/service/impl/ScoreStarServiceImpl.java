package com.sxmaps.mms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxmaps.mms.mapper.MmsScoreStarMapper;
import com.sxmaps.mms.service.IScoreStarService;
import com.sxmaps.mms.vo.resp.RespScoreStarVO;

@Service
public class ScoreStarServiceImpl implements IScoreStarService {
	@Autowired
	private MmsScoreStarMapper scoreStarMapper;

	/**
	 * 获取评分星级列表
	 * 
	 * @return
	 */
	@Override
	public List<RespScoreStarVO> qryScoreStar() {
		List<RespScoreStarVO> mmsScoreStars = scoreStarMapper.qryScoreStar();
		return mmsScoreStars;
	}

}
