package com.amoa.studentsdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InptDBHelper  extends SQLiteOpenHelper {
    public InptDBHelper(@Nullable Context context) {
        super(context, "amoa.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE etudiants" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nom TEXT,prenom TEXT,filiere TEXT,phone VARCHAR(20),email VARCHAR(30))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS etudiants");
        onCreate(sqLiteDatabase);
    }
}
