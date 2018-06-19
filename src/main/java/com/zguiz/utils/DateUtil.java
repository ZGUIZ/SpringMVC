package com.zguiz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 时间工具类
 *
 * @author chensw
 *
 */
public final class DateUtil {
    /**
     * yyyy-MM-dd
     */
    public static final String SHORT = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String LONG = "yyyy-MM-dd HH:mm:ss";

    /**
     * 使用方法： String str = DateUtil.formatDate(date,DateUtil.LONG);
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null || !(date instanceof Date)) {
            return "";// 返回空字符串
        }
        SimpleDateFormat sFormat = new SimpleDateFormat(pattern);
        try {
            return sFormat.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 使用方法：Date date = DateUtil.parseDate("2017-02-10",DateUtil.SHORT);
     *
     * @param dateString
     * @param pattern
     * @return
     */
    public static Date parseDate(String dateString, String pattern) {
        if (dateString == null) {
            return new Date();// 返回当前时间
        }
        SimpleDateFormat sFormat = new SimpleDateFormat(pattern);
        try {
            return sFormat.parse(dateString);
        } catch (ParseException e) {
            return new Date();// 返回当前时间
        }
    }
}
