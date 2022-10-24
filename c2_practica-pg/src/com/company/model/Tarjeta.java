package com.company.model;

import java.util.Date;

public abstract class Tarjeta {

    private String numsFrente;
    private String codSeguridad;
    private Date FechaExpiracion;


    public Tarjeta(String numsFrente, String codSeguridad, Date fechaExpiracion) {
        this.numsFrente = numsFrente;
        this.codSeguridad = codSeguridad;
        FechaExpiracion = new Date(123, 5, 30);
    }

    public Date getFechaExpiracion() {
        return FechaExpiracion;
    }
}
