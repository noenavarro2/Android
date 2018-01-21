package com.example.noenavarro.pedronoenavarro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NoeNavarro on 01/12/2017.
 */

public class RectanguloSQL  extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE Records ( rectangulosEliminados CHAR(30) , fecha TEXT ,  hora DATATIME)";

    public RectanguloSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//lo mismo que el .net la primera vez crea la tabla si no existe
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Records");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
