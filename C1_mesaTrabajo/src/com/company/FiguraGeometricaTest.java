package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiguraGeometricaTest {

    @Test
    public void DeberiacCalcularElAreaDeUnCirculo(){
        //DADOS
        FiguraGeometrica sujetoDePrueba = new FiguraGeometrica();
        Circulo circulo1 = new Circulo(12.0);

        //CUANDO
        sujetoDePrueba.calcularArea(String.valueOf(circulo1));

        //ENTONCES
        //Assertions.assertTrue(sujetoDePrueba.calcularArea().equals(System.out.println("el area de: " + tipoFigura + " es: " + valorArea + " unidades.");


    }


}