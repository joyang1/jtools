package cn.tommyyang.jtools.time;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author : TommyYang
 * @Time : 4/10/22 7:21 PM
 * @Software: IntelliJ IDEA
 * @File : TimeTools.java
 */
public class TimeTools {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeTools.class);

    /**
     * 格式化时间：精确到天
     */
    public static final String DATE_PATTERN = "yyyyMMdd";

    /**
     * 格式化时间：精确到天
     */
    public static final String DATE_PATTERN_DAY = "yyyy-MM-dd";

    /**
     * 格式化时间：精确到小时
     */
    public static final String DATE_PATTERN_HH = "yyyyMMdd HH";

    /**
     * 格式化时间：精确到分钟
     */
    public static final String DATE_PATTERN_MM = "yyyyMMdd HH:mm";

    /**
     * 格式化时间：精确到秒钟
     */
    public static final String DATE_PATTERN_SS = "yyyyMMdd HH:mm:ss";

    /**
     * 格式化时间：精确到毫秒
     */
    public static final String DATE_PATTERN_SS_SSS = "yyyyMMdd HH:mm:ss SSS";

    /**
     * 格式化时间：精确到秒钟
     */
    public static final String DATE_PATTERN_SESSION = "yyyyMMddHHmmss";

    /**
     * 格式化时间，默认格式化格式为：yyyyMMdd hh:mm:ss
     *
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        if (null == date) {
            return null;
        }

        return dateFormat(date, DATE_PATTERN_SS);
    }

    /**
     * 按指定格式格式化时间
     *
     * @param date
     * @param datePattern
     * @return
     */
    public static String dateFormat(Date date, String datePattern) {
        if (null == date || StringUtils.isBlank(datePattern)) {
            return null;
        }

        SimpleDateFormat formatter = (SimpleDateFormat) DateFormat.getDateInstance();
        formatter.applyPattern(datePattern);

        return formatter.format(date);
    }

    /**
     * 日期字符串转换成日期
     *
     * @param strDate
     * @param datePattern
     * @return
     */
    public static Date toDate(String strDate, String datePattern) {
        if (StringUtils.isBlank(strDate) || StringUtils.isBlank(datePattern)) {
            return null;
        }

        SimpleDateFormat formatter = null;
        Date date = null;

        try {
            formatter = new SimpleDateFormat(datePattern);
            date = formatter.parse(strDate);
        } catch (Exception e) {
            LOGGER.error("转化日期，格式化错误",e);
        }

        return date;
    }

    /**
     * 指定时间在当前时间之前
     *
     * @param date
     * @return
     */
    public static boolean timeBeforeNow(Date date) {
        if (null == date) {
            return Boolean.FALSE;
        }

        return date.compareTo(new Date()) < 0;
    }

    /**
     * 指定时间在当前时间之后
     *
     * @param date
     * @return
     */
    public static boolean timeAfterNow(Date date) {
        if (null == date) {
            return Boolean.FALSE;
        }

        return date.compareTo(new Date()) > 0;
    }

    /**
     * 为传入日期添加年份
     *
     * @param date
     * @param year
     * @return
     */
    public static Date addYear(Date date, int year) {
        if (null == date) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);

        return calendar.getTime();
    }

    /**
     * 为传入日期添加月份
     *
     * @param date
     * @param month
     * @return
     */
    public static Date addMonth(Date date, int month) {
        if (null == date) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);

        return calendar.getTime();
    }

    /**
     * 为传入日期添加天数
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date, int day) {
        if (null == date) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // DAY_OF_MONTH、DAY_OF_YEAR、DAY_OF_WEEK、DAY_OF_WEEK_IN_MONTH的区别，可以参考：
        calendar.add(Calendar.DAY_OF_MONTH, day);

        return calendar.getTime();
    }

    /**
     * 为传入日期添加小时
     *
     * @param date
     * @param hour
     * @return
     */
    public static Date addHour(Date date, int hour) {
        if (null == date) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // HOUR、HOUR_OF_DAY的区别，可以参考：
        calendar.add(Calendar.HOUR_OF_DAY, hour);

        return calendar.getTime();
    }

    /**
     * 为传入日期添加分钟
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date addMinute(Date date, int minute) {
        if (null == date) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);

        return calendar.getTime();
    }

    /**
     * 为传入日期添加秒数
     *
     * @param date
     * @param second
     * @return
     */
    public static Date addSecond(Date date, int second) {
        if (null == date) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);

        return calendar.getTime();
    }

    /**
     * 为传入日期添加毫秒数
     *
     * @param date
     * @param milliSecond
     * @return
     */
    public static Date addMilliSecond(Date date, int milliSecond) {
        if (null == date) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, milliSecond);

        return calendar.getTime();
    }

    /**
     * 获取接下来N天后的00:00:00 000
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextNDayHeadTime(Date date, int n) {
        if (null == date) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, n);

        return calendar.getTime();
    }

    /**
     * 获取接下来N天后的23:59:59 999
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextNDayEndTime(Date date, int n) {
        if (null == date) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DAY_OF_MONTH, n);

        return calendar.getTime();
    }
}
