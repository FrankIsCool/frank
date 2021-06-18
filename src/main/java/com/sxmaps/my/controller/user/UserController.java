package com.sxmaps.my.controller.user;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.enums.UserTypeEnum;
import com.sxmaps.my.service.IUserService;
import com.sxmaps.my.vo.req.user.ReqUserCreateVO;
import com.sxmaps.my.vo.req.user.ReqUserListVO;
import com.sxmaps.my.vo.req.user.ReqUsersUidVO;
import com.sxmaps.my.vo.req.user.ReqUsersUpdateVO;
import com.sxmaps.my.vo.resp.user.RespUserVO;
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
     * 新增子账户接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增子账户接口", value = "新增子账户接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "新增子账户接口", dataType = "ReqUserCreateVO")
    public Integer userCreate(@RequestBody @Validated ReqUserCreateVO vo) {
        vo.setType(UserTypeEnum.USERTYP_2.getState());
        return userService.createUser(vo);
    }
    /**
     * 查询牧场账户接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "查询牧场账户接口", value = "查询牧场账户接口",response = RespUserVO.class)
    @ApiImplicitParam(name = "vo", value = "查询牧场账户接口", dataType = "ReqUserListVO")
    public PageInfo<RespUserVO> userList(@RequestBody @Validated ReqUserListVO vo) {
        return userService.getFarmersUsers(vo);
    }
    /**
     * 注销子账户
     * @return
     */
    @PostMapping(value = "cancel",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "注销子账户", value = "注销子账户",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "注销子账户", dataType = "ReqUsersUidVO")
    public Integer usersCancel(@RequestBody @Validated ReqUsersUidVO vo) {
        return userService.delUser(vo);
    }
    /**
     * 恢复子账户
     * @return
     */
    @PostMapping(value = "recover",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "恢复子账户", value = "恢复子账户",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "恢复子账户", dataType = "ReqUsersUidVO")
    public Integer userRecover(@RequestBody @Validated ReqUsersUidVO vo) {
        return userService.recoverUser(vo);
    }
    /**
     * 修改主账号信息
     * @return
     */
    @PostMapping(value = "update",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "修改主账号信息", value = "修改主账号信息",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "修改主账号信息", dataType = "ReqUsersUpdateVO")
    public Integer userUpdate(@RequestBody @Validated ReqUsersUpdateVO vo) {
        return userService.updateUser(vo);
    }
}
