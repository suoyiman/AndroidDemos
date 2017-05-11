package com.chris.demodagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    //添加@Inject注解，表示这个mPoetry是需要注入的
    @Inject
    Person mPerson;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder()
                .build()
                .inject(this);

        mTextView = (TextView) findViewById(R.id.text_view);
        mTextView.setText(mPerson.getName());
    }
}
