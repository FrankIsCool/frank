package com.sxmaps.mms.mapper;

import java.util.List;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsSetting;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqSettingNameVO;
import com.sxmaps.mms.vo.resp.RespSettingVO;

public interface MmsSettingMapper extends CommonMapper<MmsSetting> {
	int qrySettingName(ReqSettingNameVO settingNameVo);

	List<RespSettingVO> qrySettingByCategoryId(ReqMmsQueryVO mmsQueryVo);

	List<RespSettingVO> findSetting();
}