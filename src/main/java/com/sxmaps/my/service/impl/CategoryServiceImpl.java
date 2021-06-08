package com.sxmaps.mms.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxmaps.mms.common.OperationConstant;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.MmsCategoryMapper;
import com.sxmaps.mms.mapper.MmsSettingMapper;
import com.sxmaps.mms.model.MmsCategory;
import com.sxmaps.mms.model.MmsSetting;
import com.sxmaps.mms.service.ICategoryService;
import com.sxmaps.mms.utils.DateUtil2;
import com.sxmaps.mms.utils.RandomCode;
import com.sxmaps.mms.vo.req.ReqCategoryVO;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.req.ReqSettingByCateVO;
import com.sxmaps.mms.vo.resp.RespCateVO;
import com.sxmaps.mms.vo.resp.RespCategoryVO;
import com.sxmaps.mms.vo.resp.RespGoryVO;
import com.sxmaps.mms.vo.resp.RespSettingByCateVO;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private MmsCategoryMapper omsCategoryMapper;

	@Autowired
	private MmsSettingMapper omsSettingMapper;

	/**
	 * 添加服务类型
	 * 
	 * @param categoryVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public RespCateVO saveCategory(ReqCategoryVO categoryVo) throws MmsBizException {
		int result = 0;
		RespCateVO respCateVO = new RespCateVO();
		ReqCategoryVO codeVO = new ReqCategoryVO();
		// id不为空，更新操作
		if (null != categoryVo.getUid()) {
			// 查询数据库是否存在这个id
			MmsCategory category = omsCategoryMapper.selectByPrimaryKey(categoryVo.getUid());
			if (null == category) {
				throw new MmsBizException(MmsBizException.DB_CODE, "操作失败，请检查uid是否正确");
			}
			// 查询类型名称是否存在
			codeVO.setUid(categoryVo.getUid());
			codeVO.setCateName(categoryVo.getCateName());
			qryCategoryName(codeVO);

			BeanUtils.copyProperties(categoryVo, category);
			category.setState(OperationConstant.STATE_NORMAL);
			category.setUpdateTime(DateUtil2.currentDate());
			result = omsCategoryMapper.updateByPrimaryKeySelective(category);
			BeanUtils.copyProperties(categoryVo, respCateVO);
			if (result <= 0) {
				throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，更新服务类型失败");
			}
			return respCateVO;
		}
		// 查询类型名称是否存在
		codeVO.setUid(categoryVo.getUid());
		codeVO.setCateName(categoryVo.getCateName());
		qryCategoryName(codeVO);

		MmsCategory category = new MmsCategory();
		BeanUtils.copyProperties(categoryVo, category);
		category.setCreateTime(DateUtil2.currentDate());
		category.setUid(null);
		category.setCateCode(judgeCateCode(RandomCode.getSixRandCode()));
		category.setState(OperationConstant.STATE_NORMAL);
		result = omsCategoryMapper.insert(category);
		BeanUtils.copyProperties(categoryVo, respCateVO);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库异常，添加服务类型失败");
		}
		return respCateVO;
	}

	/**
	 * 删除服务类型
	 * 
	 * @param mmsQueryVo
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public int deleteCategory(ReqMmsQueryVO mmsQueryVo) throws MmsBizException {
		MmsCategory category = new MmsCategory();
		category.setUid(mmsQueryVo.getUid());

		MmsSetting setting = new MmsSetting();
		setting.setCateId(mmsQueryVo.getUid());
		// 查询该类型下有没有子类别存在
		int deleteById = omsSettingMapper.selectCount(setting);
		if (deleteById > 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "删除失败,该类型下有数据不能删除");
		}
		// 查询数据库是否存在这个id
		MmsCategory deleteByCateId = omsCategoryMapper.selectByPrimaryKey(category);
		if (deleteByCateId == null) {
			throw new MmsBizException(MmsBizException.DB_CODE, "操作失败，请检查uid是否正确");
		}
		int result = omsCategoryMapper.deleteByPrimaryKey(category);
		if (result <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "数据库操作异常,删除分校失败");
		}
		return result;
	}

	/**
	 * 查询类型信息
	 * 
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public List<RespGoryVO> findCategory() throws MmsBizException {
		List<RespGoryVO> categories = omsCategoryMapper.findCategory();
		return categories;
	}

	/**
	 * 查询类型类别信息
	 * 
	 * @return
	 * @throws MmsBizException
	 */
	@Override
	public List<RespCategoryVO> qryCategorySetting() throws MmsBizException {
		List<RespCategoryVO> ListCategory = omsCategoryMapper.qryCategorySetting();
		return ListCategory;

	}

	/**
	 * 查询类型名称是否存在
	 * 
	 * @param categoryVo
	 * @return
	 */
	@Override
	public int qryCategoryName(ReqCategoryVO categoryVo) {
		int result = omsCategoryMapper.qryCategoryName(categoryVo);
		if (result > 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "该类型名称已存在");
		}
		return result;
	}

	@Override
	public RespSettingByCateVO SettingCateBysettUid(ReqSettingByCateVO settingByCateVO) {
		RespSettingByCateVO byCateVO = omsCategoryMapper.SettingCateBysettUid(settingByCateVO);
		if (byCateVO == null) {
			throw new MmsBizException(MmsBizException.DB_CODE, "操作失败,请检查uid是否正确,查无数据");
		}
		return byCateVO;
	}

	/**
	 * 判断code是否重复
	 * 
	 * @param cateCode
	 * @return
	 */
	public String judgeCateCode(String cateCode) {
		MmsCategory category = new MmsCategory();
		category.setCateCode(cateCode);
		int count = omsCategoryMapper.selectCount(category);
		if (count <= 0) {
			return cateCode;
		}
		return judgeCateCode(RandomCode.getSixRandCode());
	}

}
