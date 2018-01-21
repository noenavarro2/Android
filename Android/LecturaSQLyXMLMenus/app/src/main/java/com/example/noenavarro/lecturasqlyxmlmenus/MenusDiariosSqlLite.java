package com.example.noenavarro.lecturasqlyxmlmenus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NoeNavarro on 09/11/2017.
 */

public class MenusDiariosSqlLite extends SQLiteOpenHelper {

    String sqlCreacion = "CREATE TABLE MenusDiarios (codigo INTEGER, nombre TEXT)";

    public MenusDiariosSqlLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) { //activity, nombre base de datos, null, verison
        super(context, name, factory, version);
    }

    //ciclo de vida
    @Override
    public void onCreate(SQLiteDatabase db) { //se ejecuta una vez
        db.execSQL(sqlCreacion); //ejecuta una sentencia sql
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MenusDiareos"); //se ejecuta cada vez que haya una actualizacion en la extructura de la tabla
        db.execSQL(sqlCreacion);
    }
}
