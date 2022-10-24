package com.company;

public class Perro {

    //atributos
    private String nombre;
    private String raza;
    private Boolean esCachorro;

    private static int costoAlimento; //atributo de clase--> no modificable, es  un valor comun a cada perro

    //constructor
    public Perro(String nombre, String raza, Boolean esCachorro){
        this.nombre = nombre;
        this.raza = raza;
        this.esCachorro = esCachorro;
    }

    //metodos
    public void ladrar(){
        System.out.println("Guau Guau");
    }

    public double gastoAlimento(double kilos) {
        return kilos*Perro.costoAlimento;
    }

    static public void cambiarCostoAlimento(int costo){ //metodo de clase
        Perro.costoAlimento = costo;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Boolean getEsCachorro() {
        return esCachorro;
    }

    public void setEsCachorro(Boolean esCachorro) {
        this.esCachorro = esCachorro;
    }
}
