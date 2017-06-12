package com.chris.app7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.chris.app7.qualifier.PersonQualifier;
import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * Email: suoyiman@163.coom
 */

public class AActivity extends AppCompatActivity{
    //添加@Inject注解，表示这个mPoetry是需要注入的
    @PersonQualifier("a")
    @Inject
    Person mPerson;
    @PersonQualifier("b")
    @Inject
    Person mPersonB;
    @Inject
    Gson mGson;
    private TextView mTextView;
    private Button mBt_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        MainApplication.getInstance().getAComponent().inject(this);

        mTextView = (TextView) findViewById(R.id.text_view);
        String json = mGson.toJson(mPerson);
        String text = json + ",mPerson:"+mPerson+mPerson.getName()
                +",mPersonB:"+mPersonB+mPersonB.getName();
        mTextView.setText(text);
    }
}
