package com.example.noenavarro.acelerometro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.view.View;


/**
 * Created by NoeNavarro on 10/11/2017.
 */

public class Vista extends View  {
    Bitmap imagen;
    int posx, posy;
    public Vista(Context context) {
        super(context);
        imagen = BitmapFactory.decodeResource(this.getResources(),R.drawable.carlos);
        posx = posy = 100;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(imagen, posx, posy, null);
    }
    public void mover(int x , int y){
        posx -= x;
        posy += y;
        invalidate(); //es eun metodo para refrescar es como el repaint()
    }


}
