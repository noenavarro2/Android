package com.example.noenavarro.pescamar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by NoeNavarro on 24/11/2017.
 */

public class Tiburon  extends RectF implements Runnable { //RectF es el rectangle
    public static final int LINEA = 0;
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    public int estado = LINEA;
    int velocidad = (int)(Math.random()*15)+5;
    private Bitmap[] imagenes;
    public int ancho, alto;
    View view;
    int num = 0;

    public Tiburon(View v , int altura, int anchura ){
        super(600,200,0,0 );
        imagenes = new Bitmap[3];
        imagenes[0] = BitmapFactory.decodeResource(v.getResources(), R.drawable.fish0);
        imagenes[1] = BitmapFactory.decodeResource(v.getResources(), R.drawable.fish1);
        imagenes[2] = BitmapFactory.decodeResource(v.getResources(), R.drawable.fish2);

        ancho = imagenes[0].getWidth();
        alto = imagenes[0].getHeight();
        right = left + ancho;
        bottom = top + alto;
        view = v;
        new Thread(this).start();
    }
    public void dibujar(Canvas c){
        c.drawBitmap(imagenes[num],left,top,null);
    }
    public void run(){
        while(true){
            try{
                Thread.sleep(100);
                num=(num+1)%3;
                view.postInvalidate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
