package com.example.chris.rxjava1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;


public class MainActivity extends AppCompatActivity {
    Context mContext;

    private void showToast(String s) {
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main);

    }

    /**
     * 初步探索
     */
    private void rx_1() {
        //构造函数为protected类型，不能new
        Observable<String> observable = Observable.create(
                //Invoked when Observable.subscribe is called.
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Hello, RxAndroid!");
                        subscriber.onCompleted();
                    }
                });
        //Subscriber是抽象类
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                showToast(s);
            }
        };
        observable.subscribe(subscriber);
        //调用observable.subscribe后会回调observable中重写的call
    }

    private void rx_2(){
        Observable<String> observable = Observable.just("hello");
        Action1<String> action1 = new Action1<String>() {
            @Override
            public void call(String s) {
                showToast(s);
            }
        };
        observable.subscribe(action1);

    }
}
