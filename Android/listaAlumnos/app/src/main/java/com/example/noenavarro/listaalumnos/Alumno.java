package com.example.noenavarro.listaalumnos;

/**
 * Created by NoeNavarro on 15/11/2017.
 */

public class Alumno {
    private String nom_alumno;
    private  String foto;
    private  String sonido;

    public Alumno(String nom_alumno, String foto ,String sonido ) {
        this.nom_alumno = nom_alumno;
        this.foto = foto;
        this.sonido = sonido;
    }

    public String getNom_alumno() {
        return nom_alumno;
    }

    public void setNom_alumno(String nom_alumno) {
        this.nom_alumno = nom_alumno;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }
}
