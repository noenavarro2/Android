package com.example.noenavarro.datossqlprueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NoeNavarro on 30/11/2017.
 */

public class UsuariosSql extends SQLiteOpenHelper {
    String sqlCreacion = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";

    public UsuariosSql(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //se ejecuta una vez
        sqLiteDatabase.execSQL(sqlCreacion); //ejecuta una sentencia sql
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Usuarios"); //se ejecuta cada vez que haya una actualizacion en la extructura de la tabla
        sqLiteDatabase.execSQL(sqlCreacion);

    }
}
