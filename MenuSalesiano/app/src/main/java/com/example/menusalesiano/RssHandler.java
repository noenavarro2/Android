package com.example.menusalesiano;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;


import java.util.ArrayList;
import java.util.List;



/**
 * Created by 2h on 26/10/2017.
 */

public class RssHandler extends DefaultHandler2 {
    private List<Menu> menus;//una lista cargada con las noticias que haya en el documento xml de europapress y luego lo devuelva
    private Menu menuActual;
    private StringBuilder sbTexto;//es una cadena de caracteres, un string modificado

    public List<Menu> getMenus() {
        return menus;
    }

    @Override
    public void startDocument() throws SAXException { //este metodo se ejecuta al iniciar la pagina y se ejecuta una sola vez
        super.startDocument();
        menus = new ArrayList<Menu>();
        sbTexto = new StringBuilder();

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { //este metodo cada vez que hay una marca de apertura se ejecuta
        super.startElement(uri, localName, qName, attributes);

        if(localName.equals("item")){
            menuActual = new Menu();
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException { //este metodo lee los caracteres de texto que hay y los mete en sbtexto que es de string
        super.characters(ch, start, length);

        if (menuActual != null){
            sbTexto.append(ch, start, length); //append es el metodo añadir
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri,localName,qName);

        if (menuActual != null){
            if ((localName.equals("item"))) {
                menuActual.setPostre(sbTexto.toString());
            }else if(localName.equals("descripcion")){
                menuActual.setPlato1(sbTexto.toString());
            }else if(localName.equals("pubdate")){
                menuActual.setFecha(sbTexto.toString());
            }else if(localName.equals("pubdate")){
                menuActual.setPlato2(sbTexto.toString());
            }else if(localName.equals("item")){
                menus.add(menuActual);
            }

            sbTexto.setLength(0);
        }
    }

}










