package com.example.chris.rxjava1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


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
    public void click(View v){
        rx_4();
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
                        System.out.println("#################\n############\n");
                        System.out.println("Hello, RxAndroid!");
                        subscriber.onCompleted();
                        long id = Thread.currentThread().getId();
                        String name = Thread.currentThread().getName();
                        System.out.println("#################\n############\n");
                        System.out.println(id + ":" + name);
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
                long id = Thread.currentThread().getId();
                String name = Thread.currentThread().getName();
                System.out.println("#################\n############\n");
                System.out.println(id + ":" + name);
            }
        };
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        //调用observable.subscribe后会回调observable中重写的call
    }

    private void rx_2() {
        Observable<String> observable = Observable.just("hello");
        Action1<String> action1 = new Action1<String>() {
            @Override
            public void call(String s) {
                showToast(s);
            }
        };
        observable.subscribe(action1);
    }
    private void rx_2_2() {
        Observable.just("hello word")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        showToast(s);
                    }
                });
    }
    private void rx_3(){
        /*
     * ①.我想在Hello, RxAndroid!后面加上一段签名，你可能会想到去修改Observable对象：
     */
        Observable.just("Hello, RxAndroid! -openXu")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        showToast(s);
                    }
                });
    /*
     * 如果我的Observable对象被多个Subscriber订阅，但是我只想在对某个订阅者做修改呢？
     */
        Observable.just("Hello, RxAndroid!")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        showToast(s + " -openXu");
                    }
                });
    }

    private void rx_3_3(){
        Observable.just("Hello, RxAndroid!")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " -openXu";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        showToast(s);
                    }
                });
    }

    private void rx_4(){
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .buffer(3)
                .subscribe(new Action1<List<Integer>>() {
                    @Override
                    public void call(List<Integer> integers) {
                        Log.d("cjros", "1buffer-count:" + integers);
                    }
                });
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .buffer(3)
                .subscribe(i -> Log.d("cjros", "1buffer-count:" + i));
    }

    private void rx_5(){
        Observable.just(1,2,3,4,5)
                .flatMap(new Func1<Integer, Observable<String>>() {
                    @Override
                    public Observable<String> call(Integer integer) {
                        return Observable.just("flat map:"+integer);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.d("chris", s);
                    }
                });

        Observable.just(1, 2, 3, 4, 5)
                .flatMap(integer -> Observable.just("flat map:" + integer))
                .subscribe(i -> Log.d("chris", i));
    }
}
