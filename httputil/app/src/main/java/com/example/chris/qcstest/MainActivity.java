package com.example.chris.qcstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.chris.qcstest.http.HttpUtil;
import com.example.chris.qcstest.http.MyCallback;
import com.example.chris.qcstest.http.MySubscriber;
import com.example.chris.qcstest.http.RetrofitUtil;
import com.example.chris.qcstest.http.response.BaseResponse;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                HttpUtil.getInstant().login("15736759029","123456")
//                        .onBackpressureBuffer()
//                        .take(1)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Subscriber<BaseResponse<Object>>() {
//                            @Override
//                            public void onCompleted() {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
//                            }
//
//                            @Override
//                            public void onNext(BaseResponse<Object> objectResponse) {
//                                Toast.makeText(MainActivity.this,objectResponse.getMessage(),Toast.LENGTH_LONG).show();
//                            }
//                        });
                HttpUtil.getInstant().login("15736759029","1234567")
                        .onBackpressureBuffer()
                        .take(1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new MySubscriber<Object>(MainActivity.this) {
                            @Override
                            public void onSuccess(BaseResponse<Object> objectResponse) {
                                Toast.makeText(MainActivity.this,objectResponse.getMessage(),Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailed(BaseResponse<Object> objectResponse) {
                                Toast.makeText(MainActivity.this,"on failed",Toast.LENGTH_LONG).show();
                            }
                        });

                RetrofitUtil.createHttpClient().login("15736759029","123456").enqueue(new MyCallback<Object>(MainActivity.this) {
                    @Override
                    public void onSuccess(BaseResponse<Object> tResponse) {

                    }
                });


                Map<String, Object> params = new HashMap();
                params.put("userName", "xxx");
                params.put("password", "123456");
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(params));
                RetrofitUtil.createHttpClient().login2(requestBody).enqueue(new MyCallback<Object>(MainActivity.this) {
                    @Override
                    public void onSuccess(BaseResponse<Object> tResponse) {

                    }
                });

            }
        });

    }
}
