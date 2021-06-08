package com.sxmaps.mms.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ClassName: ObjectConvert
 * 
 * @Description: 用于vo与po的转换
 * @author angelo
 * @date 2015-11-6
 */
public class ObjectConvertUtil
{
	/**
	 * 获取get方法
	 * 
	 * @param objectClass
	 * @param fieldName
	 * @return
	 * */
	@SuppressWarnings("unchecked")
	public static Method getGetMethod(Class objectClass, String fieldName)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("get");
		sb.append(fieldName.substring(0, 1).toUpperCase());
		sb.append(fieldName.substring(1));
		try
		{
			return objectClass.getMethod(sb.toString());
		}
		catch (Exception e)
		{
		}
		return null;
	}

	/**
	 * 获取set方法
	 * 
	 * @param objectClass
	 * @param fieldName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Method getSetMethod(Class objectClass, String fieldName)
	{
		try
		{
			Class[] parameterTypes = new Class[1];
			Field field = objectClass.getDeclaredField(fieldName);
			parameterTypes[0] = field.getType();
			StringBuffer sb = new StringBuffer();
			sb.append("set");
			sb.append(fieldName.substring(0, 1).toUpperCase());
			sb.append(fieldName.substring(1));
			Method method = objectClass.getMethod(sb.toString(), parameterTypes);
			return method;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 执行set方法
	 * 
	 * @param o
	 * @param fieldName
	 * @param value
	 * */
	public static void invokeSet(Object o, String fieldName, Object value)
	{
		Method method = getSetMethod(o.getClass(), fieldName);
		try
		{
			method.invoke(o, new Object[]
			{ value });
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 执行get方法
	 * 
	 * @param o
	 * @param fieldName
	 * @return
	 * */
	public static Object invokeGet(Object o, String fieldName)
	{
		Method method = getGetMethod(o.getClass(), fieldName);
		try
		{
			return method.invoke(o, new Object[0]);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Description: 转换po为vo
	 * @remark po的属性类型与vo的属性类型需保持一致
	 * @param po
	 * @param voClass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @author angelo
	 * @date 2015-11-6
	 */
	@SuppressWarnings("unchecked")
	public static <PO, VO> VO cast(PO po, Class<VO> voClass)
	{
		try
		{
			// 反射获取VO的实例
			VO vo = (VO) ClassLoader.getSystemClassLoader().loadClass(voClass.getName()).newInstance();
			// 遍历VO所有声明的属性
			for (Field field : voClass.getDeclaredFields())
			{
				Class type = field.getType();
				String name = field.getName();
				// 反射调用绑定的PO属性的get方法进行取值
				Object value = invokeGet(po, name);
				// 需要完善各种属性类型的转换
				if (type.isInstance(value))
				{
					invokeSet(vo, name, value);
				}
			}
			return vo;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Description: 转换po列表为vo列表
	 * @remark
	 * @param poList
	 * @param voClass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @author angelo
	 * @date 2015-11-6
	 */
	public static <VO, PO> List<VO> cast(List<PO> poList, Class<VO> voClass)
	{
		List<VO> voList = new ArrayList<VO>();
		for (PO po : poList)
		{
			VO vo = cast(po, voClass);
			voList.add(vo);
		}
		return voList;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface BindEntity
{
	Class<?> value();
}
