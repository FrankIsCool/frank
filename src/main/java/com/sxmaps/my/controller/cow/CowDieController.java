package com.sxmaps.my.controller.cow;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.vo.req.cow.ReqCowDieListVO;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;
import com.sxmaps.my.vo.resp.cow.RespCowDieInfoVO;
import com.sxmaps.my.vo.resp.cow.RespCowDieListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类：牛死亡接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/cow/die")
@Api(value = "牛死亡接口", tags = "牛死亡接口")
public class CowDieController {
    /**
     * 牛死亡接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛死亡接口", value = "牛死亡接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "牛死亡接口参数", dataType = "ReqCowIdVO")
    public Integer cowDieCreate(@RequestBody @Validated ReqCowIdVO vo) {
        return 1;
    }
    /**
     * 牛死亡信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛死亡信息接口", value = "牛死亡信息接口",response = RespCowDieInfoVO.class)
    @ApiImplicitParam(name = "vo", value = "牛死亡信息接口参数", dataType = "ReqCowIdVO")
    public RespCowDieInfoVO cowDieInfo(@RequestBody @Validated ReqCowIdVO vo) {
        return null;
    }
    /**
     * 已死亡牛列表接口
     * @return
     */
    @PostMapping(value = "die/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "已死亡牛列表接口", value = "已死亡牛列表接口",response = RespCowDieListVO.class)
    @ApiImplicitParam(name = "vo", value = "已死亡牛列表接口参数", dataType = "ReqCowDieListVO")
    public PageInfo<RespCowDieListVO> cowDieList(@RequestBody @Validated ReqCowDieListVO vo) {
        return null;
    }
}
