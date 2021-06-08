package com.sxmaps.mms.utils;

public class ByteUtils {

	public static String bytesToString(byte[] encrytpByte) {
		String result = "";
		for (Byte bytes : encrytpByte) {
			result += bytes.toString() + " ";
		}
		return result;
	}

}
