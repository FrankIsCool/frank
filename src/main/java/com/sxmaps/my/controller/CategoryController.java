/**
 * 
 */
package com.sxmaps.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.service.ICategoryService;
import com.sxmaps.mms.utils.WebTools;
import com.sxmaps.mms.vo.MessageVO;
import com.sxmaps.mms.vo.req.ReqCategoryVO;
import com.sxmaps.mms.vo.req.ReqMmsQueryVO;
import com.sxmaps.mms.vo.resp.RespCateVO;
import com.sxmaps.mms.vo.resp.RespCategoryVO;
import com.sxmaps.mms.vo.resp.RespGoryVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author gongqingzhuan
 * @data 2018年3月12日
 *
 */
@RestController
@RequestMapping("/category")
@Api(value = "类型管理", tags = "类型管理")
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;

	/**
	 * 保存服务类型
	 * 
	 * @param categoryVo
	 * @return
	 */
	@PostMapping("/saveCategory")
	@ApiOperation(notes = "保存服务类型", value = "保存服务类型", response = RespCateVO.class)
	@ApiImplicitParam(name = "categoryVo", value = "categoryVo 实体", dataType = "ReqCategoryVO")
	public Object saveCategory(@RequestBody @Validated ReqCategoryVO categoryVo) {
		try {
			return iCategoryService.saveCategory(categoryVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 删除服务类型
	 * 
	 * @param categoryVo
	 * @return
	 */
	@PostMapping("/deleteCategory")
	@ApiOperation(notes = "删除服务类型", value = "删除服务类型", response = MessageVO.class)
	@ApiImplicitParam(name = "mmsQueryVo", value = "mmsQueryVo 实体", dataType = "ReqMmsQueryVO")
	public Object deleteCategory(@RequestBody @Validated ReqMmsQueryVO mmsQueryVo) {
		try {
			return iCategoryService.deleteCategory(mmsQueryVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}

	/**
	 * 查询服务类型信息
	 * 
	 * @param categoryVo
	 * @return
	 */
	@PostMapping("/findCategory")
	@ApiOperation(notes = "查询服务类型信息", value = "查询服务类型信息", response = RespGoryVO.class)
	public Object findCategory() {
		try {
			return iCategoryService.findCategory();
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

	/**
	 * 查询服务类型类别信息
	 * 
	 * @param categoryVo
	 * @return
	 */
	@PostMapping("/qryCategorySetting")
	@ApiOperation(notes = "查询服务类型类别信息", value = "查询服务类型类别信息", response = RespCategoryVO.class)
	public Object qryCategorySetting() {
		try {
			return iCategoryService.qryCategorySetting();
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(MmsBizException.DB_CODE, e.getMessage(), null);
		}
	}

	/**
	 * 查询类型名称是否重复
	 * 
	 * @param categoryVo
	 * @return
	 */
	@PostMapping("/qryCategoryName")
	@ApiOperation(notes = "查询类型名称是否重复", value = "查询类型名称是否重复", response = MessageVO.class)
	@ApiImplicitParam(name = "categoryVo", value = "categoryVo 实体", dataType = "ReqCategoryVO")
	public Object qryCategoryName(@RequestBody @Validated ReqCategoryVO categoryVo) {
		try {
			return iCategoryService.qryCategoryName(categoryVo);
		} catch (MmsBizException e) {
			return WebTools.createErrorMessage(e.getCode(), e.getMessage(), null);
		}
	}
}
