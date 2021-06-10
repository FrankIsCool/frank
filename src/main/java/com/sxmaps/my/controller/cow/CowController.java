package com.sxmaps.my.controller.cow;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.vo.req.cow.ReqCowCreateVO;
import com.sxmaps.my.vo.req.cow.ReqCowInfoVO;
import com.sxmaps.my.vo.req.cow.ReqCowListVO;
import com.sxmaps.my.vo.req.cow.ReqCowUpdateVO;
import com.sxmaps.my.vo.resp.cow.RespCowInfoVO;
import com.sxmaps.my.vo.resp.cow.RespCowListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 类：牛接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/cow")
@Api(value = "牛接口", tags = "牛接口")
public class CowController {
    /**
     * 牛基本信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛基本信息接口", value = "牛基本信息接口",response = RespCowInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录令牌", dataType = "String"),
            @ApiImplicitParam(name = "vo", value = "新增牛基本信息接口", dataType = "ReqCowInfoVO")
    })
    public RespCowInfoVO cowInfo(@RequestHeader("token") String token , @RequestBody @Validated ReqCowInfoVO vo) {
        return null;
    }
    /**
     * 牛列表信息接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛列表信息接口", value = "牛列表信息接口",response = RespCowListVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录令牌", dataType = "String"),
            @ApiImplicitParam(name = "vo", value = "牛列表信息接口", dataType = "ReqCowListVO")
    })
    public PageInfo<RespCowListVO> cowList(@RequestHeader("token") String token , @RequestBody @Validated ReqCowListVO vo) {
        return null;
    }
    /**
     * 新增牛基本信息接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增牛基本信息接口", value = "新增牛基本信息接口",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录令牌", dataType = "String"),
            @ApiImplicitParam(name = "vo", value = "新增牛基本信息接口", dataType = "ReqCowCreateVO")
    })
    public Integer cowCreate(@RequestHeader("token") String token , @RequestBody @Validated ReqCowCreateVO vo) {
        return 1;
    }
    /**
     * 修改牛基本信息接口
     * @return
     */
    @PostMapping(value = "update/info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "修改牛基本信息接口", value = "修改牛基本信息接口")
    public Integer cowUpdateInfo(@RequestHeader("token") String token ,@RequestBody @Validated ReqCowUpdateVO vo) {
        return 1;
    }
}
