package com.chris.app7;

import android.app.Application;

import com.chris.app7.component.AComponent;
import com.chris.app7.component.ApplicationComponent;
import com.chris.app7.component.DaggerApplicationComponent;

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
            mAComponent = mApplicationComponent.plus();
        }
        return mAComponent;
    }
}
