package com.example.chris.qcstest.http;


import android.content.Context;
import android.widget.Toast;

import com.example.chris.qcstest.http.response.Response;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by drore on 17/4/10.
 */

public abstract class MyCallback<T> implements Callback<Response<T>> {
    Context mContext;
    public MyCallback(Context context) {
        mContext = context;
    }

    abstract public void onSuccess(Response<T> tResponse);
    abstract public void onFailed(Response<T> tResponse);
    @Override
    public void onResponse(Call<Response<T>> call, retrofit2.Response<Response<T>> response) {
        if(response.isSuccess()){
            onSuccess(response.body());
        }else {
            onFailed(response.body());
            Toast.makeText(mContext,response.body().getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Response<T>> call, Throwable t) {
        Toast.makeText(mContext,"check network",Toast.LENGTH_SHORT).show();
    }
}
