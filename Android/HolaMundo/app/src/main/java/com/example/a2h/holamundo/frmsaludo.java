package com.example.a2h.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class frmsaludo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmsaludo);

        final TextView txtSaludo = (TextView) findViewById(R.id.txtSaludo);

        Bundle bundle= this.getIntent().getExtras();

        txtSaludo.setText("Hola "+bundle.getString("NOMBRE"));
    }
}
