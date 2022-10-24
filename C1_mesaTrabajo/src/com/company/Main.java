package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Circulo circ = new Circulo(14.0);


        FiguraGeometrica figura = new FiguraGeometrica(Circulo circ);
        System.out.println(figura.calcularArea(String.valueOf(circ)));


    }
}
