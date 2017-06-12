package com.chris.app2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
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

        DaggerMainComponent.builder()
                .build()
                .inject(this);

        mTextView = (TextView) findViewById(R.id.text_view);
        String json = mGson.toJson(mPerson);
        mTextView.setText(json);
    }
}
