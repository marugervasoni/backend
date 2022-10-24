package com.dh.liquidacionsueldo.main.service.impl;

import com.dh.liquidacionsueldo.main.model.Empleado;
import com.dh.liquidacionsueldo.main.model.EmpleadoContratado;
import com.dh.liquidacionsueldo.main.model.EmpleadoEfectivo;
import com.dh.liquidacionsueldo.main.service.Liquidador;

public class LiquidadorEmpleadoContratado extends Liquidador {

    @Override
    protected int calcularSueldo(Empleado empleado) {
        int sueldo = 0;
        EmpleadoContratado e = (EmpleadoContratado) empleado;

        sueldo = e.getValorHora() * e.getHorasTrabajadas();

        return sueldo;
    }

    @Override
    protected void imprimirReciboDeSueldo(int sueldo) {
        System.out.println("Se ha generado la impresión digital del recibo de sueldo por valor de " + sueldo);
    }
}
