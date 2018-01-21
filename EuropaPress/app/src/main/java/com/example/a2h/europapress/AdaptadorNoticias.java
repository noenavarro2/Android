package com.example.a2h.europapress;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 2h on 25/10/2017.
 */

public class AdaptadorNoticias extends ArrayAdapter {

    Activity activity;
    List<Noticia> lista;

    public AdaptadorNoticias(Activity context, List <Noticia> lista) { //context es superclase de la clase activity asi que es lo mismo
        super(context, R.layout.distribucion, lista);
        activity = context;
        this.lista=lista;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.distribucion,null);
        TextView etictTitulo =(TextView)view.findViewById(R.id.LblTiulo); // si puesieramos solo findViewbyid saldria error porque delante hay un this y aqui no esta ese metodo enontces desde vista si que esta
        etictTitulo.setText(lista.get(position).getTitulo());
        TextView descripTitulo =(TextView)view.findViewById(R.id.lblDescripcion);
        descripTitulo.setText(lista.get(position).getDescripcion());

        return  view;
    }
}
