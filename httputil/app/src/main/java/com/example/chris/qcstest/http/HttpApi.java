package com.example.chris.qcstest.http;

import com.example.chris.qcstest.http.response.Response;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by chris on 17-4-10.
 */

public interface HttpApi {
    @FormUrlEncoded
    @POST("macro/user/login.htm")
    Observable<Response<Object>> login(@Field("tel") String tel, @Field("password") String password);
}
