package com.example.noenavarro.listaalumnos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.GridView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    AlumnosSQLiteHelper alumnosSql;
    InputStream is = null;
    Alumno alumnos[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

           is = this.getAssets().open("sentenciasSQL.txt");//devuelve lo que hay dentro de los assets(carpeta que hemos creado con las consultas dentro)
        } catch(IOException e) {
            e.printStackTrace();
        }
        alumnosSql=new AlumnosSQLiteHelper(this, "DBAlumnos",null, 1);

        SQLiteDatabase db=alumnosSql.getWritableDatabase();//para ejecutar consultas sql

        db = alumnosSql.getWritableDatabase();//lo abrimos para escritura

        db.execSQL("DELETE FROM alumnos");//esto se hace por seguridad porque cuando entras asi no se guardan los datos de la anterior base de datos

        BufferedReader lector = new BufferedReader(new InputStreamReader(is));// no permite leerlo directamente por lo que se hace esto

        try {
            String linea = lector.readLine();//con esto lee una linea
            while (!TextUtils.isEmpty(linea));//es statico (como la clase math que no necesita instanciar) y le pasas un string y te devuelve si esta vacio o no //en cada linea se ejecuta una linea
               db.execSQL(linea);//el metodo exectSQL es el que ejecuta la sentencia sql
                //aqui va el insert into pero como no hay base de datos todavia no se pone
            linea = lector.readLine();


        } catch (IOException e) {
            e.printStackTrace();
        }
        db.close();
        db = alumnosSql.getReadableDatabase();//lo abrimos para lectura
        Cursor c = db.rawQuery("select* from alumnos", null);
        alumnos = new Alumno[c.getCount()];

        AlumnoArrayAdapter adapter = new  AlumnoArrayAdapter (this ,alumnos);
        GridView grid = (GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
    }
}
