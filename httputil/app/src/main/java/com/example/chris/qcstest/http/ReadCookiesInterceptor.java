package com.example.chris.qcstest.http;

import android.content.Context;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.chris.qcstest.MyApp.mApplication;

/**
 * Created by drore on 17/3/16.
 */

public class ReadCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet<String>) mApplication.getSharedPreferences("cookie", Context.MODE_PRIVATE).getStringSet("cookie", new HashSet<String>());

        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
        }

        return chain.proceed(builder.build());
    }
}
