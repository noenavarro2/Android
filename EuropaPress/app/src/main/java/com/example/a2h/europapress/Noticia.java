package com.example.a2h.europapress;

/**
 * Created by 2h on 18/10/2017.
 */

public class Noticia {

    private  String titulo;
    private  String descripcion;
    private  String  fecha;
    private  String categoria;
    //nos hemos cargado el metodo construcotr pero si no lo creamos no pasa nada porque de manera implicita hay uno ya pero sus metodos estan vacios

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
