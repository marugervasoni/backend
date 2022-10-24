package com.company;

import java.util.List;

public class Test {

    //creo lista con nombres para canciones para probar el patron:
    private static final String nombres[] = {"Money for nothing", "Don´t stay", "Scar Tissue", "Balafonerra", "All of time"};
    private static final String Lista1[] = {cancion1,cancion2,cancion3}; //ver

    public static void main(String[] args) {
        // write your code here

        //con un loop vamos a crear canciones y cuando las tenga, solo las busque en cache y muestre
        for (int i = 0; i < 25; i++) {
            //pruebo mi Factory
            Cancion cancion = CancionFactory.agregarCancion(cancionAleatoria());
            //agrego datos a las canciones
            cancion.setArtista("Unknown");
            cancion.setGenero("Rock");
            //probamos metodo para ver cuando buscó del cache
            cancion.reproducirCancion();
        }
        //crear lista reproduccion
        Cancion cancion1 = CancionFactory.agregarCancion("Breaking the habit");
        Cancion cancion2 = CancionFactory.agregarCancion("Somewhere i belong");
        Cancion cancion3 = CancionFactory.agregarCancion("In the end");
        cancion1.setArtista("Linkin Park");
        cancion2.setArtista("Linkin Park");
        cancion3.setArtista("Linkin Park");
        cancion1.setGenero("Rock");
        cancion2.setGenero("Rock");
        cancion3.setGenero("Rock");



    }

    //hago metodo cancion aleatoria
    private static String cancionAleatoria() {
        return nombres[(int) (Math.random() * nombres.length)];

    }



}
