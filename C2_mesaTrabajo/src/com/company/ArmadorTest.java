package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArmadorTest {

    @Test
    public void deberiaCalcularUnPrecioParaUnMenuEstandar(){
        //DADO
        Armador sujetoDePrueba = new ArmadorMenuClasico();
        Menu menu = new MenuEstandar(200);
        String resultadoEsperado = "Armando menu estandar. El precio del menu es: $200";
        //CUANDO
        String resultado = sujetoDePrueba.prepararMenu(menu);
        //ENTONCES
        Assertions.assertEquals(resultadoEsperado, resultado);
    }
    @Test
    public void deberiaCalcularunPrecioParaUnMenuInfantil(){
        //DADO
        Armador sujetoDePrueba = new ArmadorMenuInfantil();
        Menu menu = new MenuInfantil(200,  32);
        String resultadoEsperado = "Armando menu infantil. El precio del menu es: $296";
        //CUANDO
        String resultado = sujetoDePrueba.prepararMenu(menu);
        //ENTONCES
        Assertions.assertEquals(resultadoEsperado, resultado);
    }
    @Test
    public void deberiaCalcularUnPrecioParaUnMenuVegetariano(){
        //DADO
        Armador sujetoDePrueba = new ArmadorMenuVegetariano();
        Menu menu = new MenuVegetariano(200, true, 2.0, 2);
        String resultadoEsperado = "Armando menu vegetariano. El precio del menu es: $206.0" ;
        //CUANDO
        String resultado = sujetoDePrueba.prepararMenu(menu);
        //ENTONCES
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

}

