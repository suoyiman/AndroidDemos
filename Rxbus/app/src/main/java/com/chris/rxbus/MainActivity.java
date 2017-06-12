package com.chris.rxbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    private Subscription mRxSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.text_view);
        Button button = (Button) findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.edit_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                RxBus.getInstance().post(new StudentEvent("007",name));
            }
        });

        mRxSubscription = RxBus.getInstance().toObserverable(StudentEvent.class)
                .subscribe(new Action1<StudentEvent>() {
                    @Override
                    public void call(StudentEvent studentEvent) {
                        textView.setText("id:"+ studentEvent.getId()+"  name:"+ studentEvent.getName());
                    }
                });
    }

    @Override
    protected void onDestroy() {
        if (!mRxSubscription.isUnsubscribed()){
            mRxSubscription.unsubscribe();
        }
        super.onDestroy();
    }
}
