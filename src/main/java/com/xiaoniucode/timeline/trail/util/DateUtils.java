package com.xiaoniucode.timeline.trail.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期格式化工具类
 * 仅支持将 LocalDateTime 和 LocalDate 格式化为字符串
 */
public class DateUtils {

    /** 默认日期时间格式 */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** 默认日期格式 */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 将 LocalDateTime 格式化为字符串
     *
     * @param localDateTime 日期时间对象
     * @param pattern       格式化模式，默认为 "yyyy-MM-dd HH:mm:ss"
     * @return 格式化后的字符串，空对象返回 null
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        if (localDateTime == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                pattern != null ? pattern : DEFAULT_DATE_TIME_FORMAT);
        return localDateTime.format(formatter);
    }

    /**
     * 将 LocalDateTime 格式化为默认格式 "yyyy-MM-dd HH:mm:ss"
     *
     * @param localDateTime 日期时间对象
     * @return 格式化后的字符串，空对象返回 null
     */
    public static String format(LocalDateTime localDateTime) {
        return format(localDateTime, DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * 将 LocalDate 格式化为字符串
     *
     * @param localDate 日期对象
     * @param pattern   格式化模式，默认为 "yyyy-MM-dd"
     * @return 格式化后的字符串，空对象返回 null
     */
    public static String format(LocalDate localDate, String pattern) {
        if (localDate == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                pattern != null ? pattern : DEFAULT_DATE_FORMAT);
        return localDate.format(formatter);
    }

    /**
     * 将 LocalDate 格式化为默认格式 "yyyy-MM-dd"
     *
     * @param localDate 日期对象
     * @return 格式化后的字符串，空对象返回 null
     */
    public static String format(LocalDate localDate) {
        return format(localDate, DEFAULT_DATE_FORMAT);
    }
}
