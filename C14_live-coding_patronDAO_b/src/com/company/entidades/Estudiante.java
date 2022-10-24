package com.company.entidades;

//1) creo mi clase estudiante
public class Estudiante {

    //atributos
    private Long id; //importante y que sea incremental (para la BD)
    private String nombre;
    private String apellido;

    //getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
