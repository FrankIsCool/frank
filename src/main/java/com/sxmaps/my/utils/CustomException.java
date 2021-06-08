package com.sxmaps.mms.utils;

/**
 * 自定义异常
 * 
 * @author angelo
 * 
 */
public class CustomException extends Exception
{
	private static final long serialVersionUID = 6089162414358902343L;

	public CustomException()
	{
		super();
	}

	public CustomException(Throwable e)
	{
		super(e);
	}

	public CustomException(String msg)
	{
		super(msg);
	}

	public CustomException(String msg, Throwable e)
	{
		super(msg, e);
	}
}
