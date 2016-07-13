package com.chris.database.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by chris on 7/11/16.
 * Email: soymantag@163.coom
 */
public class WordDao {
    private WordDbOpenHelper mWordDbOpenHelper;

    public WordDao(Context context,String name,int version) {
        mWordDbOpenHelper = new WordDbOpenHelper(context,name,version);
    }
    public void add(){
        SQLiteDatabase db = mWordDbOpenHelper.getWritableDatabase();
        db.close();
    }
    public void exeCommand(String command){
        SQLiteDatabase db = mWordDbOpenHelper.getWritableDatabase();
        db.execSQL(command);
        db.close();
    }
}
