package com.news.droiddebo.mytimes.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;
    private static final String TAG = DbHelper.class.getSimpleName() ;

    public DbHelper(@Nullable Context context) {

        super(context, "notesdb", null, 1);
        Log.i(TAG,"db created");


    }



    /**
     * this method will be called for the first time when the db is created
     * @param db
     */


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG,"onCreate table");
        //create table tablename(id integer primary key not null, title VARCHAR notnull, subtitle varchar notnull);
        db.execSQL(SQL_CREATE_ENTRIES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i(TAG,"onUpgrade");
    }
}
