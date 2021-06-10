package com.sxmaps.my.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.exception.ApiException;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.Map;
import java.util.Set;

/**
 * 对HttpServletRequest进行重写，
 * 1、用来接收application/json参数数据类型，即@RequestBody注解标注的参数,解决多次读取问题
 * 2、用来解决注解@RequestParam通过POST/PUT/DELETE/PATCH方法传递参数，解决多次读取问题
 * 首先看一下springboot控制器三个注解：
 * 1、@PathVariable注解是REST风格url获取参数的方式，只能用在GET请求类型，通过getParameter获取参数
 * 2、@RequestParam注解支持GET和POST/PUT/DELETE/PATCH方式，Get方式通过getParameter获取参数和post方式通过getInputStream或getReader获取参数
 * 3、@RequestBody注解支持POST/PUT/DELETE/PATCH，可以通过getInputStream和getReader获取参数
 * @create: 2020/8/19
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    private final Logger logger = LoggerFactory.getLogger(RequestWrapper.class);

    //参数字节数组
    private byte[] requestBody;
    //Http请求对象
    private HttpServletRequest request;

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.request = request;
    }

    /**
     * @return
     * @throws IOException
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        /**
         * 每次调用此方法时将数据流中的数据读取出来，然后再回填到InputStream之中
         * 解决通过@RequestBody和@RequestParam（POST方式）读取一次后控制器拿不到参数问题
         */
        if (null == this.requestBody) {
            String token = request.getHeader("token");
            if(StringUtils.isEmpty(token)){
                throw new ApiException(ApiExceptionEnum.PARAM_TOKEN);
            }
            this.requestBody = StreamUtils.copyToByteArray(request.getInputStream());
            Map map = JSONObject.parseObject(new String(this.requestBody),Map.class);
            getUserInfo(token,map);
            this.requestBody = JSONObject.toJSONBytes(map);
        }

        final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody);
        return new ServletInputStream() {

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {}

            @Override
            public int read() {
                return bais.read();
            }
        };
    }
    /**
     * 根据token获取当前登录人信息
     *
     * @param token 登录令牌
     * @return UserInfoVo 当前登录人信息
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    private void getUserInfo(String token,Map map) {
        UserInfoVo userInfo = getUserInfo(token);
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(userInfo));
        Set<String> keys = jsonObject.keySet();
        for(String key : keys){
            map.put(key, jsonObject.get(key));
        }
        logger.info("线程id: {},  登录人信息: {}",Thread.currentThread().getId(),userInfo);

    }
    private UserInfoVo getUserInfo(String token) {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setToken(token);
        userInfoVo.setLivestockName("明远牧场");
        userInfoVo.setLivestockUide("001");
        userInfoVo.setUserName("frank");
        userInfoVo.setUserUid("001");
        return userInfoVo;
    }
    public byte[] getRequestBody() {
        return requestBody;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
}
