package com.company;


public abstract class Armador {


    public String prepararMenu(Menu menu){
        return armarPaquete() + calcularCosto(menu);
    }

    protected abstract String armarPaquete();
    protected abstract String calcularCosto(Menu menu);


}
