package com.sxmaps.my.controller.pay;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.service.IPayTypeService;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.req.pay.ReqPayListVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeCreateVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeListVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;
import com.sxmaps.my.vo.resp.pay.RespPayListVO;
import com.sxmaps.my.vo.resp.pay.RespPayTypeAllVO;
import com.sxmaps.my.vo.resp.pay.RespPayTypeListVO;
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

import javax.annotation.Resource;
import java.util.List;

/**
 * 类：消费类型接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("check/pay")
@Api(value = "消费接口", tags = "消费接口")
public class PayController {
    @Resource
    IPayTypeService payTypeService;
    /**
     * 新增消费类型接口
     * @return
     */
    @PostMapping(value = "/type/create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增消费类型接口", value = "新增消费类型接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "新增消费类型接口", dataType = "ReqPayTypeCreateVO")
    public Integer payTypeCreate(@RequestBody @Validated ReqPayTypeCreateVO vo) {
        return payTypeService.addPayType(vo);
    }
    /**
     * 所有消费类型接口
     * @return
     */
    @PostMapping(value = "/type/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "所有消费类型接口", value = "所有消费类型接口",response = RespPayTypeAllVO.class)
    @ApiImplicitParam(name = "vo", value = "新增消费类型接口")
    public List<RespPayTypeAllVO> payTypeAll() {
        return payTypeService.getPayTypeAll();
    }
    /**
     * 消费类型列表接口
     * @return
     */
    @PostMapping(value = "/type/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "消费类型列表接口", value = "消费类型列表接口",response = RespPayTypeListVO.class)
    @ApiImplicitParam(name = "vo", value = "消费类型列表接口",dataType = "ReqPayTypeListVO")
    public PageInfo<RespPayTypeListVO> payTypeList(@RequestBody @Validated ReqPayTypeListVO vo) {
        return payTypeService.payTypeList(vo);
    }
    /**
     * 支付记录列表接口
     * @return
     */
    @PostMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "支付记录列表接口", value = "支付记录列表接口",response = RespPayTypeListVO.class)
    @ApiImplicitParam(name = "vo", value = "支付记录列表接口",dataType = "ReqPayListVO")
    public PageInfo<RespPayListVO> payTypeList(@RequestBody @Validated ReqPayListVO vo) {
        return payTypeService.payList(vo);
    }
}
