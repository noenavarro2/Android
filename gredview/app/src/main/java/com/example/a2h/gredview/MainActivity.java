package com.example.a2h.gredview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] datos = new String[25];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0; i<=25; i++){
            datos[i-1]= "Dato" + i;
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , datos);
        final TextView lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        final GridView gridOpciones = (GridView) findViewById(R.id.gridOpciones);//final es como una variable goblal y que se puede utilizar desde cualquier otro metodo


        gridOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lblMensaje.setText("Seleccionado: " + datos[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
