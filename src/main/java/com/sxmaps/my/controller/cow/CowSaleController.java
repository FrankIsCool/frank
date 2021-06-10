package com.sxmaps.my.controller.cow;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;
import com.sxmaps.my.vo.req.cow.ReqCowSaleListVO;
import com.sxmaps.my.vo.req.cow.ReqCowSaleVO;
import com.sxmaps.my.vo.resp.cow.RespCowSaleInfoVO;
import com.sxmaps.my.vo.resp.cow.RespCowSaleListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类：牛售卖接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/cow/sale")
@Api(value = "牛售卖接口", tags = "牛售卖接口")
public class CowSaleController {
    /**
     * 牛售卖接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛售卖接口", value = "牛售卖接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "牛售卖接口参数", dataType = "ReqCowIdVO")
    public Integer cowSaleCreate(@RequestBody @Validated ReqCowSaleVO vo) {
        return 1;
    }
    /**
     * 牛售卖信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛售卖信息接口", value = "牛售卖信息接口",response = RespCowSaleInfoVO.class)
    @ApiImplicitParam(name = "vo", value = "牛售卖信息接口参数", dataType = "ReqCowIdVO")
    public RespCowSaleInfoVO cowSaleInfo(@RequestBody @Validated ReqCowIdVO vo) {
        return null;
    }
    /**
     * 已售卖牛列表接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "已售卖牛列表接口", value = "已售卖牛列表接口",response = RespCowSaleListVO.class)
    @ApiImplicitParam(name = "vo", value = "已售卖牛列表接口参数", dataType = "ReqCowSaleListVO")
    public PageInfo<RespCowSaleListVO> cowSaleList(@RequestBody @Validated ReqCowSaleListVO vo) {
        return null;
    }
}
