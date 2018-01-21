package com.example.a2h.europapress;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2h on 18/10/2017.
 */

public class RssHandler extends DefaultHandler {


    private List<Noticia> noticias;//una lista cargada con las noticias que haya en el documento xml de europapress y luego lo devuelva
    private Noticia noticiaActual;
    private StringBuilder sbTexto;//es una cadena de caracteres, un string modificado

    public List<Noticia> getNoticias() {
        return noticias;
    }

    @Override
    public void startDocument() throws SAXException { //este metodo se ejecuta al iniciar la pagina y se ejecuta una sola vez
        super.startDocument();
        noticias = new ArrayList<Noticia>();
        sbTexto = new StringBuilder();

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { //este metodo cada vez que hay una marca de apertura se ejecuta
        super.startElement(uri, localName, qName, attributes);

        if(localName.equals("item")){
            noticiaActual = new Noticia();
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException { //este metodo lee los caracteres de texto que hay y los mete en sbtexto que es de string
        super.characters(ch, start, length);

        if (noticiaActual != null){
            sbTexto.append(ch, start, length); //append es el metodo añadir
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException { //lee las marcas de cerrar
        super.endElement(uri, localName, qName);
        if (noticiaActual != null)
        {
            if (localName.equals("title")){
                noticiaActual.setTitulo(sbTexto.toString());

            }else if (localName.equals("descripcion")){
                noticiaActual.setDescripcion(sbTexto.toString());

            }else if (localName.equals("pubdate")) {
                noticiaActual.setFecha(sbTexto.toString());

            }else if (localName.equals("category")) {
                noticiaActual.setCategoria(sbTexto.toString());

            }else if (localName.equals("item")) {
                noticias.add(noticiaActual);
            }

            sbTexto.setLength(0);//con esto sbTexto se vacia
        }

    }


}



