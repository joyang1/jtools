package cn.tommyyang.jtools.time;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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


}
