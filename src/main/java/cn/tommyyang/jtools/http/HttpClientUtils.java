package cn.tommyyang.jtools.http;

import cn.tommyyang.jtools.http.retrofit.DataService;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * @Author : TommyYang
 * @Time : 4/13/22 10:25 PM
 * @Software: IntelliJ IDEA
 * @File : HttpClientUtils.java
 */
public class HttpClientUtils {

    /**
     * get请求，使用Retrofit
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static ResponseBody getUseRetrofit(String url) throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).build();

        DataService dataService = retrofit.create(DataService.class);
        return dataService.get().execute().body();
    }

}
