package com.example.a2h.spinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.opciones); //obejto de salida

        final String[] datos = {"Eleemto 1", "Elemento2", "Elemento3", "Elemento4", "Elemento5"};
        ArrayAdapter <String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , datos);//es una lista mas o menos y el Registro es el de android no el del proyecto

        //cargar los datos del spinner con los datos del adaptador
        spinner.setAdapter(adaptador);


    }
}
