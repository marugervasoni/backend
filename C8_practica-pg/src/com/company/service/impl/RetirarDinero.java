package com.company.service.impl;

import com.company.model.Cuenta;
import com.company.service.IRetirarDinero;

public class RetirarDinero implements IRetirarDinero {

    private AutenticationService autenticationService;
    private CuentaService cuentaService;
    private CajaService cajaService;

    public RetirarDinero(AutenticationService autenticationService, CuentaService cuentaService, CajaService cajaService) {
        this.autenticationService = autenticationService;
        this.cuentaService = cuentaService;
        this.cajaService = cajaService;
    }

    @Override
    public void retirarDinero(String numeroID, String contrasena, Double saldoARetirar) {
        //si cuenta autenticamos
        Cuenta cuenta = autenticationService.validarUsuarioYContrasena(numeroID, contrasena);
        //si hay cuenta autenticada traemos su informacion
        if (cuenta != null) {
            //si traemos su informacion, retiramos dinero
            if(cuentaService.getCuenta(numeroID)){
                if (cuenta.getSaldoActual() >= cuenta.getSaldoARetirar())
                    cajaService.entregarDinero(saldoARetirar); //esto esta bien?

                }
            }
        }
    }


