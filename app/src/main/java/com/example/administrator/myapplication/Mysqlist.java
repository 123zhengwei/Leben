package com.example.administrator.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mysqlist extends SQLiteOpenHelper {


    private String sql="create table if not exists users(useId Integer primary key autoincrement,userNickname char(255) not null,userPass char(255) not null," +
            "userAge int not null,userTel char(11) not null UNIQUE,userHeight DECIMAL(5,2),userWeight DECIMAL(5,2))";

    public Mysqlist(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
}