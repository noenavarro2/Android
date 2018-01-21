package com.example.noenavarro.pescamar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by NoeNavarro on 25/11/2017.
 */

public class Burbuja extends RectF implements Runnable {
    private Bitmap imagen;
    View view;

    public static final int LINEA = 0;
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    public int estado = LINEA;
    int velocidad = (int)(Math.random()*15)+10;
    public int ancho, alto, anchuraPant,alturaPant;
    int num = 0;

    public Burbuja(View v, int altura, int anchura) {
        super((int)(Math.random()*1200)+800,(int)(Math.random()*altura),0,0);
        imagen = BitmapFactory.decodeResource(v.getResources(), R.drawable.carlos);
        ancho = imagen.getWidth();
        alto = imagen.getHeight();
        right = left + ancho;
        bottom = top + alto;
        anchuraPant=anchura;
        alturaPant=altura;
        view = v;
        new Thread(this).start();
    }
    public void dibujar(Canvas c){
        c.drawBitmap(imagen,left,top,null);
    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(100);
                num=(num+1)%3;
                view.postInvalidate();
                actualizarPosicion();
                if (bottom<0){
                    top=anchuraPant;
                    bottom=left+ancho;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void actualizarPosicion (){
        double r1 = Math.random();
        double r2 = Math.random();
        switch (estado){
            case LINEA:
                if (r1>0.95)
                    if (r2>0.5)
                        estado=ARRIBA;
                    else
                        estado=ABAJO;

                break;
            case ABAJO:
                if (r1>0.75)
                    if (r2>0.5)
                        estado=LINEA;
                    else
                        estado=ARRIBA;
                break;
            case ARRIBA:
                if (r1>0.75)
                    if (r2>0.5)
                        estado=LINEA;
                    else
                        estado=ABAJO;
                break;
        }
        switch (estado){
            case ARRIBA:
                top -=2;
                bottom -=2;
                break;
            case ABAJO:
                top -=2;
                bottom -=2;
                break;
        }
        top -=velocidad;
        bottom -=velocidad;

    }
}
