package com.company;

import java.util.ArrayList;
import java.util.Collection;

public class Gestor {

    //cree lista de personas y la inicializo con new
    private ArrayList<Persona> ListaDePersonas = new ArrayList<>();

    //cree mi metodo agregar
    public void agregar(Persona p) {
        //valido y si true, agrego al listado:  1) cant letras nombre; 2) mayor edad; 3) solo letras.
        if(p.getNombre().length() >=5 && p.getEdad() > 18 && p.getNombre().matches("[a-zA-Z]*")){
            this.ListaDePersonas.add(p);
        }
    }

    //getter de listaPersonas
    public ArrayList<Persona> getListaDePersonas() {
        return this.ListaDePersonas;
    }
}
