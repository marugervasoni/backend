package com.dh.flyweight.factory;


import com.dh.flyweight.model.Computador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FábricaDeComputadoresTest {

    @Test
    void armarComputador_deberíaReutilizarLaMismaInstancia() throws Exception {
        //DADO
        FábricaDeComputadores sujetoDePrueba = new FábricaDeComputadores();
        Computador primerComputador;
        Computador segundoComputador;


        //CUANDO
        primerComputador = sujetoDePrueba.armarComputador(FábricaDeComputadores.MAC);
        segundoComputador = sujetoDePrueba.armarComputador(FábricaDeComputadores.MAC);

        //ENTONCES
        Assertions.assertTrue(primerComputador == segundoComputador);
    }

    @Test
    void armarComputador_deberíaReutilizarLaMismaInstancia_B() throws Exception {
        //DADO
        FábricaDeComputadores sujetoDePrueba = new FábricaDeComputadores();
        List<Computador> computadores = new ArrayList<>(1000);

        //CUANDO
        for(int i= 0; i < 1000; i++){
            computadores.add(sujetoDePrueba.armarComputador(FábricaDeComputadores.MAC));
        }

        //ENTONCES
        Assertions.assertTrue(computadores.get(0) == computadores.get(999));
    }
}