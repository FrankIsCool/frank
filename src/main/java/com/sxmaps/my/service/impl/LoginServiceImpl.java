package com.sxmaps.my.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.franks.util.date.DateUtil;
import com.sxmaps.my.common.FunctionsThreadLocal;
import com.sxmaps.my.common.LoginThreadLocal;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.enums.StateEnum;
import com.sxmaps.my.enums.UserTypeEnum;
import com.sxmaps.my.exception.ApiException;
import com.sxmaps.my.mapper.FarmersMapper;
import com.sxmaps.my.mapper.LoginMapper;
import com.sxmaps.my.mapper.UserMapper;
import com.sxmaps.my.model.Farmers;
import com.sxmaps.my.model.Login;
import com.sxmaps.my.model.User;
import com.sxmaps.my.service.IFunctionService;
import com.sxmaps.my.service.ILoginService;
import com.sxmaps.my.utils.UUIDUtil;
import com.sxmaps.my.vo.req.login.ReqLoginVO;
import com.sxmaps.my.vo.resp.function.RespFunctionsVO;
import com.sxmaps.my.vo.resp.login.RespLoginVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    UserMapper userMapper;

    @Resource
    FarmersMapper farmersMapper;

    @Resource
    LoginMapper loginMapper;

    @Resource
    IFunctionService functionService;

    @Override
    @Transactional
    public RespLoginVO login(ReqLoginVO vo) {
//        获取用户基本信息
        User user = userMapper.getUserByPhone(vo.getPhone());
        if (null == user) {
            throw new ApiException(ApiExceptionEnum.NOTUSER);
        }
        if (!user.getPassword().equals(vo.getPassword())) {
            throw new ApiException(ApiExceptionEnum.PASSWORDERROR);
        }
        if (StateEnum.DEL.getState() == user.getDel().intValue()) {
            throw new ApiException(ApiExceptionEnum.DELUSER);
        }
//      获取用户是否已经登录
        Login login = loginMapper.getLoginByUserUid(user.getUid());
        if (null != login) {
            LoginThreadLocal.removeUserInfoVo(login.getToken());
            login.setDel(StateEnum.DEL.getState().byteValue());
            loginMapper.updateByPrimaryKey(login);
        }
        Farmers farmers =null;
        if (user.getUserType() == UserTypeEnum.USERTYP_1.getState().byteValue()
                || user.getUserType() == UserTypeEnum.USERTYP_2.getState().byteValue()) {
            farmers = farmersMapper.selectByPrimaryKey(user.getFarmersUid());
        }
//      增加新的用户登录信息
        Login newLogin = new Login();
        newLogin.setUserUid(user.getUid());
        newLogin.setDel(StateEnum.NOTDEL.getState().byteValue());
        newLogin.setToken(UUIDUtil.getUUID());
        newLogin.setCreateTime(new Date());
        int addDateNum = 1;
        if (vo.getIsRemember()) {
            addDateNum = 7;
        }
        newLogin.setValidTime(DateUtil.addDay(addDateNum));
        UserInfoVo infoVo = new UserInfoVo();
        infoVo.setUserUid(user.getUid());
        infoVo.setUserName(user.getUserName());
        infoVo.setToken(newLogin.getToken());
        infoVo.setValidTime(newLogin.getValidTime());
        infoVo.setUserType(user.getUserType().intValue());
        List<RespFunctionsVO> functions = functionService.getFunctions(user.getUid());
        infoVo.setFunctionsMap(functions.stream().collect(Collectors.toMap(RespFunctionsVO::getFunctionPath, Function.identity())));
        if(null != farmers){
            infoVo.setFarmersName(farmers.getFarmersName());
            infoVo.setFarmersUid(farmers.getUid());
        }
        newLogin.setUserInfo(JSONObject.toJSONString(infoVo));
        loginMapper.insert(newLogin);


//        缓存新的用户信息
        LoginThreadLocal.addUserInfoVo(infoVo);
        FunctionsThreadLocal.addFunctions(functions,infoVo.getUserUid());
//        拼装返回数据
        RespLoginVO loginVO = new RespLoginVO();
        loginVO.setToken(newLogin.getToken());
        loginVO.setUserName(user.getUserName());
        loginVO.setFarmersName("明远集团");
        loginVO.setFunctionsVOS(functions);
        if(null != farmers){
            loginVO.setFarmersName(farmers.getFarmersName());
        }
        return loginVO;
    }

    @Override
    public Integer loginOut(String token) {
        LoginThreadLocal.removeUserInfoVo(token);
        return 1;
    }

    @Override
    public List<Login> getLogins() {
        return loginMapper.getLogins();
    }

    @Override
    public List<String> getTokens(List<Long> userUids) {
        return loginMapper.getLoginByUserUids(userUids);
    }
}
