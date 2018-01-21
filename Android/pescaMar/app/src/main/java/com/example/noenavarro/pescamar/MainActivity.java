package com.example.noenavarro.pescamar;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
    int anchura,altura;
    Lienzo lienzo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Display display = getWindowManager().getDefaultDisplay();
        Point tamano = new Point();
        display.getSize(tamano);
        anchura = tamano.x;
        altura = tamano.y;

        RelativeLayout pantalla = (RelativeLayout)findViewById(R.id.pantallaPrincipal);
        lienzo = new Lienzo(this,anchura,altura);
        pantalla.addView(lienzo);

    }
}
