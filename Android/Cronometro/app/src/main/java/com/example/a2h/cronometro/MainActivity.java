package com.example.a2h.cronometro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Chronometer crono=(Chronometer) findViewById(R.id.crono);
        final Button botoni=(Button) findViewById(R.id.botonI);
        final Button botonF=(Button) findViewById(R.id.botonF);

        botoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crono.start();
            }
        });
        botonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crono.stop();
                crono.re

            }
        });
    }
}
