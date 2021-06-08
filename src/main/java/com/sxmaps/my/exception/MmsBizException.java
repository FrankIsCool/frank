/**
 * 
 */
package com.sxmaps.mms.exception;

/**
 * @author gongqingzhuan
 * @data 2018年3月13日
 *
 */
@SuppressWarnings("serial")
public class MmsBizException extends RuntimeException {

	/**
	 * 数据库异常编码
	 */
	public static Integer DB_CODE = 1046;

	/**
	 * 业务异常编码
	 */
	public static Integer BIZ_CODE = 3046;

	public static String DB_MSG = "数据库操作异常";
	
	public final static  String DATA_NULL = "导入失败，模板为空";
	
	public final static  String EXCEL_ERROR = "导入成功，未发现可导入的学员";

	public static Integer NO_CODE = 200;
	private Integer code;

	public MmsBizException() {
		super();
	}

	public MmsBizException(String message, Throwable cause) {
		super(message, cause);
	}

	public MmsBizException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
