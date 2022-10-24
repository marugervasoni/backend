package com.dh.pizzeria.service.impl;

import com.dh.pizzeria.service.Cocinero;

//la subclase extiende la clase concreta
public class CocineroNoVeggie extends Cocinero {

    //sobreescribo los metodos abstractos de mi template
    @Override
    protected void prepararIngredientes() {
        System.out.println("Preparando queso y fetas de jamon,");
    }

    @Override
    protected void agregarIngredientes() {
        System.out.println("Agregando los ingredientes");
    }
}
