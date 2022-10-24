package com.company;

public class ArmadorMenuClasico extends Armador {

    @Override
    protected String armarPaquete() {
        return "Armando menu clasico. ";
    }

    @Override
    protected String calcularCosto(Menu menu) {
        return "El precio del menu es: $" + menu.getPrecioBase();

    }
}
