package com.company;

import java.util.ArrayList;
import java.util.Collection;

public class Gestor {

        private ArrayList<Persona> listaDePersonas = new ArrayList<>();

        public void agregar(Persona p){
            if (p.getNombre().length() >= 5 && p.getEdad() > 18 && p.getNombre().matches("[a-zA-Z]*")){
                this.listaDePersonas.add(p);
            }
        }

        public ArrayList<Persona> getListadoDePersonas(){
            return this.listaDePersonas;
        }
}
