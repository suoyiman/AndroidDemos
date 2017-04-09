package com.example.chris.qcstest.http;

import com.example.chris.qcstest.Constant;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by chris on 17-4-10.
 */

public class HttpUtil {
    private static HttpApi instance;
    public static HttpApi getInstant(){
        if(instance==null){
            instance = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
                    .create(HttpApi.class);
        }
        return instance;
    }
}
