package com.dicoding.jmp.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "assessment.db";
    public static final String TABLE_SQLITE = "sqlite";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_HP = "hp";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_TANGGAL = "tanggal";
    public static final String COLUMN_ADDRESS = "address";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists " + TABLE_SQLITE + "(" +
                COLUMN_ID + " integer primary key autoincrement," +
                COLUMN_NAME + " text not null, " +
                COLUMN_HP + " text not null, " +
                COLUMN_GENDER + " text not null, " +
                COLUMN_TANGGAL + " text not null, " +
                COLUMN_ADDRESS + " text not null" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("drop table if exists " + TABLE_SQLITE);
            onCreate(db);
        }
    }

    public ArrayList<HashMap<String, String>> getAllData(){
        ArrayList<HashMap<String, String>> wordlist;
        wordlist = new ArrayList<HashMap<String, String>>();
        String sql = "select * from " + TABLE_SQLITE;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        if(cursor.moveToFirst())
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put(COLUMN_ID, cursor.getString(0));
                map.put(COLUMN_NAME, cursor.getString(1));
                map.put(COLUMN_HP, cursor.getString(2));
                map.put(COLUMN_GENDER, cursor.getString(3));
                map.put(COLUMN_TANGGAL, cursor.getString(4));
                map.put(COLUMN_ADDRESS, cursor.getString(5));
                wordlist.add(map);
            } while (cursor.moveToNext());

        Log.e("select sqlite", "" + wordlist);
        cursor.close();
        return wordlist;
    }

    public void insert(String name, String hp, String gender, String tanggal, String address) {
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "insert into " + TABLE_SQLITE + " (name, hp, gender, tanggal, address)" +
                " values('" + name + "', '" + hp + "', '" + gender + "', '" + tanggal + "', '" + address + "')";

        Log.e("insert sqlite ", "" + queryValues);
        database.execSQL(queryValues);
        database.close();
    }

}
