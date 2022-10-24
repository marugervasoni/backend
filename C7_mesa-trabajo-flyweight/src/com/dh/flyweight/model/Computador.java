package com.dh.flyweight.model;

public class Computador {
    private int discoDuro;
    private int ram;

    public Computador(int discoDuro, int ram) {
        this.setDiscoDuro(discoDuro);
        this.ram = ram;
    }


    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
