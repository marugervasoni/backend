package com.company.model;

import java.util.Date;

public class TarjetaDebito extends Tarjeta{

    private Double saldoDisponible =0.0;

    public TarjetaDebito(String numsFrente, String codSeguridad, Date fechaExpiracion, Double saldoDisponible) {
        super(numsFrente, codSeguridad, fechaExpiracion);
        this.saldoDisponible = saldoDisponible;
    }


    public Double getSaldoDisponible() {
        return saldoDisponible;
    }
}
