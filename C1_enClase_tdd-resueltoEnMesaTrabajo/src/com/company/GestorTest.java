package com.company;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorTest {

    @Test
    public void deberiaAdmitirSoloPersonasQueCumplenConElCriterio(){
        //DADOS
        Gestor sujetoDePrueba = new Gestor();
        Persona p1 = new Persona("Juan",18);
        Persona p2 = new Persona("Pedro",17);
        Persona p3 = new Persona("Ana",14);
        Persona p4 = new Persona("Luz",22);
        Persona p5 = new Persona("Julian",32);

        Persona p6 = new Persona("N1c0las",18);
        Persona p7 = new Persona("Tomas",19);
        Persona p8 = new Persona("3steban",14);
        Persona p9 = new Persona("Carlos\\sV",22);
        Persona p10 = new Persona("Francisco\\sII)",32);


        //CUANDO
        sujetoDePrueba.agregar(p1);
        sujetoDePrueba.agregar(p2);
        sujetoDePrueba.agregar(p3);
        sujetoDePrueba.agregar(p4);
        sujetoDePrueba.agregar(p5);
        sujetoDePrueba.agregar(p6);
        sujetoDePrueba.agregar(p7);
        sujetoDePrueba.agregar(p8);
        sujetoDePrueba.agregar(p9);
        sujetoDePrueba.agregar(p10);


        //ENTONCES
        Assertions.assertTrue(sujetoDePrueba.getListadoDePersonas().size() == 2);

    }
}