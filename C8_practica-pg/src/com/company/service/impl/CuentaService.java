package com.company.service.impl;

import com.company.model.Cuenta;

public class CuentaService {

    public boolean getCuenta(String numeroID) {
        Boolean obtenerCuenta = Boolean.FALSE;
        if (numeroID != null) {
            System.out.println("obteniendo cuenta: " + numeroID);
            obtenerCuenta = Boolean.TRUE;
        }
        return obtenerCuenta;

    }






}
