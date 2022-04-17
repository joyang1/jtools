package cn.tommyyang.jtools.http;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author : TommyYang
 * @Time : 4/17/22 12:25 PM
 * @Software: IntelliJ IDEA
 * @File : EncodeUtilsTest.java
 */
public class EncodeUtilsTest {

    private final static String BAIDU_URL = "https://www.baidu.com";

    private final static String ENCODE_BAIDU_URL = "https%3A%2F%2Fwww.baidu.com";

    /**
     * 测试编码url
     */
    @Test
    public void testEncodeUrl() {
        Assert.assertEquals(EncodeUtils.encodeUrl("https://www.baidu.com"), ENCODE_BAIDU_URL);
    }

    /**
     * 测试解码url
     */
    @Test
    public void testDecodeUrl() {
        Assert.assertEquals(EncodeUtils.decodeUrl("https%3A%2F%2Fwww.baidu.com"), BAIDU_URL);
    }

}
