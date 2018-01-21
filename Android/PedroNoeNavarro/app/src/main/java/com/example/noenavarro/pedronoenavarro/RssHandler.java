package com.example.noenavarro.pedronoenavarro;

import android.view.View;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NoeNavarro on 01/12/2017.
 */

public class RssHandler  extends DefaultHandler {

    private List<Rectangulo> rectangulos ;
    private Rectangulo rectanguloActual;
    private StringBuilder sbTexto;

    public List<Rectangulo> getRectangulos() {
        return rectangulos;
    }

    @Override
    public void startDocument() throws SAXException { //este metodo se ejecuta al iniciar la pagina y se ejecuta una sola vez
        super.startDocument();
        rectangulos = new ArrayList<Rectangulo>();
        sbTexto = new StringBuilder();

    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { //este metodo cada vez que hay una marca de apertura se ejecuta
        super.startElement(uri, localName, qName, attributes);

        if(localName.equals("Rectangulo")){
            rectanguloActual = new Rectangulo();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException { //este metodo lee los caracteres de texto que hay y los mete en sbtexto que es de string
        super.characters(ch, start, length);

        if ( rectanguloActual != null){
            sbTexto.append(ch, start, length); //append es el metodo añadir
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException { //lee las marcas de cerrar
        super.endElement(uri, localName, qName);
        if ( rectanguloActual != null)
        {
            if (localName.equals("posx")){
                rectanguloActual.setPosx(Integer.parseInt(sbTexto.toString()));

            }else if (localName.equals("posy")){
                rectanguloActual.setPosy(Integer.parseInt(sbTexto.toString()));

            }else if (localName.equals("ancho")) {
                rectanguloActual.setAncho(Integer.parseInt(sbTexto.toString()));


            }else if (localName.equals("alto")) {
                rectanguloActual.setAlto(Integer.parseInt(sbTexto.toString()));

            }else if (localName.equals("color")) {
                rectanguloActual.setColor(Integer.parseInt(sbTexto.toString()));

            }else if (localName.equals("Rectangulo")) {
                rectangulos.add(rectanguloActual);

            }

            sbTexto.setLength(0);//con esto sbTexto se vacia
        }

    }
}

