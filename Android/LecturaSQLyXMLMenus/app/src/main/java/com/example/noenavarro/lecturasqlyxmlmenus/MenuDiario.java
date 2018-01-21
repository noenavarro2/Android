package com.example.noenavarro.lecturasqlyxmlmenus;

/**
 * Created by NoeNavarro on 09/11/2017.
 */

public class MenuDiario {
    private String dia; //dia es al marca del documento xml que marca cada menu diario
    private String PrimerPlato;
    private String SegundoPlato;
    private String Postre;
    private String Fecha;

    public String getPrimerPlato() {
        return PrimerPlato;
    }

    public void setPrimerPlato(String primerPlato) {
        PrimerPlato = primerPlato;
    }

    public String getSegundoPlato() {
        return SegundoPlato;
    }

    public void setSegundoPlato(String segundoPlato) {
        SegundoPlato = segundoPlato;
    }

    public String getPostre() {
        return Postre;
    }

    public void setPostre(String postre) {
        Postre = postre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
