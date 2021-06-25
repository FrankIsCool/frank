package com.sxmaps.my.common;

import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.exception.ApiException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类：缓存登录信息对象
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Component
public class LoginThreadLocal {

    private static final Map<String,UserInfoVo> userInfoVoMap = new HashMap<>();

//    @Autowired
//    ILoginService loginService;
//
//    LoginThreadLocal()  {
//        loginService.getLogins().stream().forEach(login ->{
//            UserInfoVo userInfoVo = JSONObject.parseObject(login.getUserInfo(), UserInfoVo.class);
//            if(userInfoVo.getValidTime().compareTo(new Date())>0){
//                userInfoVoMap.put(userInfoVo.getToken(),userInfoVo);
//            }
//        });
//    }

    /**
     * 根据token获取用户信息
     * @param
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    public static UserInfoVo getUserInfoVo(String token){
        if(!userInfoVoMap.containsKey(token)){
            throw new ApiException(ApiExceptionEnum.NOTVALID_TOKEN);
        }
        UserInfoVo userInfoVo = userInfoVoMap.get(token);
        if(userInfoVo.getValidTime().compareTo(new Date())>0){
            return userInfoVoMap.get(token);
        }
        removeUserInfoVo(token);
        throw new ApiException(ApiExceptionEnum.NOTVALIDTIME);
    }
    /**
     * 缓存token信息
     * @param
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    public static void addUserInfoVo(UserInfoVo userInfoVo){
        userInfoVoMap.put(userInfoVo.getToken(),userInfoVo);
    }
    /**
     * 移除token信息
     * @param
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    public static void removeUserInfoVo(String token){
        userInfoVoMap.remove(token);
    }
    /**
     * 移除token信息
     * @param
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    public static void removeUserInfoVo(List<String> tokens){
        if(null == tokens || tokens.size()<1){
            return;
        }
        tokens.forEach(token->{
            userInfoVoMap.remove(token);
        });
    }
    /**
     * 移除token信息
     * @param
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    public static void removeAndAddUserInfoVo(String token,UserInfoVo userInfoVo){
        userInfoVoMap.remove(token);
        userInfoVoMap.put(userInfoVo.getToken(),userInfoVo);
    }
}
