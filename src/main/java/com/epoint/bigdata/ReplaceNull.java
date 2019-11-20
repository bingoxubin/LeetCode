package com.epoint.bigdata;

/**
 * 实现字符串的替换功能，代替replaceAll方法。
 *
 * @author xumaosheng
 * @date 2019/8/8 12:38
 */
public class ReplaceNull {

	/**
	 * 测试方法
	 *
	 * @return void
	 * @author xumaosheng
	 * @date 2019/8/8 14:06
	 * @params [args]
	 */
	public static void main(String[] args) {
		String ss = "i love me";
		System.out.println(ss.replaceAll(" ", "%20"));
		StringBuffer sb = new StringBuffer();
		StringBuffer ss1 = sb.append("i love me");
		System.out.println(replace(ss1));
	}

	/**
	 * 用char[]数据实现replaceAll功能
	 *
	 * @return java.lang.String
	 * @author xumaosheng
	 * @date 2019/8/8 14:07
	 * @params [ss]
	 */
	public static String replace(StringBuffer ss) {
		char[] arr = ss.toString().toCharArray();
		String result = "";
		for (int i = 0; i < ss.length(); i++) {
			String temp = String.valueOf(arr[i]);
			if (temp.equals(" ")) {
				result = result + "%20";
			} else {
				result = result + temp;
			}
		}
		return result;
	}
}
