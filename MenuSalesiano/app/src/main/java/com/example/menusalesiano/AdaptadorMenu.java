package com.example.menusalesiano;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 2h on 26/10/2017.
 */

public class AdaptadorMenu extends ArrayAdapter{
    Activity contexto;
    List<Menu> lista;
    AdaptadorMenu(Activity context, List<Menu> lista){
        super(context, R.layout.layout, lista);
        contexto=context;
        this.lista=lista;
    }// formando parte del ciclo de vida del arrayadapter hay un metodo que se llama getview y que se ejecutara el solo tantas veces como elementos tenga elt ercer parametro del metodo constructor


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//primer parametro indica la posicion del vector

        LayoutInflater inflater=contexto.getLayoutInflater();
        View item= inflater.inflate(R.layout.layout,null);

        TextView plato1=(TextView) item.findViewById(R.id.Plato1);
        TextView plato2=(TextView) item.findViewById(R.id.Plato2);

        plato1.setText(lista.get(position).getPlato1());
        plato2.setText(lista.get(position).getPlato2());


        return item;


    }
}


