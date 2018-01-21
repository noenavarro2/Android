package com.example.noenavarro.pedronoenavarro;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by NoeNavarro on 01/12/2017.
 */

public class Rectangulo  extends RectF implements Runnable {
    private String Rectangulo; //dia es al marca del documento xml que marca cada menu diario
    private Integer posx;
    private Integer posy;
    private Integer ancho;
    private Integer alto;
    private Integer color;
    View v ;
    private int velocidad  = (int)(Math.random()*10)+2;

    public Rectangulo() {
        super( (int)(Math.random()*100),(int)(Math.random()*200),0,0);
        new Thread(this).start();
    }
    public void dibujar(Canvas c){
        Paint paint = new Paint();
        paint.setColor(color);
        c.drawRect(posx,posy,ancho,alto,paint);
    }
    public String getRectangulo() {
        return Rectangulo;
    }
    public void setRectangulo(String rectangulo) {
        Rectangulo = rectangulo;
    }
    public Integer getPosx() {
        return posx;
    }
    public void setPosx(Integer posx) {
        this.posx = posx;
    }
    public Integer getPosy() {
        return posy;
    }
    public void setPosy(Integer posy) {
        this.posy = posy;
    }

    public Integer getAncho() {
        return ancho;
    }
    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }
    public Integer getAlto() {
        return alto;
    }
    public void setAlto(Integer alto) {
        this.alto = alto;
    }
    public Integer getColor() {
        return color;
    }
    public void setColor(Integer color) {
        this.color = color;
    }
    public void run(){
        while(true){
            try {
                Thread.sleep(100);
                actualizarPosicion();
                if (right<0){
                    left=ancho;
                    right=left+ancho;
                }
                if (bottom<0){
                    left=ancho;
                    right=left+ancho;
                }
                actualizarPosicion();

                v.postInvalidate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void actualizarPosicion (){
        left -=velocidad;
        right-=velocidad;
        top -=velocidad;
        bottom-=velocidad;

    }



}
