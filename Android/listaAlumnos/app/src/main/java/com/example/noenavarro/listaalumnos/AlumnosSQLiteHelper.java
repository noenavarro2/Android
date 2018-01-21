package com.example.noenavarro.listaalumnos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NoeNavarro on 15/11/2017.
 */

public class AlumnosSQLiteHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE alumnos(nom_alumno TEXT,foto TEXT, sonido TEXT )";

    public AlumnosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//lo mismo que el .net la primera vez crea la tabla si no existe
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { //en este metodo si la tabla ya esta creada se la carga y luego la crea otra vez
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS alumnos");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
