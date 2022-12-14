package com.dh.liquidacionsueldo.test;

import com.dh.liquidacionsueldo.main.model.Empleado;
import com.dh.liquidacionsueldo.main.model.EmpleadoContratado;
import com.dh.liquidacionsueldo.main.model.EmpleadoEfectivo;
import com.dh.liquidacionsueldo.main.service.Liquidador;
import com.dh.liquidacionsueldo.main.service.impl.LiquidadorEmpleadoContratado;
import com.dh.liquidacionsueldo.main.service.impl.LiquidadorEmpleadoEfectivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LiquidadorTest {

    @Test
    public void deberiaEmitirUnDocumentoDigitalParaUnEmpleadoEfectivo(){
        //DADO
        Liquidador sujetoDePrueba = new LiquidadorEmpleadoEfectivo();
        Empleado empleado = new EmpleadoEfectivo("Martín", "Martini", "001A", 400, 60, 40);
        String resultadoEsperado = "Liquidación generada. Saldo a liquidar: 420";

        //CUANDO
        String resultado = sujetoDePrueba.liquidarSueldo(empleado);

        //ENTONCES
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void deberiaEmitirUnDocumentoImpresoParaUnEmpleadoContratado(){
        //DADO
        Liquidador sujetoDePrueba = new LiquidadorEmpleadoContratado();
        Empleado empleado = new EmpleadoContratado("Pompilia", "Pompini", "001B", 120, 7);
        String restultadoEsperado = "Liquidación generada. Saldo a liquidar: 840";

        //CUANDO
        String resultado = sujetoDePrueba.liquidarSueldo(empleado);

        //ENTONCES
        Assertions.assertEquals(restultadoEsperado, resultado);
    }

    @Test
    //TODO: Si has llegado a este punto, notarás que este caso de prueba fallará. ¿Qué cambios implementarias para que el liquidador pueda pasar los 3 casos de prueba creados?
    public void deberiaRetornarUnMensajeDeErrorCuandoNoSePuedeLiquidarUnEmpleado(){
        //DADO
        Liquidador sujetoDePrueba = new LiquidadorEmpleadoEfectivo();
        Empleado empleado = new EmpleadoContratado("Pompilia", "Pompini", "001B", 120, 7);
        String restultadoEsperado = "La liquidación no pudo ser calculada.";

        //CUANDO
        String resultado = sujetoDePrueba.liquidarSueldo(empleado);

        //ENTONCES
        Assertions.assertEquals(restultadoEsperado, resultado);
    }
}
