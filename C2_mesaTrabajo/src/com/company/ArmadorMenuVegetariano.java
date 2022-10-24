package com.company;

public class ArmadorMenuVegetariano extends Armador {

    @Override
    protected String armarPaquete() {
        return "Armando menu vegetariano. ";
    }


    @Override
    protected String calcularCosto(Menu menu) {
        MenuVegetariano menuV = (MenuVegetariano) menu;
        Double precioFinal = menuV.getPrecioBase() + (menuV.getPrecioSalsas() * menuV.getCantidadSalsas());
        if (menuV.getTieneEspecias()){
            precioFinal += menuV.getPrecioBase() * menuV.getPrecioEspecias();
        }
        return "El precio del menu es: $" + precioFinal;

    }
}

