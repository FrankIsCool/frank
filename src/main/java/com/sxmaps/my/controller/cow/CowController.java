package com.sxmaps.my.controller.cow;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.service.ICowService;
import com.sxmaps.my.vo.req.cow.*;
import com.sxmaps.my.vo.resp.cow.RespCowInfoVO;
import com.sxmaps.my.vo.resp.cow.RespCowListVO;
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
 * 类：牛接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/check/cow")
@Api(value = "牛接口", tags = "牛接口")
public class CowController {
    @Resource
    ICowService cowService;

    /**
     * 牛死亡接口
     * @return
     */
    @PostMapping(value = "die",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛死亡接口", value = "牛死亡接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "牛死亡接口参数", dataType = "ReqCowIdVO")
    public Integer cowDie(@RequestBody @Validated ReqCowIdVO vo) {
        return cowService.cowDie(vo);
    }
    /**
     * 牛生病接口
     * @return
     */
    @PostMapping(value = "ill",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛生病接口", value = "牛生病接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "牛生病接口", dataType = "ReqCowIdVO")
    public Integer cowIll(@RequestBody @Validated ReqCowIdVO vo) {
        return cowService.cowIll(vo);
    }
    /**
     * 牛治愈接口
     * @return
     */
    @PostMapping(value = "cure",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛治愈接口", value = "牛治愈接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "牛治愈接口", dataType = "ReqCowIdVO")
    public Integer cowNormal(@RequestBody @Validated ReqCowIdVO vo) {
        return cowService.cowCure(vo);
    }
    /**
     * 牛怀孕接口
     * @return
     */
    @PostMapping(value = "fetation",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛怀孕接口", value = "牛怀孕接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "牛怀孕接口", dataType = "ReqCowIdVO")
    public Integer cowFetation(@RequestBody @Validated ReqCowIdVO vo) {
        return cowService.cowFetation(vo);
    }
    /**
     * 牛分娩接口
     * @return
     */
    @PostMapping(value = "childbirth",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛分娩接口", value = "牛分娩接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "牛分娩接口", dataType = "ReqCowChildbirthVO")
    public Integer cowChildbirth(@RequestBody @Validated ReqCowChildbirthVO vo) {
        return cowService.cowChildbirth(vo);
    }
    /**
     * 牛售卖接口
     * @return
     */
    @PostMapping(value = "sale",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛售卖接口", value = "牛售卖接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "牛售卖接口", dataType = "ReqCowSaleVO")
    public Integer cowSale(@RequestBody @Validated ReqCowSaleVO vo) {
        return cowService.cowSale(vo);
    }
    /**
     * 牛基本信息接口
     *
     * @return
     */
    @PostMapping(value = "info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛基本信息接口", value = "牛基本信息接口", response = RespCowInfoVO.class)
    @ApiImplicitParam(name = "vo", value = "牛基本信息接口参数", dataType = "ReqCowIdVO")
    public RespCowInfoVO cowInfo(@RequestBody @Validated ReqCowIdVO vo) {
        return null;
    }

    /**
     * 出栏牛列表信息接口
     *
     * @return
     */
    @PostMapping(value = "/such/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "出栏牛列表信息接口", value = "出栏牛列表信息接口", response = RespCowListVO.class)
    @ApiImplicitParam(name = "vo", value = "出栏牛列表信息接口参数", dataType = "ReqCowListVO")
    public PageInfo<RespCowListVO> suchCowList(@RequestBody @Validated ReqCowListVO vo) {
        vo.setSuch(true);
        return cowService.cowList(vo);
    }
    /**
     * 存栏牛列表信息接口
     *
     * @return
     */
    @PostMapping(value = "/notSuch/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "存栏牛列表信息接口", value = "存栏牛列表信息接口", response = RespCowListVO.class)
    @ApiImplicitParam(name = "vo", value = "存栏牛列表信息接口参数", dataType = "ReqCowListVO")
    public PageInfo<RespCowListVO> notSuchCowList(@RequestBody @Validated ReqCowListVO vo) {
        vo.setSuch(false);
        return cowService.cowList(vo);
    }
    /**
     * 新增牛基本信息接口
     *
     * @return
     */
    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增牛基本信息接口", value = "新增牛基本信息接口", response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "新增牛基本信息接口参数", dataType = "ReqCowCreateVO")
    public Integer cowCreate(@RequestBody @Validated ReqCowCreateVO vo) {
        return cowService.cowCreate(vo);
    }

    /**
     * 修改牛基本信息接口
     *
     * @return
     */
    @PostMapping(value = "update/info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "修改牛基本信息接口", value = "修改牛基本信息接口")
    @ApiImplicitParam(name = "vo", value = "修改牛基本信息接口参数", dataType = "ReqCowUpdateVO")
    public Integer cowUpdateInfo(@RequestBody @Validated ReqCowUpdateVO vo) {
        return 1;
    }
}
