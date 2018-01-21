package com.example.a2h.listitemmodelo1;

/**
 * Created by 2h on 22/09/2017.
 */

public class Libro {
    private String titulo;
    private  String autor;

    public Libro(String tit, String aut){
        titulo = tit;
        autor = aut;

    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
