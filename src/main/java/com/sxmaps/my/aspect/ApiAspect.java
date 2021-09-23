package com.sxmaps.my.aspect;

import com.franks.util.ip.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 类：请求打印相关参数
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/8
 */
@Aspect
@Component
public class ApiAspect {

	private final Logger logger = LoggerFactory.getLogger(ApiAspect.class);

	ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	@Pointcut("execution(public * com.sxmaps.my.controller..*(..))")
	public void log() {
	}

	/**
	 * 执行方法前，记录相关请求数据
	 * 
	 * @param joinPoint
	 */
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		startTime.set(System.currentTimeMillis());
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.info("线程id: {},  请求地址:{}, 请求参数:{},  请求类型:{}, 请求ip:{}",Thread.currentThread().getId(), request.getRequestURL().toString(),
				Arrays.asList(joinPoint.getArgs()), request.getMethod(), IpUtil.getIp(request));
	}

	/**
	 * 执行完成后，记录相关信息
	 */
	@After("log()")
	public void doAfter() {
		// 记录执行时间
		logger.info("线程id: {},  执行时间/毫秒: {}",Thread.currentThread().getId(), System.currentTimeMillis() - startTime.get());
	}
}