package com.company.entity;

public class Medicamento {

    //atributos
    private Integer codigoNumerico;
    private String nombre;
    private String laboratorioProductor;
    private Integer cantidad;
    private Double precio;
    private Long id;

    //getters y setters
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

    public String getLaboratorioProductor() {
        return laboratorioProductor;
    }

    public void setLaboratorioProductor(String laboratorioProductor) {
        this.laboratorioProductor = laboratorioProductor;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
