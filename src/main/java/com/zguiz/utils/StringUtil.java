package com.zguiz.utils;

public class StringUtil {

	/**
	 * 把字符串转换数字
	 * 
	 * @param s
	 * @return 失败返回 0,成功返回对应的数字
	 */
	public static int parseInt(String s) {
		int i = 0;
		if (s != null && s.trim().length() > 0) {
			try {
				i = Integer.parseInt(s);
			} catch (RuntimeException e) {
			}
		}
		return i;
	}

	/**
	 * 字符串截取方法
	 * 
	 * @param data
	 * @param len
	 * @return
	 */
	public static String subString(String data, int len) {

		if (data == null) {
			return null;
		}

		if (data.length() >= len) {
			return data.substring(0, len - 1) + "...";
		}
		return data;

	}
}
