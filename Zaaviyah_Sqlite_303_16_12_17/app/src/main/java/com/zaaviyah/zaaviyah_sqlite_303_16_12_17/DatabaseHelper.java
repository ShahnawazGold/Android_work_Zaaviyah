package com.zaaviyah.zaaviyah_sqlite_303_16_12_17;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pakistan laptop on 12/17/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    ///
    private static final String DATABAS_NAME = "shah.db";
    private static final String TABLE_NAME= "shah";


    public DatabaseHelper(Context context) {
        super(context, DATABAS_NAME, null, 1);
        // after yeh likhty hain work me
        SQLiteDatabase  sqLiteDatabase = this.getWritableDatabase();
    }

    /// ONcrete method
    @Override
    public  void  onCreate (SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "NAME TEXT ," +
                " MOBILE_NUMBER INTEGER ," +
                "EMAIL TEXT)"  );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // jb create ho ga tw yeh kam kry gy
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean inserContact (String name, String email, int number){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();



        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", number);
        contentValues.put("EMAIL", email);

        long result =sqLiteDatabase.insert("shah", null, contentValues);

        if (result == -1)
            return false ;
        else
            return  true ;
    }



}
