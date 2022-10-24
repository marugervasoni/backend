package com.company;

public class MenuInfantil extends Menu {
    private Integer precioDeJuguete = 3;
    private Integer cantidadDeJuguetes;

    public MenuInfantil(Integer precioBase, Integer cantidadDeJuguetes) {
        super(precioBase);
        this.cantidadDeJuguetes = cantidadDeJuguetes;
    }

    public Integer getPrecioDeJuguete() {
        return precioDeJuguete;
    }

    public Integer getCantidadDeJuguetes() {
        return cantidadDeJuguetes;
    }
}
