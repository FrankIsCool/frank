package com.sxmaps.my.utils;

import java.util.Random;

public class RandomCode {

	public static String getSixRandCode() {
		Random random = new Random();
		String result = "";
		for (int i = 0; i < 6; i++) {
			result += random.nextInt(10);
		}
		return result;

	}
}
