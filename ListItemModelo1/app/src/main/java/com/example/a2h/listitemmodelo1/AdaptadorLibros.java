package com.example.a2h.listitemmodelo1;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by 2h on 27/09/2017.
 */

public class AdaptadorLibros  extends ArrayAdapter{

    Activity contexto;
    Libro datos [];
    AdaptadorLibros(Activity context, Libro datos[]){

        super(context, R.layout.listitem_libro, datos );
        contexto = context;
        this.datos = datos ;

    }
    //formando parte del ciclo del arrayadapter hay un metodo que se llama getview y que se ejecutara el solo tantas veces como elemntos tena el tercer parametro del metodo constructor
    //los metodos de ciclo se ejecutan solo tantas veces como elementos tenga el vector que pasemos como tercer parametros
    //sin necesidad de llamarlo
    public View getView(int position, View convertView, ViewGroup parent){ // un objeto de la clase view , position indice la posicion en el vector
        LayoutInflater inflater = contexto.getLayoutInflater(); //esto lo que hace es para pasar el archivo de xml inflarlo y que sea un objeto de vista
        View item =inflater.inflate(R.layout.listitem_libro, null);
        TextView titulo = (TextView) item.findViewById(R.id.lblTitulo);//findViewById es una clase de activity por lo que hay que llamarla arriba y ponerlo asi sino da error
        TextView autor = (TextView) item.findViewById(R.id.lblAutor);

        titulo.setText(datos[position].getTitulo());
        autor.setText(datos[position].getAutor());
        return item ;

    }




}
