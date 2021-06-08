package com.sxmaps.mms.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxmaps.mms.common.OperationConstant;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MmsSettingMapper;
import com.sxmaps.mms.model.MmsSetting;
import com.sxmaps.mms.service.ISettingService;
import com.sxmaps.mms.utils.DateUtil2;
import com.sxmaps.mms.utils.RandomCode;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqSettingNameVO;
import com.sxmaps.mms.vo.req.ReqSettingVO;
import com.sxmaps.mms.vo.resp.RespSettVO;
import com.sxmaps.mms.vo.resp.RespSettingVO;

@Service
public class SettingServiceImpl implements ISettingService {
	@Autowired
	private MmsSettingMapper omsSettingMapper;

	/**
	 * 添加类别
	 * 
	 * @param reqSettingVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public RespSettVO saveSetting(ReqSettingVO reqSettingVo) throws MmsBizException {
		int result = 0;
		RespSettVO settVO = new RespSettVO();

		ReqSettingNameVO codeVO = new ReqSettingNameVO();

		// id不为空，更新操作
		if (null != reqSettingVo.getUid()) {
			// 查询数据库是否存在这条记录
			MmsSetting setting = omsSettingMapper.selectByPrimaryKey(reqSettingVo.getUid());
			if (null == setting) {
				throw new MmsBizException(MmsBizException.DB_CODE, "操作失败，请检查uid是否正确");
			}
			// 判断类别是否存在
			codeVO.setUid(reqSettingVo.getUid());
			codeVO.setOpName(reqSettingVo.getOpName());
			qrySettingName(codeVO);
			BeanUtils.copyProperties(reqSettingVo, setting);
			setting.setState(OperationConstant.STATE_NORMAL);
			setting.setUpdateTime(DateUtil2.currentDate());
			result = omsSettingMapper.updateByPrimaryKeySelective(setting);
			BeanUtils.copyProperties(reqSettingVo, settVO);
			if (result <= 0) {
				throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，更新类别失败");
			}
			return settVO;
		}
		// 判断类别是否存在
		codeVO.setUid(reqSettingVo.getUid());
		codeVO.setOpName(reqSettingVo.getOpName());
		qrySettingName(codeVO);
		MmsSetting omsSetting = new MmsSetting();
		BeanUtils.copyProperties(reqSettingVo, omsSetting);
		omsSetting.setUid(null);
		omsSetting.setOpCode(judgeOpCode(RandomCode.getSixRandCode()));
		omsSetting.setState(OperationConstant.STATE_NORMAL);
		omsSetting.setCreateTime(DateUtil2.currentDate());
		result = omsSettingMapper.insert(omsSetting);
		BeanUtils.copyProperties(reqSettingVo, settVO);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，添加类别失败");
		}
		return settVO;
	}

	/**
	 * 删除类别
	 * 
	 * @param mmsQueryVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public int deleteSetting(ReqMmsQueryVO mmsQueryVo) throws MmsBizException {
		MmsSetting omsSetting = new MmsSetting();
		omsSetting.setUid(mmsQueryVo.getUid());
		// 查询该类别id是否存在
		MmsSetting deleteById = omsSettingMapper.selectByPrimaryKey(omsSetting);
		if (deleteById == null) {
			throw new MmsBizException(MmsBizException.DB_CODE, "操作失败，请检查uid是否正确");
		}
		int result = omsSettingMapper.deleteByPrimaryKey(omsSetting);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库操作异常,删除分校失败");
		}
		return result;
	}

	/**
	 * 查询类别
	 * 
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public List<RespSettingVO> findSetting() throws MmsBizException {
		List<RespSettingVO> omsSettings = omsSettingMapper.findSetting();
		return omsSettings;
	}

	/**
	 * 查询类别名称是否存在
	 * 
	 * @param settingNameVo
	 * @return
	 */
	@Override
	public int qrySettingName(ReqSettingNameVO settingNameVo) {
		int result = omsSettingMapper.qrySettingName(settingNameVo);
		if (result > 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "该类别名称已存在");
		}
		return result;
	}

	/**
	 * 根据类型ID查询类别值
	 * 
	 * @param mmsQueryVo
	 * @return
	 */
	@Override
	public List<RespSettingVO> qrySettingByCategoryId(ReqMmsQueryVO mmsQueryVo) {
		List<RespSettingVO> settingVO = omsSettingMapper.qrySettingByCategoryId(mmsQueryVo);
		return settingVO;
	}

	/**
	 * 判断code是否重复
	 * 
	 * @param opCode
	 * @return
	 */
	public String judgeOpCode(String opCode) {
		MmsSetting setting = new MmsSetting();
		setting.setOpCode(opCode);
		int count = omsSettingMapper.selectCount(setting);
		if (count <= 0) {
			return opCode;
		}
		return judgeOpCode(RandomCode.getSixRandCode());
	}

}
