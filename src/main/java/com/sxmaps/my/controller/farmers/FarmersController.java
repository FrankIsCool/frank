package com.sxmaps.my.controller.farmers;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.service.IFarmersService;
import com.sxmaps.my.vo.req.farmers.*;
import com.sxmaps.my.vo.resp.farmers.RespFarmersInfoVO;
import com.sxmaps.my.vo.resp.farmers.RespFarmersListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类：牧场接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/farmers")
@Api(value = "牧场接口", tags = "牧场接口")
public class FarmersController {

    @Resource
    IFarmersService farmersService;

    /**
     * 牧场基本信息接口
     * @return
     */
    @PostMapping(value = "/check/admin/info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牧场基本信息接口", value = "牧场基本信息接口" ,response = RespFarmersInfoVO.class)
    @ApiImplicitParam(name = "vo", value = "新增牧场接口", dataType = "ReqFarmersInfoVO")
    public RespFarmersInfoVO farmersInfo(@RequestBody @Validated ReqFarmersInfoVO vo) {
        return farmersService.getFarmersInfo(vo.getFarmersid());
    }
    /**
     * 牧场基本信息接口
     * @return
     */
    @PostMapping(value = "/check/info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牧场基本信息接口", value = "牧场基本信息接口" ,response = RespFarmersInfoVO.class)
    @ApiImplicitParam(name = "vo", value = "新增牧场接口", dataType = "UserInfoVo")
    public RespFarmersInfoVO farmersInfo(@RequestBody @Validated UserInfoVo vo) {
        return farmersService.getFarmersInfo(vo.getFarmersUid());
    }
    /**
     * 修改牧场基本信息接口
     * @return
     */
    @PostMapping(value = "/check/update/info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "修改牧场基本信息接口", value = "修改牧场基本信息接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "修改牧场基本信息接口", dataType = "ReqFarmersUpdateVO")
    public Integer farmersUpdateInfo(@RequestBody @Validated ReqFarmersUpdateVO vo) {
        return farmersService.farmersUpdate(vo);
    }
    /**
     * 牧场列表接口
     * @return
     */
    @PostMapping(value = "/check/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牧场列表接口", value = "牧场列表接口",response = RespFarmersListVO.class)
    @ApiImplicitParam(name = "vo", value = "牧场列表接口", dataType = "ReqFarmersListVO")
    public PageInfo<RespFarmersListVO> farmersList(@RequestBody @Validated ReqFarmersListVO vo) {
        return farmersService.getFarmersList(vo);
    }
    /**
     * 新增牧场接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增牧场接口", value = "新增牧场接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "新增牧场接口", dataType = "ReqFarmersCreateVO")
    public Integer farmersCreate(@RequestBody @Validated ReqFarmersCreateVO vo) {
        return farmersService.createFarmers(vo);
    }
    /**
     * 注销牧场接口
     * @return
     */
    @PostMapping(value = "/check/cancel",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "注销牧场接口", value = "注销牧场接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "注销牧场接口", dataType = "ReqFarmersDelVO")
    public Integer farmersCancel(@RequestBody @Validated ReqFarmersDelVO vo) {
        return farmersService.farmersCancel(vo);
    }
}
