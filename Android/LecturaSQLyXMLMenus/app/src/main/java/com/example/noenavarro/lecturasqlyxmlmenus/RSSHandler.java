package com.example.noenavarro.lecturasqlyxmlmenus;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NoeNavarro on 09/11/2017.
 */

public class RSSHandler extends DefaultHandler {

    private List<MenuDiario> MenusDiarios ;
    private MenuDiario menusDiarioactual;
    private StringBuilder sbTexto;

    public List<MenuDiario> getMenusDiarios() {
        return MenusDiarios;
    }
    @Override
    public void startDocument() throws SAXException { //este metodo se ejecuta al iniciar la pagina y se ejecuta una sola vez
        super.startDocument();
        MenusDiarios = new ArrayList<MenuDiario>();
        sbTexto = new StringBuilder();

    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { //este metodo cada vez que hay una marca de apertura se ejecuta
        super.startElement(uri, localName, qName, attributes);

        if(localName.equals("dia")){
            menusDiarioactual = new MenuDiario();
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException { //este metodo lee los caracteres de texto que hay y los mete en sbtexto que es de string
        super.characters(ch, start, length);

        if ( menusDiarioactual != null){
            sbTexto.append(ch, start, length); //append es el metodo añadir
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException { //lee las marcas de cerrar
        super.endElement(uri, localName, qName);
        if ( menusDiarioactual != null)
        {
            if (localName.equals("Plato_1")){
                menusDiarioactual.setPrimerPlato(sbTexto.toString());

            }else if (localName.equals("Plato_2")){
                menusDiarioactual.setSegundoPlato(sbTexto.toString());

            }else if (localName.equals("Postre")) {
                menusDiarioactual.setPostre(sbTexto.toString());


            }else if (localName.equals("Fecha")) {
                menusDiarioactual.setFecha(sbTexto.toString());

            }else if (localName.equals("dia")) {
                MenusDiarios.add(menusDiarioactual);
            }

            sbTexto.setLength(0);//con esto sbTexto se vacia
        }

    }




}
