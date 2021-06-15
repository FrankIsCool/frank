package com.sxmaps.my.service.impl;

import com.sxmaps.my.common.LoginThreadLocal;
import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.enums.StateEnum;
import com.sxmaps.my.enums.UserTypeEnum;
import com.sxmaps.my.exception.ApiException;
import com.sxmaps.my.mapper.UserMapper;
import com.sxmaps.my.model.User;
import com.sxmaps.my.service.ILoginService;
import com.sxmaps.my.service.IUserService;
import com.sxmaps.my.vo.req.farmers.ReqFarmersDelVO;
import com.sxmaps.my.vo.req.user.ReqUserCreateVO;
import com.sxmaps.my.vo.req.user.ReqUsersDelVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserMapper userMapper;
    @Resource
    ILoginService loginService;

    @Override
    public Integer createUser(ReqUserCreateVO vo) {
        if(null == UserTypeEnum.getEnum(vo.getUserType())){
            throw new ApiException(ApiExceptionEnum.NOTUSERTYPE);
        }
        User user = new User();
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setDel(StateEnum.NOTDEL.getState().byteValue());
        user.setPhone(vo.getPhone());
        user.setUserName(vo.getUserName());
        user.setUserType(vo.getUserType().byteValue());
        user.setFarmersUid(vo.getFarmersUid());
        return userMapper.insert(user);
    }

    @Override
    public Integer delUsers(ReqFarmersDelVO vo) {
        List<User> users = userMapper.getUsersByFarmersUid(vo.getFarmersUid());
        List<String> tokens = loginService.getTokens(users.stream().map(User::getUid).collect(Collectors.toList()));
        LoginThreadLocal.removeUserInfoVo(tokens);
        return userMapper.delUsers(vo.getFarmersUid());
    }

    @Override
    public Integer delUser(ReqUsersDelVO vo) {
        User users = userMapper.selectByPrimaryKey(vo.getUserUid());
        List<Long> userUids = new ArrayList<>();
        userUids.add(users.getUid());
        List<String> tokens = loginService.getTokens(userUids);
        LoginThreadLocal.removeUserInfoVo(tokens);
        users.setDel(StateEnum.DEL.getState().byteValue());
        users.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(users);
    }
}
