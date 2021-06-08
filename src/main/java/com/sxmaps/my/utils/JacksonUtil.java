package com.sxmaps.mms.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cglib.beans.BeanMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 工具类:Jackson
 * 
 *
 */
public final class JacksonUtil {

	private static final Log logger = LogFactory.getLog(JacksonUtil.class);
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	static {
		
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}
	
	public static ObjectMapper getInstance() {
		
		return objectMapper;
	}
	
	/**
	 * 将JSON字符串转换成JavaBean
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T toBean(String json, Class<T> clazz) {
		
		T bean = null;
		try {
			
			bean = objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			
			logger.error("将字符串转换成JavaBean，出错了！", e);
		}
		return bean;
	}
	
	/**
	 * 将Map转换成JavaBean
	 * 
	 * @param <T>
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T toBean(Map<?, ?> map, Class<T> clazz) {
		
		T bean = null;
		try {
		
			bean = objectMapper.convertValue(map, clazz);
		} catch (Exception e) {
			
			logger.error("将Map转换成JavaBean，出错了！", e);
		}
		return bean;
	}
	
	/**
	 * 将JSON字符串转换成List<JavaBean>
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> toBeanList(String json, Class<T> clazz) {
		
		List<T> result = null;
		try {
			
			List<Map<?, ?>> list = objectMapper.readValue(json, new TypeReference<List<T>>(){});
			boolean flag = null == list ? false : list.isEmpty();
			if (!flag) {
				
				result = new ArrayList<T>();
				for (Map<?, ?> map : list) {
					
					result.add(toBean(map, clazz));
				}
			}
		} catch (Exception e) {
			
			logger.error("将字符串转换成List<JavaBean>，出错了！", e);
		}
		return result;
	}
	
	/**
	 * 将JSON字符串转换成Map
	 * 
	 * @param json
	 * @return
	 */
	public static Map<?, ?> toMap(String json) {
		
		Map<?, ?> map = null;
		try {
			
			map = objectMapper.readValue(json, Map.class);
		} catch (Exception e) {
			
			logger.error("转换出错: ".concat(json), e);
		}
		return map;
	}
	
	/**
	 * 将JSON字符串转换成List
	 * 
	 * @param json
	 * @return
	 */
	public static List<?> toList(String json) {
		
		List<?> list = null;
		try {
			
			list = objectMapper.readValue(json, List.class);
		} catch (Exception e) {
			
			logger.error("将JSON字符串转换成List，出错了！", e);
		}
		return list;
	}
	
	
	/** 
	    * 将对象装换为map 
	    * @param bean 
	    * @return 
	    */  
	    public static <T> Map<Object, Object> beanToMap(T bean) {  
	     Map<Object, Object> map = new HashMap<Object, Object>();
	     if (bean != null) {  
	         Object value;
	         BeanMap beanMap = BeanMap.create(bean);  
	         for (Object key : beanMap.keySet()) {
	             value = beanMap.get(key);
	             if(value !=null ){
	                 map.put(key+"", value);
	             }
	         }             
	     }  
	     return map;  
	    } 
	
	private JacksonUtil() {}
}
