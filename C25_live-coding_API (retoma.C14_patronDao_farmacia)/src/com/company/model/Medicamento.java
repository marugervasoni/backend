package com.company.model;

//1)
public class Medicamento {

    //atributos
    private Integer id;
    private Integer codigoNumerico;
    private String nombre;
    private String laboratorio;
    private Integer cantidad;
    private Double precio;

    //constructor c id
    public Medicamento(Integer id, Integer codigoNumerico, String nombre, String laboratorio, Integer cantidad, Double precio) {
        this.id = id;
        this.codigoNumerico = codigoNumerico;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //constructor sin id
    public Medicamento(Integer codigoNumerico, String nombre, String laboratorio, Integer cantidad, Double precio) {
        this.codigoNumerico = codigoNumerico;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoNumerico() {
        return codigoNumerico;
    }

    public void setCodigoNumerico(Integer codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    //toString
    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", codigoNumerico=" + codigoNumerico +
                ", nombre='" + nombre + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
