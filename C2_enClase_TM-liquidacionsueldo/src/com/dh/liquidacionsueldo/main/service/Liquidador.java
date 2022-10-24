package com.dh.liquidacionsueldo.main.service;

import com.dh.liquidacionsueldo.main.model.Empleado;

public abstract class Liquidador {

    public String liquidarSueldo(Empleado empleado) {
        //Calcular
        int sueldo = calcularSueldo(empleado);

        //Imprimir
        imprimirReciboDeSueldo(sueldo);

        //Consignar
        depositarSueldo(empleado);

        return ""; //TODO: Se debería armar un mensaje acorde
    }

    protected abstract int calcularSueldo(Empleado empleado); //Template method

    protected abstract void imprimirReciboDeSueldo(int sueldo); //Template method

    public String depositarSueldo(Empleado empleado){
        return "Sueldo depositado en la cuenta " + empleado.getNumeroDeCuenta();
    }
}
