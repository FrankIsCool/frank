package com.sxmaps.mms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.utils.RedisUtils;

@RestController
@RequestMapping("/base")
public class BaseController {

	private static String T_TOKEN = "T_token:";

	@Autowired
	RedisUtils redisUtils;

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCurrentUser(String token) {
		Object user = redisUtils.get(T_TOKEN + token);
		if (null == user) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "操作失败,非法的用户,请先登录");
		}
		return JSONObject.parseObject(user.toString(), Map.class);
	}
}
