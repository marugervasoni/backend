package com.company;

public class Cancion {

    //atributos
    private String nombre; //compartido

    private String artista;
    private String genero;

    //constructor
    public Cancion(String nombre){
        this.nombre = nombre;
    }


    //getters y setters
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //metodo reproducir canciones (es para ver cuando la busca del cache)
    public void reproducirCancion(){
        System.out.println("reproduciendo cancion: "+ nombre);
    }
}
