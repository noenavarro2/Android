package com.example.a2h.ejemplogridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] datos= new String[25];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=1; i<=25;i++)
            datos[i-1]="Dato"+i;

        final TextView lblMensaje=(TextView) findViewById(R.id.lblMensaje);
        final GridView grid= (GridView) findViewById(R.id.gridOpciones);
        ArrayAdapter<String> adatador= new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, datos);
        grid.setAdapter(adatador);

        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lblMensaje.setText("Seleccionado: " + datos[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lblMensaje.setText("");
            }
        });
    }
}
