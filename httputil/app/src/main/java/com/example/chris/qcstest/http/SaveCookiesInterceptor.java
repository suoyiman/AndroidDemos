package com.example.chris.qcstest.http;

import android.content.Context;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

import static com.example.chris.qcstest.MyApp.mApplication;

/**
 * Created by drore on 17/3/16.
 */

public class SaveCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {

            HashSet<String> cookies = new HashSet<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            mApplication.getSharedPreferences("cookie", Context.MODE_PRIVATE).edit().putStringSet("cookie", cookies).apply();
        }

        return originalResponse;
    }
}
