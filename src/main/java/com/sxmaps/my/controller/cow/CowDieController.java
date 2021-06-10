package com.sxmaps.my.controller.cow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
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
    @ApiOperation(notes = "牛死亡接口", value = "牛死亡接口")
    public String cowDieCreate() {
        return "20";
    }
    /**
     * 牛死亡信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛死亡信息接口", value = "牛死亡信息接口")
    public String cowDieInfo() {
        return "20";
    }
    /**
     * 已死亡牛列表接口
     * @return
     */
    @PostMapping(value = "die/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "已死亡牛列表接口", value = "已死亡牛列表接口")
    public String cowDieList() {
        return "20";
    }
}
