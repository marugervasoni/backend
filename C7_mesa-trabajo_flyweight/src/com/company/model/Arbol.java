package com.company.model;

//creo mi clase principal
public class Arbol {

    //atributos
    private String tipoArbol; //compartido

    private Integer alto;
    private Integer ancho;
    private String color;

    //constructor solo con el atrib compartido
    public Arbol(String tipoArbol) {
        this.tipoArbol = tipoArbol;
    }

    //getters y setters para lo que se modificara en tiempo de ejecucion
    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
