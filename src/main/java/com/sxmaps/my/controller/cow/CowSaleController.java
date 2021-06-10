package com.sxmaps.my.controller.cow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
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
    @ApiOperation(notes = "牛售卖接口", value = "牛售卖接口")
    public String cowSaleCreate() {
        return "20";
    }
    /**
     * 牛售卖信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛售卖信息接口", value = "牛售卖信息接口")
    public String cowSaleInfo() {
        return "20";
    }
    /**
     * 已售卖牛列表接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "已售卖牛列表接口", value = "已售卖牛列表接口")
    public String cowSaleList() {
        return "20";
    }
}
