package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GestorTest {

    @Test
    public void deberiaAdmitirSoloLasPersonasQueCumplenConElCriterio(){

        //DADOS
            //gestor administrará la coleccion de personas
        Gestor sujetoDePrueba = new Gestor();
            //1) agregamos personas c su nombre; 2) agrego edad
        Persona p1 = new Persona("Juan",18);
        Persona p2 = new Persona("Pedro",17);
        Persona p3 = new Persona("Ana",22);
        Persona p4 = new Persona("Luz",14);
        Persona p5 = new Persona("Julian",32);

            //3)agregamos mas personas pero con nombres raros
        Persona p6 = new Persona("N1c0las",18);
        Persona p7 = new Persona("Tomas",19);
        Persona p8 = new Persona("3steban",22);
        Persona p9 = new Persona("Carlos\sV.",14);
        Persona p10 = new Persona("Francisco\sll",32);

        //CUANDO
            //sujetoDePrueba necesita un metodo para agregar personas
        sujetoDePrueba.agregar(p1);
        sujetoDePrueba.agregar(p2);
        sujetoDePrueba.agregar(p3);
        sujetoDePrueba.agregar(p4);
        sujetoDePrueba.agregar(p5);
            //agrego las nuevas personas
        sujetoDePrueba.agregar(p6);
        sujetoDePrueba.agregar(p7);
        sujetoDePrueba.agregar(p8);
        sujetoDePrueba.agregar(p9);
        sujetoDePrueba.agregar(p10);

        //ENTONCES
            //pedimos lista de personas (debe ser de 2) con metodo getLista
        Assertions.assertTrue(sujetoDePrueba.getListaDePersonas().size() == 2);

    }
}