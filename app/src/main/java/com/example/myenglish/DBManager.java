package com.example.myenglish;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }


    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getReadableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(int id, String question, String task, String task_atribute, String sentence) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.COL1, id);
        contentValue.put(DatabaseHelper.QST, question);
        contentValue.put(DatabaseHelper.ANSWR, task);
        contentValue.put(DatabaseHelper.TASK_ATTR, task_atribute);
        contentValue.put(DatabaseHelper.SENT, sentence);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    @SuppressLint("Range")
    public String fetchQuestions(int whereID) {
        //String[] columns = new String[] {
                //DatabaseHelper.COL1, DatabaseHelper.QST, DatabaseHelper.ANSWR, DatabaseHelper.TASK_ATTR, DatabaseHelper.SENT
        //};
        //Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        Cursor cursor = null;
        String text = "";
        try {
            cursor = database.rawQuery("SELECT question FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL1 + " = " + whereID, null);
            //if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                text = cursor.getString(cursor.getColumnIndex("question"));
            }
            return text;
        }finally {
            cursor.close();
        }
    }
    @SuppressLint("Range")
    public String fetchAnswers(int whereID) {
        //String[] columns = new String[] {
        //DatabaseHelper.COL1, DatabaseHelper.QST, DatabaseHelper.ANSWR, DatabaseHelper.TASK_ATTR, DatabaseHelper.SENT
        //};
        //Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        Cursor cursor = null;
        String text = "";
        try {
            cursor = database.rawQuery("SELECT answer FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL1 + " = " + whereID, null);
            //if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                text = cursor.getString(cursor.getColumnIndex("answer"));
            }
            return text;
        }finally {
            cursor.close();
        }
    }

    /*public int update(long id,String question, String task, String task_atribute, String sentence) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.QST, question);
        contentValues.put(DatabaseHelper.ANSWR, task);
        contentValues.put(DatabaseHelper.TASK_ATTR, task_atribute);
        contentValues.put(DatabaseHelper.SENT, sentence);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.COL1 + " = " + id, null);
        return i;
    }*/

    public void delete(long id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COL1 + "=" + id, null);

    }
}
