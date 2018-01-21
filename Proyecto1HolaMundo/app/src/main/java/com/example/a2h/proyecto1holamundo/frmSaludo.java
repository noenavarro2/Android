package com.example.a2h.proyecto1holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class frmSaludo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmsaludo);

        TextView Saludo = (TextView) findViewById(R.id.TxtSaludo) ;
        Bundle bundle = this.getIntent().getExtras();//esto es apa recibir
        //getIntent es de la clase Activity por eso el this que se podria omitir

        //cargar el contenido de bundle al txtview
        Saludo.setText("hola" + bundle.getString("Nombre"));
}
        }
