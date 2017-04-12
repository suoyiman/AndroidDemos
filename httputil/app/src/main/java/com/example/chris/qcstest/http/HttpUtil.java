package com.example.chris.qcstest.http;

import com.example.chris.qcstest.URLConstant;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by chris on 17-4-10.
 */

public class HttpUtil {
    private static HttpApi instance;
    public static synchronized HttpApi getInstant(){
        if(instance==null){
            instance = new Retrofit.Builder()
                    .baseUrl(URLConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
                    .create(HttpApi.class);
        }
        return instance;
    }
}
