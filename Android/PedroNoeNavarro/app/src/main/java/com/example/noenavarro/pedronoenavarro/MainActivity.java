package com.example.noenavarro.pedronoenavarro;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    int anchura,altura;
    Lienzo lienzo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new miTarea().execute("http://www.europapress.es/rss/rss.aspx");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Display display = getWindowManager().getDefaultDisplay();
        Point tamano = new Point();
        display.getSize(tamano);
        anchura = tamano.x;
        altura = tamano.y;

        RelativeLayout pantalla = (RelativeLayout) findViewById(R.id.pantallaPrincipal);
        lienzo = new Lienzo(this, anchura, altura);
        pantalla.addView(lienzo);

        RectanguloSQL rectanguloSQL=new RectanguloSQL(this, "DBRecords",null, 1);

        SQLiteDatabase db = rectanguloSQL.getWritableDatabase();

        db.execSQL("DELETE FROM Records");

            db.execSQL("INSERT INTO Records (rectangulosEliminados, fecha, hora) VALUES (  Lienzo.rectangulo +'', Lienzo.fecha+ '',Lienzo.date + '')");
        db.close();

    }
    public class miTarea extends AsyncTask<String, Float, Integer> {
        List<Rectangulo> rectangulos;

        @Override
        protected Integer doInBackground(String... params) {
            RssParserSax sax = new RssParserSax(params[0]);
            rectangulos = sax.parse();
            publishProgress(250f);
            return null;
        }
    }
}
