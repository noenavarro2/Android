package com.example.a2h.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//conecta la vista con el controlador

        final EditText txtNombre= (EditText) findViewById(R.id.txtNombre);//final significa que es global, que se puede usar en todos los metodos
        final Button btnHola= (Button) findViewById(R.id.btnHola);
        btnHola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Crear un Intent
                Intent intent= new Intent(MainActivity.this, frmsaludo.class);
                //Crear la informacion para pasar entre Activities
                Bundle b= new Bundle();
                b.putString("NOMBRE", txtNombre.getText().toString());
                intent.putExtras(b);
                //iniciamos el nuevo activity
                startActivity(intent);
            }
        });

    }
}
