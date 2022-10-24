package com.company;

public class Persona {

    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public Integer getEdad() {
        return edad;
    }
}
