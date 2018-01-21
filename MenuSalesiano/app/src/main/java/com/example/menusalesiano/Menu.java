package com.example.menusalesiano;

/**
 * Created by 2h on 26/10/2017.
 */

public class Menu {
    private String plato1;
    private String plato2;
    private String postre;
    private String fecha;
    public Menu(String fecha, String plato1, String plato2, String postre) {
        this.fecha = fecha;
        this.plato1= plato1;
        this.plato2 = plato2;
        this.postre = postre;
    }
    public Menu(){

    }
    public String getPlato1() {
        return plato1;
    }

    public void setPlato1(String plato1) {
        this.plato1 = plato1;
    }

    public String getPlato2() {
        return plato2;
    }

    public void setPlato2(String plato2) {
        this.plato2 = plato2;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



}
