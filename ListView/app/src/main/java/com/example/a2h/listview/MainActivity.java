package com.example.a2h.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lista = (ListView)  findViewById(R.id.ListView);

        final String[] datos = {"Elememto 1", "Elemento2", "Elemento3", "Elemento4", "Elemento5"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , datos);


        lista.setAdapter(adaptador);



    }
}
