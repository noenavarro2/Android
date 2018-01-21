package com.example.a2h.ejemplotags;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 2h on 28/09/2017.
 */

public class SelectorColor extends View{
        int anchura, altura;
        private int colorSeleccionado=Color.BLACK;
    public SelectorColor(Context context){
        super(context);
    }
    public void onMeasure(int anchura, int altura){
        super.onMeasure(anchura,altura);
        this.anchura=750;
        this.altura=1000;
    }
        @Override
    protected  void  onDraw(Canvas canvas){
            Paint relleno= new Paint();
            relleno.setStyle(Paint.Style.FILL);
            relleno.setColor(Color.RED);
            canvas.drawRect(0,0,anchura/4,altura/2,relleno);

            relleno.setColor(Color.GREEN);
            canvas.drawRect(anchura/4,0,anchura/2,altura/2,relleno);

            relleno.setColor(Color.BLUE);
            canvas.drawRect(anchura/2,0,(3*anchura)/4,altura/2,relleno);

            relleno.setColor(Color.YELLOW);
            canvas.drawRect((3*anchura)/4,0,anchura,altura/2,relleno);

            relleno.setColor(colorSeleccionado);
            canvas.drawRect(0,altura/2,anchura, altura, relleno);
        }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if((event.getY()>0) && (event.getX()<(altura/2))){
            if((event.getY())>0&&(event.getX()<anchura)){
                if((event.getX()>(3*anchura)/4))
                    colorSeleccionado=Color.YELLOW;
                else if (event.getX()>(anchura/2))
                    colorSeleccionado=Color.BLUE;
                else if(event.getX()>(anchura/4))
                    colorSeleccionado=Color.GREEN;
                else
                    colorSeleccionado=Color.RED;
                //refrescamos el control
                this.invalidate();
            }
        }
        return true;
    }
}
