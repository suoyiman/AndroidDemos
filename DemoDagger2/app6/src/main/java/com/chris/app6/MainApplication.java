package com.chris.app6;

import android.app.Application;

/**
 * Email: suoyiman@163.coom
 */

public class MainApplication extends Application{
    private ApplicationComponent mApplicationComponent;
    private static MainApplication mainApplication;
    private AComponent mAComponent;
    public static MainApplication getInstance(){
        return mainApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mainApplication = this;
        mApplicationComponent = DaggerApplicationComponent.builder().build();
    }
    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }
    public AComponent getAComponent() {
        if (mAComponent == null){
            mAComponent = mApplicationComponent.plus(new AModule());
        }
        return mAComponent;
    }
}
