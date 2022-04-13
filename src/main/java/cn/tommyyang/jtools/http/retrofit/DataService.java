package cn.tommyyang.jtools.http.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @Author : TommyYang
 * @Time : 4/13/22 10:29 PM
 * @Software: IntelliJ IDEA
 * @File : DataService.java
 */
public interface DataService {

    @GET("/")
    Call<ResponseBody> get();

    @POST("/")
    Call<ResponseBody> post();

}
