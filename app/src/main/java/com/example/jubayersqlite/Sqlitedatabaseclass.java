package com.example.jubayersqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sqlitedatabaseclass extends SQLiteOpenHelper {


    public Sqlitedatabaseclass(@Nullable Context context) {
        super(context, "mynew_database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table expense_table(id integer primary key autoincrement,amount DOUBLE,reason TEXT,time DOUBLE)");
        db.execSQL("create table income_table(id integer primary key autoincrement,amount DOUBLE,reason TEXT,time DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists expense_table");
        db.execSQL("drop table if exists income_table");

    }

    public void getdata(String amount,String reason){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("amount",amount);
        contentValues.put("reason",reason);
        contentValues.put("time",System.currentTimeMillis());
        db.insert("expense_table",null,contentValues);

    }

    public void addincome(String amount, String reason){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("amount",amount);
        contentValues.put("reason",reason);
        db.insert("income_table",null,contentValues);

    }


    public double datasee(){

        double total=0;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery("select * from expense_table",null);

        if (cursor !=null && cursor.getCount()>0){

            while (cursor.moveToNext()){
                double amount=cursor.getDouble(1);
                total=amount+total;

            }

        }

        return total;
    }


    public double addmethod(){

        double total=0;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery("select * from income_table",null);

        if (cursor !=null && cursor.getCount()>0){

            while (cursor.moveToNext()){
                double amount=cursor.getDouble(1);
                total=amount+total;

            }

        }

        return total;
    }




    public Cursor getseedata(){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from expense_table",null);
        return cursor;

    }


    public Cursor insertseedata(){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from income_table",null);
        return cursor;

    }

    public Cursor searchUser(String reason) {
        SQLiteDatabase db = this.getReadableDatabase();

        // কুইরি যেখানে `name` ফিল্ডে সার্চ হবে
        return db.rawQuery("SELECT * FROM expense_table WHERE reason LIKE ?", new String[]{"%" + reason + "%"});
    }




}
