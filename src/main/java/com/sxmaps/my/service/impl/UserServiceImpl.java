package com.sxmaps.my.service.impl;

import com.franks.util.exception.ApiException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.LoginThreadLocal;
import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.enums.StateEnum;
import com.sxmaps.my.enums.UserTypeEnum;
import com.sxmaps.my.mapper.UserMapper;
import com.sxmaps.my.model.User;
import com.sxmaps.my.service.ILoginService;
import com.sxmaps.my.service.IUserService;
import com.sxmaps.my.vo.req.farmers.ReqFarmersDelVO;
import com.sxmaps.my.vo.req.user.ReqUserCreateVO;
import com.sxmaps.my.vo.req.user.ReqUserListVO;
import com.sxmaps.my.vo.req.user.ReqUsersUidVO;
import com.sxmaps.my.vo.req.user.ReqUsersUpdateVO;
import com.sxmaps.my.vo.resp.user.RespUserVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Integer createUser(ReqUserCreateVO vo) {
        if(null == UserTypeEnum.getEnum(vo.getUserType())){
            throw new ApiException(ApiExceptionEnum.NOTUSERTYPE.getExceptionCode(),ApiExceptionEnum.NOTUSERTYPE.getExceptionCode());
        }
        User user = new User();
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setDel(StateEnum.NOTDEL.getState().byteValue());
        user.setPhone(vo.getPhone());
        user.setUserName(vo.getName());
        user.setUserType(vo.getType().byteValue());
        user.setFarmersUid(vo.getFarmersUid());
        user.setPassword(vo.getPassword());
        return userMapper.insert(user);
    }

    @Override
    @Transactional
    public Integer delUsers(ReqFarmersDelVO vo) {
        List<User> users = userMapper.getUsersByFarmersUid(vo.getFarmersUid());
        List<String> tokens = loginService.getTokens(users.stream().map(User::getUid).collect(Collectors.toList()));
        LoginThreadLocal.removeUserInfoVo(tokens);
        return userMapper.delUsers(vo.getFarmersUid());
    }

    @Override
    @Transactional
    public Integer recoverUser(ReqUsersUidVO vo) {
        User users = userMapper.selectByPrimaryKey(vo.getUid());
        users.setDel(StateEnum.NOTDEL.getState().byteValue());
        users.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(users);
    }

    @Override
    public Integer updateUser(ReqUsersUpdateVO vo) {
        User users = userMapper.selectByPrimaryKey(vo.getUid());
        if(users.getFarmersUid()!=vo.getFarmersUid()){
            throw new ApiException(ApiExceptionEnum.NOTFARMERSUSER.getExceptionCode(),ApiExceptionEnum.NOTFARMERSUSER.getExceptionCode());
        }
        users.setUserName(vo.getName());
        users.setPhone(vo.getPhone());
        users.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(users);
    }

    @Override
    @Transactional
    public Integer delUser(ReqUsersUidVO vo) {
        User users = userMapper.selectByPrimaryKey(vo.getUid());
        if(users.getUserType().intValue()==UserTypeEnum.USERTYP_1.getState()){
            throw new ApiException(ApiExceptionEnum.EXCEPTION.getExceptionCode(),ApiExceptionEnum.EXCEPTION.getExceptionCode());
        }
        List<Long> userUids = new ArrayList<>();
        userUids.add(users.getUid());
        List<String> tokens = loginService.getTokens(userUids);
        LoginThreadLocal.removeUserInfoVo(tokens);
        users.setDel(StateEnum.DEL.getState().byteValue());
        users.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(users);
    }

    @Override
    public User getFarmersUser(Long farmersUid) {
        return userMapper.getFarmersUsersByFarmersUid(farmersUid);
    }

    @Override
    public PageInfo<RespUserVO> getFarmersUsers(ReqUserListVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        List<RespUserVO> userVOS = userMapper.getUsersListByFarmersUid(vo);
        return new PageInfo<>(userVOS);
    }
}
