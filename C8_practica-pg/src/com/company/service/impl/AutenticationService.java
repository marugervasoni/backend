package com.company.service.impl;

import com.company.model.Cuenta;

import java.util.List;

public class AutenticationService {

    private List<Cuenta> cuentas;

    public AutenticationService(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuenta validarUsuarioYContrasena(String numeroID, String contrasena) {
        Cuenta cuenta = null;
        for (Cuenta c : this.cuentas) {
            if (c.getNumeroID().equals(numeroID) && c.getContrasena().equals(contrasena)
                cuenta = c;
        }

        return cuenta;

        }
    }
}//marca error
