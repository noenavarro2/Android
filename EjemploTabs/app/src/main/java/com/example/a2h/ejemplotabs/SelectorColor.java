package com.example.a2h.ejemplotabs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 2h on 28/09/2017.
 */

public class SelectorColor extends View {
    int altura, anchura;
    private int colorSeleccionado = Color.BLACK;
    public SelectorColor(Context context){
        super(context);
    }
    @Override
    protected void onMeasure(int altura,int anchura){//este metodo da dos valores que igualan a la pantalla
        super.onMeasure(altura,anchura);
        this.altura = 1000;
        this.anchura= 800;
    }

    @Override //si le pones esto es que el metodo ya existe y nosotros solo lo implementamos
    protected void onDraw(Canvas canvas){ //se ejecuta el solo
        Paint pRelleno = new Paint();
        pRelleno.setStyle(Paint.Style.FILL);//fill es una constante por lo que esta en mayusculas
        pRelleno.setColor(Color.RED);
        canvas.drawRect(0, 0, anchura/4,altura/2, pRelleno );//posicion en el eje de las x 0 y de las y 0, posicion de final x e y ,y espera recibir un obejto de la clase paint

        pRelleno.setColor(Color.GREEN);
        canvas.drawRect(anchura/4, 0,anchura/2,altura/2, pRelleno );

        pRelleno.setColor(Color.BLUE);
        canvas.drawRect(anchura/2, 0, (3*anchura)/4,altura/2, pRelleno );

        pRelleno.setColor(Color.CYAN);
        canvas.drawRect((3*anchura)/4, 0, anchura,altura/2, pRelleno );

        pRelleno.setColor(colorSeleccionado);
        canvas.drawRect(0, altura/2, anchura,altura, pRelleno );

    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
    if  ( (event.getY()> 0) &&(event.getX() < (altura/2)) ){
        if((event.getX() >0) && (event.getX() < (anchura/2)) ){
            if ((event.getX()) > (3*anchura/4))
                colorSeleccionado = Color.YELLOW;
            else if ((event.getX()) > (anchura/2))
                colorSeleccionado = Color.BLUE;
            else if ((event.getX()) > (anchura/4))
                colorSeleccionado = Color.GREEN;
            else
                colorSeleccionado = Color.RED;

        }

    }

        return true;

    }

}
