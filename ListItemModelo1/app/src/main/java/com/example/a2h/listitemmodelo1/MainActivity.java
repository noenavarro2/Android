package com.example.a2h.listitemmodelo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity { //controlador

    private Libro [] libros = {
              new Libro("El quijote", "cervantes")
            , new Libro("El arduino y su estudio", "juan ")
            , new Libro("Python mas a fondo", "juan ")
            , new Libro("codigo limpio", "gorka ")
            , new Libro("una semana sin poder sentarse ", "javier bielsa")
            , new Libro("las enfermedades de transmision sexual", "javier bielsa")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView opciones = (ListView) findViewById(R.id.lstOpciones);
        AdaptadorLibros adaptador = new AdaptadorLibros(this, libros);
        opciones.setAdapter(adaptador);










    }
}
