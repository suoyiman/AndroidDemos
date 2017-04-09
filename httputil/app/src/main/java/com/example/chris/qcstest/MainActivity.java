package com.example.chris.qcstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.chris.qcstest.http.HttpUtil;
import com.example.chris.qcstest.http.MySubscriber;
import com.example.chris.qcstest.http.response.Response;

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
//                        .subscribe(new Subscriber<Response<Object>>() {
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
//                            public void onNext(Response<Object> objectResponse) {
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
                            public void onSuccess(Response<Object> objectResponse) {
                                Toast.makeText(MainActivity.this,objectResponse.getMessage(),Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailed(Response<Object> objectResponse) {
                                Toast.makeText(MainActivity.this,"on failed",Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });

    }

}
