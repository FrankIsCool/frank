package com.sxmaps.my.common;

import com.franks.util.exception.ApiException;
import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.vo.resp.function.RespFunctionsVO;
import org.springframework.stereotype.Component;

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
public class FunctionsThreadLocal {

    private static final Map<String, Map<Long, Boolean>> functionsMap = new HashMap<>();

    /**
     * 获取当前登录用户是否有该功能权限
     *
     * @param
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    public static Boolean clickFunction(String functionSn, Long userUid) {
        if (!functionsMap.containsKey(functionSn)) {
            throw new ApiException(ApiExceptionEnum.NOTFOUND.getExceptionCode(),ApiExceptionEnum.NOTFOUND.getExceptionCode());
        }
        Map<Long, Boolean> user = functionsMap.get(functionSn);
        if (user.containsKey(userUid)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 缓存用户权限相关信息
     *
     * @param
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    public static void addFunctions(List<RespFunctionsVO> functions, Long userUid) {
        functions.stream().forEach(function -> {
            Map<Long, Boolean> map;
            if (!functionsMap.containsKey(function.getFunctionSn())) {
                map = new HashMap<>();
            } else {
                map = functionsMap.get(function.getFunctionSn());
            }
            map.put(userUid, Boolean.FALSE);
            functionsMap.put(function.getFunctionSn(), map);
        });
    }

}
