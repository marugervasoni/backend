package com.dh.liquidacionsueldo.main.service.impl;

import com.dh.liquidacionsueldo.main.model.Empleado;
import com.dh.liquidacionsueldo.main.model.EmpleadoEfectivo;
import com.dh.liquidacionsueldo.main.service.Liquidador;

public class LiquidadorEmpleadoEfectivo extends Liquidador {

    @Override
    protected int calcularSueldo(Empleado empleado) {
        int sueldo = 0;
        EmpleadoEfectivo e = (EmpleadoEfectivo) empleado;

        sueldo = e.getSueldoBase() + e.getBonos() - e.getDescuentos();

        return sueldo;
    }

    @Override
    protected void imprimirReciboDeSueldo(int sueldo) {
        System.out.println("Se ha generado la impresión física del recibo de sueldo por valor de " + sueldo);
    }
}
