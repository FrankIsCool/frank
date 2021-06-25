package com.sxmaps.my.controller.pay;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类：消费接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/consumption")
@Api(value = "消费接口", tags = "消费接口")
public class ConsumptionController {
    /**
     * 新增消费接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增消费接口", value = "新增消费接口")
    public String consumptionCreate() {
        return "20";
    }
    /**
     * 消费信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "消费信息接口", value = "消费信息接口")
    public String consumptionInfo() {
        return "20";
    }
    /**
     * 消费列表接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "消费类型列表接口", value = "消费类型列表接口")
    public String consumptionList() {
        return "20";
    }
    /**
     * 删除消费接口
     * @return
     */
    @PostMapping(value = "del",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除消费接口", value = "删除消费接口")
    public String consumptionDel() {
        return "20";
    }
}
