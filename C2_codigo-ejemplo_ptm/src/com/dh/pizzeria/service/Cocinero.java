package com.dh.pizzeria.service;

//mi clase abstracta que tendra el template method
public abstract class Cocinero {

    //estructura template method
    public void hacerPizza(){
        prepararmasa();
        preCocinarMasa();
        prepararIngredientes();
        agregarIngredientes();
        cocinarPizza();
        empaquetarPizza();
    }

    //de mi estructura declaro abstractas aquellos metodos a implementar por las
    //subclases (clases concretas) y las demás, ya las puedo definir.
        //abstractas
    protected abstract void prepararIngredientes();
    protected abstract void  agregarIngredientes();
        //ya definidas (no abstractas)
    private void prepararmasa(){
        System.out.println("Preparando masa..");
    }
    private void preCocinarMasa(){
        System.out.println("Pre cocinando masa..");
    }
    private void cocinarPizza(){
        System.out.println("Enviando al horno la pizza");
    }
    private void empaquetarPizza(){
        System.out.println("Empaquetando pizza");
    }
}
