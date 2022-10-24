package com.company;

//2) crear usuario
public class Usuario {

    private String nombre;
    private String email;
    private int sueldo;

    public Usuario(String nombre, String email, int sueldo) {
        this.nombre = nombre;
        this.email = email;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void subirSueldo(){
        System.out.println("subi sueldo");
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
