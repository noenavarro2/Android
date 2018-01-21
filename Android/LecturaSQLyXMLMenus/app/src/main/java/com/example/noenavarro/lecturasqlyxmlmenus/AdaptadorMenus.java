package com.example.noenavarro.lecturasqlyxmlmenus;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NoeNavarro on 09/11/2017.
 */

public class AdaptadorMenus extends ArrayAdapter{
    Activity activity;
    List<MenuDiario> lista;

    public AdaptadorMenus(Activity context, List <MenuDiario> lista) { //context es superclase de la clase activity asi que es lo mismo
        super(context, R.layout.contenido, lista);
        activity = context;
        this.lista=lista;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.contenido,null);
        TextView etictTitulo =(TextView)view.findViewById(R.id.uno); // si puesieramos solo findViewbyid saldria error porque delante hay un this y aqui no esta ese metodo enontces desde vista si que esta
        etictTitulo.setText(lista.get(position).getPrimerPlato());

        TextView platoTitulo =(TextView)view.findViewById(R.id.dos);
        platoTitulo.setText(lista.get(position).getSegundoPlato());

        TextView descripTitulo =(TextView)view.findViewById(R.id.tres);
        descripTitulo.setText(lista.get(position).getPostre());

        TextView fechaTitulo =(TextView)view.findViewById(R.id.cuatro);
        fechaTitulo.setText(lista.get(position).getFecha());

        return  view;
    }
}
