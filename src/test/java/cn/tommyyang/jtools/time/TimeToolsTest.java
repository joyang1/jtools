package cn.tommyyang.jtools.time;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @Author : TommyYang
 * @Time : 4/10/22 8:52 PM
 * @Software: IntelliJ IDEA
 * @File : TimeToolsTest.java
 */
public class TimeToolsTest {

    private final static String STR_DATE_20220410 = "20220410";

    private final static String STR_DATE_2022041001 = "20220410 01";

    private final static String STR_DATE_202204100001 = "20220410 00:01";

    private final static String STR_DATE_20220410000001 = "20220410 00:00:01";

    private final static String STR_DATE_20220410000000001 = "20220410 00:00:00 001";

    private final static String STR_DATE_20220411 = "20220411";

    private final static String STR_DATE_20220510 = "20220510";

    private final static String STR_DATE_20230410 = "20230410";


    /**
     * 测试日期字符串转换成日期
     */
    @Test
    public void testToDate() {
        Date date = TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN);
        Assert.assertEquals(STR_DATE_20220410, TimeTools.dateFormat(date, TimeTools.DATE_PATTERN));
    }

    /**
     * 测试格式转换
     */
    @Test
    public void testDateFormat() {
        Date date = TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN);

        String dateDay = "2022-04-10";
        String dateHH = "20220410 00";
        String dateMM = "20220410 00:00";
        String dateSS = "20220410 00:00:00";
        String dateSession = "20220410000000";

        Assert.assertEquals(TimeTools.dateFormat(date), dateSS);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN_DAY), dateDay);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN), STR_DATE_20220410);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN_HH), dateHH);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN_MM), dateMM);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN_SESSION), dateSession);
    }

    /**
     * 测试指定时间在当前时间之前
     */
    @Test
    public void testTimeBeforeNow() {
        Assert.assertTrue(TimeTools.timeBeforeNow(TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN)));
    }

    /**
     * 测试指定时间在当前时间之后
     */
    @Test
    public void testTimeAfterNow() {
        Assert.assertTrue(TimeTools.timeAfterNow(TimeTools.addDay(new Date(), 1)));
    }

    /**
     * 测试添加指定年份
     */
    @Test
    public void testAddYear() {
        Date date20220410 = TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN);
        Date date20230410 = TimeTools.toDate(STR_DATE_20230410, TimeTools.DATE_PATTERN);

        Assert.assertTrue(TimeTools.addYear(date20220410, 1)
                .compareTo(date20230410) == 0);
    }

    /**
     * 测试添加指定月份
     */
    @Test
    public void testAddMonth() {
        Date date20220410 = TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN);
        Date date20220510 = TimeTools.toDate(STR_DATE_20220510, TimeTools.DATE_PATTERN);

        Assert.assertTrue(TimeTools.addMonth(date20220410, 1)
                .compareTo(date20220510) == 0);
    }

    /**
     * 测试添加指定天数
     */
    @Test
    public void testAddDay() {
        Date date20220410 = TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN);
        Date date20220411 = TimeTools.toDate(STR_DATE_20220411, TimeTools.DATE_PATTERN);

        Assert.assertTrue(TimeTools.addDay(date20220410, 1)
                .compareTo(date20220411) == 0);
    }

    /**
     * 测试添加指定小时
     */
    @Test
    public void testAddHour() {
        Date date20220410 = TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN);
        Date date2022041001 = TimeTools.toDate(STR_DATE_2022041001, TimeTools.DATE_PATTERN_HH);

        Assert.assertTrue(TimeTools.addHour(date20220410, 1)
                .compareTo(date2022041001) == 0);
    }


    /**
     * 测试添加指定分钟
     */
    @Test
    public void testAddMinute() {
        Date date20220410 = TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN);
        Date date202204100001 = TimeTools.toDate(STR_DATE_202204100001, TimeTools.DATE_PATTERN_MM);

        Assert.assertTrue(TimeTools.addMinute(date20220410, 1)
                .compareTo(date202204100001) == 0);
    }

    /**
     * 测试添加指定秒钟
     */
    @Test
    public void testAddSecond() {
        Date date20220410 = TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN);
        Date date20220410000001 = TimeTools.toDate(STR_DATE_20220410000001, TimeTools.DATE_PATTERN_SS);

        Assert.assertTrue(TimeTools.addSecond(date20220410, 1)
                .compareTo(date20220410000001) == 0);
    }

    /**
     * 测试添加指定毫秒
     */
    @Test
    public void testAddMilliSecond() {
        Date date20220410 = TimeTools.toDate(STR_DATE_20220410, TimeTools.DATE_PATTERN);
        Date date20220410000001 = TimeTools.toDate(STR_DATE_20220410000000001, TimeTools.DATE_PATTERN_SS_SSS);

        Assert.assertTrue(TimeTools.addMilliSecond(date20220410, 1)
                .compareTo(date20220410000001) == 0);
    }
}
