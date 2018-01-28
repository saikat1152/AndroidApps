package com.example.saikat.todolistapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SAIKAT on 1/15/2018.
 */

public class TaskDbHelper extends SQLiteOpenHelper {

    public TaskDbHelper(Context context) {
        super(context,TaskContract.DB_NAME,null,TaskContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String createTable = "CREATE TABLE " +TaskContract.TaskEntry.TABLE +" ( " + TaskContract.TaskEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";
       sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TaskContract.TaskEntry.TABLE);
        onCreate(sqLiteDatabase);

    }
}
