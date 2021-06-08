package com.sxmaps.mms.mapper;

import java.util.List;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsCategory;
import com.sxmaps.mms.vo.req.ReqCategoryVO;
import com.sxmaps.mms.vo.req.ReqSettingByCateVO;
import com.sxmaps.mms.vo.resp.RespCategoryVO;
import com.sxmaps.mms.vo.resp.RespGoryVO;
import com.sxmaps.mms.vo.resp.RespSettingByCateVO;

public interface MmsCategoryMapper extends CommonMapper<MmsCategory> {
	List<RespCategoryVO> qryCategorySetting();

	int qryCategoryName(ReqCategoryVO categoryVo);

	List<RespGoryVO> findCategory();

	RespSettingByCateVO SettingCateBysettUid(ReqSettingByCateVO settingByCateVO);
}