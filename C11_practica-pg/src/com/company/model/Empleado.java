package com.company.model;

public class Empleado {

    private int id;
    private String nombre;
    private int edad;
    private String empresa;
    private String fechaIngreso;

    public Empleado(){
        //constructor vacio
    }
    public Empleado(int id, String nombre, int edad, String empresa, String fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.empresa = empresa;
        this.fechaIngreso = fechaIngreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    //al instanciar un nuevo empleado se transforma asi:
    //metodo toString
    public String toString(){
        return "Empleado{"+
                "id=" + id +
                ", nombre=" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", empresa='" + empresa + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                '}';
    }
}
