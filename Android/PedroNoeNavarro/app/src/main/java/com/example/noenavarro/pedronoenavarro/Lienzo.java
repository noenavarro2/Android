package com.example.noenavarro.pedronoenavarro;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.icu.text.SimpleDateFormat;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by NoeNavarro on 01/12/2017.
 */

public class Lienzo extends View implements Runnable {
    private int rectangulosDestruido = 0;
    int getRectangulosDestruidosAlTerminar;
    static Date date;
    static String fecha;
    View view;
    static Integer ancho,alto;
    private Rectangulo rectangulo;
    private ArrayList<Rectangulo> rectangulos;
    private int contador = 10;

    public Lienzo(Context context, int an, int al){
        super(context);
        rectangulos = new ArrayList<Rectangulo>();
        for (int i=0; i<14; i++) {
            rectangulos.add(new Rectangulo());
        }
       new Thread(this).start();
    }

    protected void onDraw(Canvas canvas){
        for (int i=0; i<rectangulos.size(); i++) {
            rectangulos.get(i).dibujar(canvas);
        }
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(100);
                if (contador==100) {
                    Thread.interrupted();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    date = new Date();
                    fecha = dateFormat.format(date);
                    getRectangulosDestruidosAlTerminar = rectangulosDestruido;
                }
                view.postInvalidate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event){
        for (int i=0; i<14; i++) {
            if (rectangulos.get(i).contains(event.getX(),event.getY())){
                    rectangulos.remove(rectangulos.get(i));
                    rectangulosDestruido ++;
                this.invalidate();
            }
        }
        return true;
    }
}
