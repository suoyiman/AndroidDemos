package com.example.chris.qcstest.http;


import android.content.Context;
import android.widget.Toast;

import com.example.chris.qcstest.http.response.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by drore on 17/4/10.
 */

public abstract class MyCallback<T> implements Callback<BaseResponse<T>> {
    Context mContext;

    public MyCallback(Context context) {
        mContext = context;
    }

    abstract public void onSuccess(BaseResponse<T> tResponse);

    public void onFailed(BaseResponse<T> tResponse){}

    @Override
    public void onResponse(Call<BaseResponse<T>> call, retrofit2.Response<BaseResponse<T>> response) {
        BaseResponse<T> res = response.body();
        if(res!=null){
            if (res.isSuccess()) {
                onSuccess(res);
            } else {
                onFailed(res);
                Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(mContext, "数据获取失败！", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailure(Call<BaseResponse<T>> call, Throwable t) {
        Toast.makeText(mContext, "网络错误，请检查网络连接", Toast.LENGTH_SHORT).show();
    }
}
