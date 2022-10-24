package com.company;

import java.util.HashMap;

public class CancionFactory {

    //creo mi mapa
    private static final HashMap<String, Cancion> cancionMap = new HashMap<>();

    //metodo que devuelva canciones
    public static Cancion agregarCancion(String nombre) {
        Cancion cancion = cancionMap.get(nombre);
        //si no encuentro esa cancion, la creo:
        if (cancion == null) {
            cancion = new Cancion(nombre);
            cancionMap.put(nombre, cancion);
            System.out.println("creo una cancion de nombre: "+nombre);
        }
        //retorno la canción (encontrada o creada):
        return cancion;
    }

}
