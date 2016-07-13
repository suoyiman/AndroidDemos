package com.chris.database.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by chris on 7/11/16.
 * Email: soymantag@163.coom
 */
public class WordDbOpenHelper extends SQLiteOpenHelper {
    public WordDbOpenHelper(Context context, String name,int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table wordtb (word text primary key,word_bean blob,word_notes text)");
        Log.e("chris","WordDbOpenHelper oncreat");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table wordtb");
        onCreate(db);
    }
}
