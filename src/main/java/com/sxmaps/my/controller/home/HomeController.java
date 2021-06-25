package com.sxmaps.my.controller.home;

import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.service.ICowService;
import com.sxmaps.my.service.IScheduleService;
import com.sxmaps.my.utils.DateUtil;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;
import com.sxmaps.my.vo.resp.home.RespHomeCowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/19
 */
@RestController
@RequestMapping("/check/home")
@Api(value = "牛接口", tags = "牛接口")
public class HomeController {

    @Resource
    ICowService cowService;
    @Resource
    IScheduleService iScheduleService;
    /**
     * 牛只总数
     *
     * @return
     */
    @PostMapping(value = "cow", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛只总数", value = "牛只总数", response = RespHomeCowVO.class)
    @ApiImplicitParam(name = "vo", value = "牛只总数", dataType = "UserInfoVo")
    public RespHomeCowVO cowCount(@RequestBody @Validated UserInfoVo vo) {
        return cowService.cowCount(vo);
    }

    /**
     * 牛只总数
     *
     * @return
     */
    @PostMapping(value = "collect", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛只总数", value = "牛只总数")
    @ApiImplicitParam(name = "vo", value = "牛只总数")
    public void kinds() {
        iScheduleService.kind();
    }
}
