package com.sxmaps.mms.common;

import java.util.HashMap;
import java.util.Map;

public class OperationConstant {
	/**
	 * 正常
	 */
	public static String STATE_NORMAL = "1";
	/**
	 * 删除
	 */
	public static String STATE_DEL = "-1";
	/**
	 * 停用
	 */
	public static String STATE_STOP = "0";
	/**
	 * 已分配
	 */
	public static Integer STATE_ALLOCATED = 1;
	
	public final static String TITLE_RESUBMIT = "通知：业务系统导入虹光数据任务已完成，点击查看结果";

	/***
	 * 2
	 *
	 */
	public static Integer ZERO = 0;

	public static Integer ONE = 1;

	public static Integer TWO = 2;
	
	public static Integer SEVEN = 7;

	public static Integer THIRTY = 30;

	public static String OPERATION = "手动";

	public static String MEMBER_TYPE_01 = "未开发";

	public static String MEMBER_TYPE_02 = "老带新";

	public static String MEMBER_TYPE_03 = "续报学员";
	
	public static String TASK_IMPORT = "mms_user_id:";
	
	public static Long time = 60 * 60l;

	public final static Map<Integer,String> MAP = new HashMap<Integer,String>(2);

	static {
		MAP.put(ONE, "续报学员");
		MAP.put(TWO, "老带新学员");
	}
}
