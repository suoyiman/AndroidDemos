package com.example.chris.qcstest.http;


import com.example.chris.qcstest.URLConstant;
import com.example.chris.qcstest.http.response.HttpApi1;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;


/**
 * Created by drore on 17/3/16.
 */

public class RetrofitUtil {
    private static HttpApi1 httpApi;
    public static synchronized HttpApi1 createHttpClient() {
        if (httpApi == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new ReadCookiesInterceptor())
                    .addInterceptor(new SaveCookiesInterceptor())
                    .build();
            httpApi = new Retrofit
                    .Builder()
                    .client(client)
                    .baseUrl(URLConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(HttpApi1.class);
        }
        return httpApi;
    }
}
