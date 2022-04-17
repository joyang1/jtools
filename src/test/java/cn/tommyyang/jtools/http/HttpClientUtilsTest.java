package cn.tommyyang.jtools.http;

import cn.tommyyang.jtools.http.HttpClientUtils;
import okhttp3.ResponseBody;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author : TommyYang
 * @Time : 4/13/22 10:34 PM
 * @Software: IntelliJ IDEA
 * @File : HttpClientUtilsTest.java
 */
public class HttpClientUtilsTest {

    /**
     * 测试get请求使用Retrofit
     *
     * @throws IOException
     */
    @Test
    public void testGetUseRetrofit() throws IOException {
        ResponseBody rsp = HttpClientUtils.getUseRetrofit("https://www.baidu.com");
        System.out.println(rsp.string());
    }

}
