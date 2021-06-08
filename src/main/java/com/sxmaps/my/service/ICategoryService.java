package com.sxmaps.mms.service;

import java.util.List;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.vo.req.ReqCategoryVO;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqSettingByCateVO;
import com.sxmaps.mms.vo.resp.RespCateVO;
import com.sxmaps.mms.vo.resp.RespCategoryVO;
import com.sxmaps.mms.vo.resp.RespGoryVO;
import com.sxmaps.mms.vo.resp.RespSettingByCateVO;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 2018年4月9日
 */
public interface ICategoryService {

	/**
	 * 添加服务类型
	 * 
	 * @param reqMmsOpinionVo
	 * @return
	 * @throws MmsBizException
	 */
	RespCateVO saveCategory(ReqCategoryVO categoryVo) throws MmsBizException;

	/**
	 * 删除服务类型
	 * 
	 * @param uid
	 * @return
	 * @throws MmsBizException
	 */

	int deleteCategory(ReqMmsQueryVO mmsQueryVo) throws MmsBizException;

	/**
	 * 查询类型信息
	 * 
	 * @return
	 * @throws MmsBizException
	 */
	List<RespGoryVO> findCategory() throws MmsBizException;

	/**
	 * 查询类型类别信息
	 * 
	 * @return
	 * @throws MmsBizException
	 */
	List<RespCategoryVO> qryCategorySetting() throws MmsBizException;

	/**
	 * 查询类型名称是否存在
	 * 
	 * @param categoryVo
	 * @return
	 */
	int qryCategoryName(ReqCategoryVO categoryVo);

	/**
	 * /** 根据类别uid获取类别的名称和类型名称
	 * 
	 * @param categoryVo
	 * @return
	 */

	RespSettingByCateVO SettingCateBysettUid(ReqSettingByCateVO settingByCateVO);

}
