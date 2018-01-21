package com.example.noenavarro.pescamar;

import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Canvas;
        import android.graphics.RectF;
        import android.view.View;

public class Pez extends RectF implements Runnable {
    private Bitmap[] imagenes;
    int activa=0;
    public int ancho,alto,anchuraPant,alturaPant;
    View view;
    public int estado;
    public static final int LINEA= 0;
    public static final int ARRIBA= 1;
    public static final int ABAJO= 2;
    Lienzo lienzo ;
    int velocidad  = (int)(Math.random()*15)+5;

    public Pez (View v, int altura, int anchura){
        super((int)(Math.random()*1600)+anchura,(int)(Math.random()*altura),0,0); // left,top,right,bottom
        imagenes = new Bitmap[3];
        imagenes[0]= BitmapFactory.decodeResource(v.getResources(), R.drawable.pez0);
        imagenes[1]= BitmapFactory.decodeResource(v.getResources(), R.drawable.pez1);
        imagenes[2]= BitmapFactory.decodeResource(v.getResources(), R.drawable.pez2);

        anchuraPant=anchura;
        alturaPant=altura;

        ancho = imagenes[0].getWidth();
        alto = imagenes[0].getHeight();
        velocidad = (int)(Math.random()*15)+5;
        right = left + ancho;
        bottom = top + alto;
        view = v;
        new Thread(this).start();

    }

    public void dibujar(Canvas c){
        c.drawBitmap(imagenes[activa], left, top, null);
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(100);
                activa = (activa+1)%3;
                actualizarPosicion();

                Lienzo.añadepeces(view,anchuraPant,alturaPant);


                Lienzo.comepeces();

                if (right<0){
                    left=anchuraPant;
                    right=left+ancho;
                }

                view.postInvalidate();
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
        left -=velocidad;
        right-=velocidad;

    }

}