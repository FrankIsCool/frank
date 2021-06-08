package com.sxmaps.mms.service;

import java.util.List;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqSettingNameVO;
import com.sxmaps.mms.vo.req.ReqSettingVO;
import com.sxmaps.mms.vo.resp.RespSettVO;
import com.sxmaps.mms.vo.resp.RespSettingVO;

/**
 * sss
 * 
 * @author gongqingzhuan
 *
 * @data 2018年4月9日
 */
public interface ISettingService {

	/**
	 * 添加类别
	 * 
	 * @param reqSettingVo
	 * @return
	 * @throws MmsBizException
	 */
	RespSettVO saveSetting(ReqSettingVO reqSettingVo) throws MmsBizException;

	/**
	 * 删除类别
	 * 
	 * @param mmsQueryVo
	 * @return
	 * @throws MmsBizException
	 */

	int deleteSetting(ReqMmsQueryVO mmsQueryVo) throws MmsBizException;

	/**
	 * 查询类别
	 * 
	 * @return
	 * @throws MmsBizException
	 */
	List<RespSettingVO> findSetting() throws MmsBizException;

	/**
	 * 查询类别名称是否存在
	 * 
	 * @param settingNameVo
	 * @return
	 */
	int qrySettingName(ReqSettingNameVO settingNameVo);

	/**
	 * 根据类型ID查询类别值
	 * 
	 * @param mmsQueryVo
	 * @return
	 */
	List<RespSettingVO> qrySettingByCategoryId(ReqMmsQueryVO mmsQueryVo);

}
