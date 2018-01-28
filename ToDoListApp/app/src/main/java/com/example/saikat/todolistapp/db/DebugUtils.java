package com.example.saikat.todolistapp.db;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.saikat.todolistapp.MainActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

/**
 * Created by SAIKAT on 1/16/2018.
 */

public final class DebugUtils {

    private DebugUtils() throws Exception {
        throw new Exception();
    }

    public static void backupDatabase(Context context, String databaseName) {
        try {
            File backupDB = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "toDatabaseName.db"); // for example "my_data_backup.db"
            File currentDB = context.getDatabasePath(databaseName); //databaseName=your current application database name, for example "my_data.db"
            if (currentDB.exists()) {
                FileInputStream fis = new FileInputStream(currentDB);
                FileOutputStream fos = new FileOutputStream(backupDB);
                fos.getChannel().transferFrom(fis.getChannel(), 0, fis.getChannel().size());
                // or fis.getChannel().transferTo(0, fis.getChannel().size(), fos.getChannel());
                fis.close();
                fos.close();
                Log.i("Database successfully", " copied to download folder");
            } else Log.i("Copying Database", " fail, database not found");
        } catch (IOException e) {
            Log.d("Copying Database", "fail, reason:", e);
        }
    }
}