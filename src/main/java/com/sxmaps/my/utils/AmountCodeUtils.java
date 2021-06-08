package com.sxmaps.my.utils;

import org.springframework.stereotype.Component;

@Component
public class AmountCodeUtils {

	public static void main(String[] args) {
		System.out.println(new AmountCodeUtils().digitUppercase(5880));
	}

	/**
	 * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零 要用到正则表达式
	 */
	public String digitUppercase(double amount) {
		String fraction[] = { "角", "分" };
		String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String unit[][] = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };
		String head = amount < 0 ? "负" : "";
		amount = Math.abs(amount);
		String couAmount = "";
		for (int i = 0; i < fraction.length; i++) {
			couAmount += (digit[(int) (Math.floor(amount * 10 * Math.pow(10, i)) % 10)] + fraction[i])
					.replaceAll("(零.)+", "");
		}
		if (couAmount.length() < 1) {
			couAmount = "整";
		}
		int integerPart = (int) Math.floor(amount);
		for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
			String pstr = "";
			for (int j = 0; j < unit[1].length && amount > 0; j++) {
				pstr = digit[integerPart % 10] + unit[1][j] + pstr;
				integerPart = integerPart / 10;
			}
			couAmount = pstr.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + couAmount;
		}
		return head + couAmount.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零")
				.replaceAll("^整$", "零元整");
	}
}
