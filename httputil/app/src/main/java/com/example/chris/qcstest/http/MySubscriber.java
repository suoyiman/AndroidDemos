package com.example.chris.qcstest.http;

import android.content.Context;
import android.widget.Toast;

import com.example.chris.qcstest.http.response.BaseResponse;

import rx.Subscriber;

/**
 * Created by chris on 17-4-10.
 */

public  abstract class  MySubscriber<T> extends Subscriber<BaseResponse<T>> {
    private Context mContext;
    public MySubscriber(Context context) {
        mContext = context;
    }

    abstract public void onSuccess(BaseResponse<T> tResponse);
    abstract public void onFailed(BaseResponse<T> tResponse);
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(mContext,"check network",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(BaseResponse<T> tResponse) {
        if(tResponse.isSuccess()){
            onSuccess(tResponse);
        }else {
            onFailed(tResponse);
            Toast.makeText(mContext,tResponse.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    //    public abstract void onSuccess(T t);

}
