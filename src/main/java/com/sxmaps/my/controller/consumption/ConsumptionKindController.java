package com.sxmaps.my.controller.consumption;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类：消费类型接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/consumption/kind")
@Api(value = "消费类型接口", tags = "消费类型接口")
public class ConsumptionKindController {
    /**
     * 新增消费类型接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增消费类型接口", value = "新增消费类型接口")
    public String consumptionKindCreate() {
        return "20";
    }
    /**
     * 消费类型信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "消费类型信息接口", value = "消费类型信息接口")
    public String consumptionKindInfo() {
        return "20";
    }
    /**
     * 消费类型列表接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "消费类型列表接口", value = "消费类型列表接口")
    public String consumptionKindList() {
        return "20";
    }
    /**
     * 所有消费类型接口
     * @return
     */
    @PostMapping(value = "all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "所有消费类型接口", value = "所有消费类型接口")
    public String consumptionKindAll() {
        return "20";
    }
    /**
     * 删除消费类型接口
     * @return
     */
    @PostMapping(value = "del",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除消费类型接口", value = "删除消费类型接口")
    public String consumptionKindDel() {
        return "20";
    }
}
