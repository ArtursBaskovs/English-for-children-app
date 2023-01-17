package com.example.myenglish;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //public static final String TAG = "DatabaseHelper";

    public static final String TABLE_NAME = "tasks_table";
    public static final String COL1 = "ID";
    public static final String QST = "question";
    public static final String ANSWR = "answer";
    public static final String SENT = "sentence";
    public static final String TASK_ATTR = "tast_atribute";

    static final String dbName = "TASKSdb.DB";
    static final int DB_VERSION = 1;

    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + COL1
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ QST +" TEXT NOT NULL," + ANSWR + " TEXT NOT NULL, "+ TASK_ATTR+" TEXT NOT NULL, "+ SENT +" TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, dbName, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //onCreate(db);
    }
}
