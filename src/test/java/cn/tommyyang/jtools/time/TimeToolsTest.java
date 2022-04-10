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

    /**
     * 测试日期字符串转换成日期
     */
    @Test
    public void testToDate() {
        String strDate = "20220410";
        Date date = TimeTools.toDate(strDate, TimeTools.DATE_PATTERN);
        Assert.assertEquals(strDate, TimeTools.dateFormat(date, TimeTools.DATE_PATTERN));
    }

    @Test
    public void testDateFormat() {
        String strDate = "20220410";
        Date date = TimeTools.toDate(strDate, TimeTools.DATE_PATTERN);

        String dateDay = "2022-04-10";
        String dateHH = "20220410 00";
        String dateMM = "20220410 00:00";
        String dateSS = "20220410 00:00:00";
        String dateSession = "20220410000000";

        Assert.assertEquals(TimeTools.dateFormat(date), dateSS);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN_DAY), dateDay);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN), strDate);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN_HH), dateHH);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN_MM), dateMM);
        Assert.assertEquals(TimeTools.dateFormat(date, TimeTools.DATE_PATTERN_SESSION), dateSession);
    }

}
