package com.example.noenavarro.lecturasqlyxmlmenus;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.grid);
        new miTarea().execute("http://informaticasalesianoszgz.org.es/menus.xml");
    }
    public class miTarea extends AsyncTask<String, Float, Integer> {//integer es una clase por lo que no acepta un num sino una clase

        //esta es una clase dentro de otra clase y se utiliza para que cuando se ejecute los parametros pasados el procesador no deje entrar ningun proceso mas excepto este
        List<MenuDiario> menusDisarios;

        @Override
        protected Integer doInBackground(String... params) { //es obligatorio implementar este metodo sino da error
            RssParserSax sax = new RssParserSax(params[0]);

            menusDisarios = sax.parse();
            publishProgress(250f);//si le pones la f al final significa que se lo pasas en coma flotante
            return null;
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            AdaptadorMenus adaptador = new AdaptadorMenus(MainActivity.this, menusDisarios);
            gridView.setAdapter(adaptador);
        }

    }
}
