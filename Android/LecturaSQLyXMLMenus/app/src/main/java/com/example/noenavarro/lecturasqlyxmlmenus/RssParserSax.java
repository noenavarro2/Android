package com.example.noenavarro.lecturasqlyxmlmenus;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by NoeNavarro on 11/11/2017.
 */

public class RssParserSax {

    private URL rssUrl;

    public RssParserSax(String rssUrl) {
        try {
            this.rssUrl = new URL(rssUrl);//la clase url espera recibir un string
            //tiene que estar sometido a tratamiento de exceptciones
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }
    public List<MenuDiario> parse(){ //el metodo parse nos lo inventamos y nos devolvera la lista con los menus
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            RSSHandler handler = new RSSHandler();
            parser.parse(abrirParaLectura() , handler);
            return handler.getMenusDiarios();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private InputStream abrirParaLectura(){
        try {
            return rssUrl.openConnection().getInputStream(); //lee loabierto para lectura
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }


}
