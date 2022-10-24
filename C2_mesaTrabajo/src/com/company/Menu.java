package com.company;

public abstract class Menu {
    private Integer precioBase;

    public Menu(Integer precioBase) {
        this.precioBase = precioBase;
    }

    public Integer getPrecioBase() {
        return this.precioBase;
    }
}
