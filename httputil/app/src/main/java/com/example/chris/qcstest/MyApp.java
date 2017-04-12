package com.example.chris.qcstest;

import android.app.Application;
import android.os.Handler;

/**
 * Created by drore on 17/3/16.
 */

public class MyApp extends Application{
    public static Application mApplication;
    public static String imei;
    private Handler handler;
    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        mApplication = this;
    }
}
