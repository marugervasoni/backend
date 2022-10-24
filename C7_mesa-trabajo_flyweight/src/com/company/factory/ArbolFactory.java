package com.company.factory;

import com.company.model.Arbol;

import java.util.HashMap;

public class ArbolFactory {

    //creo mi mapa que manejara la fabrica
    private static final HashMap<String, Arbol> arbolMap = new HashMap<>();
    //private Arbol ornamental;
    //private Arbol floral;
    //private Arbol frutal;


    public static Arbol crearArbol(String tipoArbol) {
        Arbol arbol = arbolMap.get(tipoArbol);
        if (arbol == null) {
            arbol = new Arbol(tipoArbol)
            if (tipoArbol.equals("ornamental")) {
                arbol.setAlto();
                arbol.setAncho();
                arbol.setColor(); //terminar
            }
            }
        }
    }
}
