package com.example.a2h.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] datos={"Hola","App","Android"};
        final ListView lista= (ListView) findViewById(R.id.lista);

        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);

        lista.setAdapter(adaptador);
    }
}
