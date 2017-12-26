package com.zaaviyah.class_sqllitedb_13_12_17;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pakistan laptop on 12/13/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static  final String DATABASE_NAME = "Shah.db";
    private static final  String TABLE_NAME = "Shah";

    public DatabaseHelper (Context context){
        super(context,DATABASE_NAME,null,1);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // here write query db here know

        sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_NAME +" (" +

                "ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " NAME TEXT , " +
                "MOBILE_NUMBER INTEGER ," +
                "EMAIL TEXT)"  );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // jb create ho ga tw yeh kam kry gy
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertContact(String name ,  int phone,String email) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", phone);
        contentValues.put("EMAIL", email);

        long result =sqLiteDatabase.insert("Shah", null, contentValues);

        if (result == -1)
            return false ;
        else
            return  true ;

    }

    /// get data here show inside database

   public Cursor  getData (String phone){

       SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
       String query ="SELECT * FROM Shah WHERE MOBILE_NUMBER ='" + phone +"' ";
       // Cursor res =  sqLiteDatabase.rawQuery( query, null );
       Cursor res =  sqLiteDatabase.rawQuery( query, null );
       return res;



   }

    public  void  updateData (String name , String email, String num){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME", name);
        contentValues.put("EMAIL", email);
        sqLiteDatabase.update(TABLE_NAME,contentValues,"MOBILE_NUMBER ='" + num +"'  ",null);
        sqLiteDatabase.close();

    }

    //know DELETE DATA BASE RECORD SHOIW AS THAT==================
    public void deleteData (String phone)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete(TABLE_NAME,"MOBILE_NUMBER ='" + phone +"'  ",null);
        sqLiteDatabase.close();
    }

}
