package com.example.chris.qcstest.http.response;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by chris on 17-4-10.
 */

public interface HttpApi1 {
    @FormUrlEncoded
    @POST("macro/user/login.htm")
    Call<BaseResponse<Object>> login(@Field("tel") String tel, @Field("password") String password);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("macro/user/login.htm")
    Call<BaseResponse<Object>> login2(@Body RequestBody params);
}
