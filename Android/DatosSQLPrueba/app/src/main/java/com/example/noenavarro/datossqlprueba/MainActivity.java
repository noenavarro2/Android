package com.example.noenavarro.datossqlprueba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> lista =new ArrayList<String>();

        UsuariosSql usuariosSql=new UsuariosSql(this, "DBUsuarios",null, 1);

        SQLiteDatabase db = usuariosSql.getWritableDatabase();

        db.execSQL("DELETE FROM Usuarios"); //borra la tabla usuarios

        for(int i=0;i<5;i++)
            db.execSQL("INSERT INTO Usuarios (codigo, nombre) VALUES (" + i + ", 'Usuario" + i + "')");

        Cursor cursor=db.rawQuery("select * from Usuarios", null);

        if(cursor.moveToFirst()){
            do{
                String usuario ="";
                usuario+=cursor.getInt(0)+ " - ";
                usuario+=cursor.getString(1);

                lista.add(usuario);
            }while (cursor.moveToNext());//eof final
        }
        ListView listView=(ListView) this.findViewById(R.id.listaxm);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,lista);
        listView.setAdapter(arrayAdapter);

        db.close();
        //tools android device monitor para acceder a los archivos del telefono



    }
}
