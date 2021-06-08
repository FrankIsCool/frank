package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.MmsResubmitList;
import com.sxmaps.my.vo.resp.RespCategoryVO;

import java.util.List;

public interface MmsCategoryMapper extends CommonMapper<MmsResubmitList> {
	List<RespCategoryVO> qryCategorySetting();

}