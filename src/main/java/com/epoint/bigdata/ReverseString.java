package com.epoint.bigdata;

/**
 * 功能：将String类型字符串进行翻转
 *
 * @author xumaosheng
 * @date 2019/8/11 0:17
 */
public class ReverseString {
	public static void main(String[] args) {
		reverseString("hello");
	}

	public static String reverseString(String str) {
		char[] arr = str.toCharArray();
		String result = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			result = result + arr[i];
		}
		System.out.println(result);
		return result;
	}

}
