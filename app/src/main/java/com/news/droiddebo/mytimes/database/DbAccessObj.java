package com.news.droiddebo.mytimes.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbAccessObj {
    SQLiteDatabase database;
    DbHelper dbHelper;

    public DbAccessObj(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void openDb(){
        database = dbHelper.getWritableDatabase();
    }
    private void closeDb(){}

    public void createRow(String title, String subtitle){
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE,subtitle);
        database.insert(FeedReaderContract.FeedEntry.TABLE_NAME,null,values);
    }
    public String readRow(){
        //query my db/table
        //database.rawQuery("select * from notes_table",null);
        Cursor cursor = database.query(FeedReaderContract.FeedEntry.TABLE_NAME,null,null,null,null,null,null);
        //return the result as a string
        int a = 1;
        cursor.moveToPosition(a);
        int titleIndex = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE);
        int subtitleIndex = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE);

        String title = cursor.getString(titleIndex);
        String subtitle = cursor.getString(subtitleIndex);
        return title +"\n" +subtitle;
    }
    private void updateRow(){}
    private void deleteRow(){}

    public Cursor getRows() {
        Cursor cursor = database.query(FeedReaderContract.FeedEntry.TABLE_NAME,null,null,null,null,null,null);
        return cursor;
    }


    public String  query(String queryParam) {
        String table = FeedReaderContract.FeedEntry.TABLE_NAME;
        String[] columns = {FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE}; //projection = columns
        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE +" =?"; //selection = rows
        String[] selectionArgs = {queryParam};
        String groupBy = null;
        String having = null;
        String orderBy = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE+" DESC";
        String limit = "10";

        Cursor cursor = database.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        int subtitleIndex = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE);
        cursor.moveToLast();
        String subtitle = cursor.getString(subtitleIndex);
        return subtitle;

    }


    public String uservalid(String queryParam) {
        String table = FeedReaderContract.FeedEntry.TABLE_NAME;
        String[] columns = {FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE}; //projection = columns
        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " =?"; //selection = rows
        String[] selectionArgs = {queryParam};
        String groupBy = null;
        String having = null;
        String orderBy = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " DESC";
        String limit = "10";
        String register = "Please Register";
        Cursor cursor = database.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        if (cursor.getCount() >0) {
            int titleIndex = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE);
            cursor.moveToLast();
            String title = cursor.getString(titleIndex);
            return title;
        }
        return register;

    }

}
