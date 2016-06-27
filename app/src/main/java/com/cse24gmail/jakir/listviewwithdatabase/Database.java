package com.cse24gmail.jakir.listviewwithdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 6/16/2016.
 */
public class Database extends SQLiteOpenHelper {

    private static String DB_NAME = "mars.db";
    private static int DB_VERSION = 1;

    private SQLiteDatabase database = getWritableDatabase();
    public static final String TABLE_NAME = "ABC";
    public static final String NAME_FIELD = "name";
    public static final String DEPT_FIELD = "dept";

    public static String Create_table = "Create table "+TABLE_NAME+" (id INTEGER primary key, "+NAME_FIELD+" text, "+DEPT_FIELD+" text);";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addStudent() {
        ContentValues values=new ContentValues();

        values.put(NAME_FIELD,"Jakir");
        values.put(DEPT_FIELD,"CSE");
        database.insert(TABLE_NAME,null,values);
    }

    public void getStudent() {

        Cursor cursor=database.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor!=null){

            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String name=cursor.getString(cursor.getColumnIndex(NAME_FIELD));
            String dpt=cursor.getString(cursor.getColumnIndex(DEPT_FIELD));
        }
    }
}
