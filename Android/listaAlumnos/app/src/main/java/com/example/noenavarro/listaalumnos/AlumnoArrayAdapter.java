package com.example.noenavarro.listaalumnos;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.noenavarro.listaalumnos.Alumno;
import com.example.noenavarro.listaalumnos.R;

/**
 * Created by NoeNavarro on 16/11/2017.
 */

public class AlumnoArrayAdapter extends ArrayAdapter {

    Alumno vAlumnos[];
    Activity activity;
   

    public AlumnoArrayAdapter(@NonNull Activity context,Alumno[] v) {
        super(context, R.layout.distribucionalumno,v);
        vAlumnos = v;
        activity= context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View vista = inflater.inflate(R.layout.distribucionalumno, null);

        TextView lblAlumno = (TextView)vista.findViewById(R.id.textviewAlumno); //se busca desde vista porque sino el metodo finviewbyid no se encuentra
        lblAlumno.setText(vAlumnos[position].getNom_alumno());//con esto hemos cargado la etique del texto alumno

        ImageView imagen = (ImageView)vista.findViewById(R.id.foto);
        imagen.setImageResource(vista.getResources().getIdentifier(vAlumnos[position].getFoto(),"drawable", activity.getPackageName()));//el metodo getresources te devuelve un objeto  del directorio res de la izquierda

        Button boton = (Button)vista.findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            public MediaPlayer mp;
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(activity, activity.getResources().getIdentifier(vAlumnos[position].getSonido(),"raw", activity.getPackageName()));

            }
        });
        return vista;
    }
}
