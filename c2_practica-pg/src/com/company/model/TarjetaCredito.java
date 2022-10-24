package com.company.model;

import java.util.Date;

public class TarjetaCredito extends Tarjeta{

    private Double limite = 0.0;
    private Double saldoUtilizado =0.0;

    public TarjetaCredito(String numsFrente, String codSeguridad, Date fechaExpiracion, Double limite, Double saldoUtilizado) {
        super(numsFrente, codSeguridad, fechaExpiracion);
        this.limite = limite;
        this.saldoUtilizado = saldoUtilizado;
    }

    public Double getLimite() {
        return limite;
    }

    public Double getSaldoUtilizado() {
        return saldoUtilizado;
    }
}


