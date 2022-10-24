package com.company;

public class Persona {

    //atributos
    //1)nombre porque la validacion la hago con este dato
    private String nombre;
    //2)edad para validar si es mayor
    private Integer edad;


    //creo su constructor 2)agrego edad
    public Persona(String nombre, Integer edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }
}
