package com.company;

public class ValidadorPagoDebito extends ValidadorPago{

    @Override
    protected void autorizar() {
        System.out.println("autorizo si saldo cuenta a debitar es suficiente");
    }
}
