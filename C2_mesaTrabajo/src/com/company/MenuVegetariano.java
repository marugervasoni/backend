package com.company;

public class MenuVegetariano extends Menu {
    private Boolean tieneEspecias;
    private Double precioEspecias = 0.01;
    private Double precioSalsas;
    private Integer cantidadSalsas;

    public MenuVegetariano(Integer precioBase, Boolean tieneEspecias, Double precioSalsas, Integer cantidadSalsas) {
        super(precioBase);
        this.tieneEspecias = tieneEspecias;
        this.precioSalsas = precioSalsas;
        this.cantidadSalsas = cantidadSalsas;
    }

    public Boolean getTieneEspecias() {
        return tieneEspecias;
    }

    public Double getPrecioEspecias() {
        return precioEspecias;
    }

    public Double getPrecioSalsas() {
        return precioSalsas;
    }

    public Integer getCantidadSalsas() {
        return cantidadSalsas;
    }
}



