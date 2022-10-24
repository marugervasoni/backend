package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ValidadorPago validaroPagoCredito = new ValidadorPagoCredito();
        ValidadorPago validaroPagodDebito = new ValidadorPagoDebito();

        validaroPagoCredito.procesarPago();
        validaroPagodDebito.procesarPago();

    }
}
