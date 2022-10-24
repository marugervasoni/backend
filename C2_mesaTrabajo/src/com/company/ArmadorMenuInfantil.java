package com.company;

public class ArmadorMenuInfantil extends Armador {

    @Override
    protected String armarPaquete() {
        return "Armando menu infantil. ";
    }


    @Override
    protected String calcularCosto(Menu menu) {
        MenuInfantil menuI = (MenuInfantil) menu;
        Integer precioFinal = menu.getPrecioBase() + (menuI.getCantidadDeJuguetes() * menuI.getPrecioDeJuguete());
        return "El precio del menu es: $" + precioFinal;

    }
}

