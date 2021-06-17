package com.sxmaps.my.aspect;

import com.alibaba.fastjson.JSONObject;
import com.sxmaps.my.common.LoginThreadLocal;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 类：项目启动完成后，加载登录相关信息
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/17
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Autowired
    ILoginService loginService;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        loginService.getLogins().stream().forEach(login ->{
            UserInfoVo userInfoVo = JSONObject.parseObject(login.getUserInfo(), UserInfoVo.class);
            if(userInfoVo.getValidTime().compareTo(new Date())>0){
                LoginThreadLocal.addUserInfoVo(userInfoVo);
            }
        });
    }
}
