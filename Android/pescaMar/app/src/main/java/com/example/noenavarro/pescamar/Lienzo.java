package com.example.noenavarro.pescamar;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by NoeNavarro on 22/11/2017.
 */

public class Lienzo extends View {
    private Pez pez;
    private Bitmap fondo;
    private static ArrayList<Pez> pezones;
    private static Tiburon tiburon;
    private static ArrayList<Burbuja> burbujas;

    public Lienzo(Context context, int an, int al){
        super(context);

        pezones = new ArrayList<Pez>();
        tiburon = new Tiburon(this, an, al);
        burbujas = new ArrayList<Burbuja>();
        for (int i=0; i<14; i++) {
            burbujas.add(new Burbuja(this, an, al));
        }
        for (int i=0; i<20; i++) {
            pezones.add(new Pez(this, an, al));
        }
        fondo = BitmapFactory.decodeResource(this.getResources(), R.drawable.background);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(fondo,0,0,null);
        for (int i=0; i<pezones.size(); i++) {
            pezones.get(i).dibujar(canvas);
        }
        for (int i=0; i<burbujas.size(); i++) {
            burbujas.get(i).dibujar(canvas);
        }
        tiburon.dibujar(canvas);
    }
    public static void añadepeces(View v, int an, int al){

        for (int i = 0; i < burbujas.size(); i++) {
            if (burbujas.get(i).intersect(tiburon)) {
                    burbujas.remove(burbujas.get(i));
                    for (int j = 0; j <5; j++)
                        pezones.add(new Pez(v, an, al));
            }
        }
    }
    public static void comepeces(){
        for (int i = 0; i < pezones.size(); i++) {
            if (pezones.get(i).intersect(tiburon)) {
                pezones.remove(pezones.get(i));

            }
        }
    }


    public boolean onTouchEvent(MotionEvent event){
        if (tiburon.contains(event.getX(),event.getY())){
            tiburon.left=(int)(event.getX()- tiburon.ancho/2);
            tiburon.top=(int)(event.getY()- tiburon.alto/2);
            tiburon.right = tiburon.left + tiburon.ancho;
            tiburon.bottom = tiburon.top + tiburon.alto;
            this.invalidate();
        }

        return true;
    }


}
