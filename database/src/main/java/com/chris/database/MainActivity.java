package com.chris.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chris.database.db.WordDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WordDao wordDao = new WordDao(MainActivity.this,"worddb1",1);
        //wordDao.add();
        wordDao.exeCommand("create table tb1(name text,age integer)");
    }

}
