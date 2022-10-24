package com.company.model;

public class Cuenta {

    private String numeroID;
    private String contrasena;
    private Double saldoActual;
    private Double saldoARetirar;

    public Cuenta(String numID, String contrasena, Double saldoActual, Double saldoARetirar) {
        this.numeroID = numID;
        this.contrasena = contrasena;
        this.saldoActual = saldoActual;
        this.saldoARetirar = saldoARetirar;
    }

    public String getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(String numID) {
        this.numeroID = numID;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Double getSaldoARetirar() {
        return saldoARetirar;
    }

    public void setSaldoARetirar(Double saldoARetirar) {
        this.saldoARetirar = saldoARetirar;
    }
}
