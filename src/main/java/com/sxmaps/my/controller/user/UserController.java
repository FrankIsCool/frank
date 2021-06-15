package com.sxmaps.my.controller.user;

import com.sxmaps.my.enums.UserTypeEnum;
import com.sxmaps.my.service.IUserService;
import com.sxmaps.my.vo.req.farmers.ReqFarmersCreateVO;
import com.sxmaps.my.vo.req.farmers.ReqFarmersDelVO;
import com.sxmaps.my.vo.req.user.ReqUserCreateVO;
import com.sxmaps.my.vo.req.user.ReqUsersDelVO;
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
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/15
 */
@RestController
@RequestMapping("/check/user")
@Api(value = "用户相关接口", tags = "用户相关接口")
public class UserController {
    @Resource
    IUserService userService;
    /**
     * 新增场主接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增子账户接口", value = "新增子账户接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "新增子账户接口", dataType = "ReqUserCreateVO")
    public Integer farmersCreate(@RequestBody @Validated ReqUserCreateVO vo) {
        vo.setUserType(UserTypeEnum.USERTYP_2.getState());
        return userService.createUser(vo);
    }
    /**
     * 注销子账户
     * @return
     */
    @PostMapping(value = "cancel",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "注销子账户", value = "注销子账户",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "注销子账户", dataType = "ReqUsersDelVO")
    public Integer farmersCancel(@RequestBody @Validated ReqUsersDelVO vo) {
        return userService.delUser(vo);
    }
}
