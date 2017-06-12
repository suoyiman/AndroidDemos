package com.chris.app6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * Email: suoyiman@163.coom
 */

public class AActivity extends AppCompatActivity{
    //添加@Inject注解，表示这个mPoetry是需要注入的
    @Inject
    Person mPerson;
    @Inject
    Gson mGson;
    private TextView mTextView;
    private Button mBt_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainApplication.getInstance().getAComponent().inject(this);

        mTextView = (TextView) findViewById(R.id.text_view);
        String json = mGson.toJson(mPerson);
        String text = json + ",mPerson:"+mPerson;
        mTextView.setText(text);

        mBt_open = (Button) findViewById(R.id.open);
        mBt_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AActivity.this,OtherActivity.class));
            }
        });
    }
}
