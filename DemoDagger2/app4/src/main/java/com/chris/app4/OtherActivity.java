package com.chris.app4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * Email: suoyiman@163.coom
 */

public class OtherActivity extends AppCompatActivity{
    //添加@Inject注解，表示这个mPoetry是需要注入的
    @Inject
    Person mPerson;
    @Inject
    Gson mGson;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainComponent.getInstance().inject(this);

        mTextView = (TextView) findViewById(R.id.text_view);
        String json = mGson.toJson(mPerson);
        String text = json + ",mPerson:"+mPerson;
        mTextView.setText(text);
    }
}
