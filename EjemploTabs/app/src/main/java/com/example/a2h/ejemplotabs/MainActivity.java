package com.example.a2h.ejemplotabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);// aqui es la conexion con el registo layaut es decir la vista que es el activity_main
        setContentView(new SelectorColor(this));


    }
}
