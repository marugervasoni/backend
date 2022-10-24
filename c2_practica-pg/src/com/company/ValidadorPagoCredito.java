package com.company;

public class ValidadorPagoCredito extends ValidadorPago{

    @Override
    protected void autorizar() {
        System.out.println("autorizo si el limite de la tarjeta no fue superado");
    }
}

