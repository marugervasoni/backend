package com.company.factory;

import static org.junit.jupiter.api.Assertions.*;

import com.company.model.Arbol;
import org.junit.jupiter.api.Test;

class ArbolFactoryTest {

    @Test
    void crearArbol_deberiaReutilizarLaMismaInstancia() {
        //DADO
        ArbolFactory sujetoDePrueba = new ArbolFactory();
        Arbol arbolOrnamental;
        Arbol arbolFloral;
        Arbol arbolFrutal;

        //CUANDO
        arbolOrnamental = sujetoDePrueba.crearArbol(ArbolFactory.ornamental);
        arbolFloral = sujetoDePrueba.crearArbol(ArbolFactory.floral);
        arbolFrutal = sujetoDePrueba.crearArbol(ArbolFactory.frutal);

        //ENTONCES
    }

}

    //@Test
    //void plantarArboles_deberíaPlantarYMostrarArbolesEnBosque();
