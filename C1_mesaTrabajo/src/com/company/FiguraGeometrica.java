package com.company;

import java.util.ArrayList;

import static java.lang.System.*;

public class FiguraGeometrica {

    private String tipoFigura;
    private Circulo circulo;
    private Cuadrado cuadrado;

//    private ArrayList<FiguraGeometrica> tipofiguras;= new ArrayList<>();


    public FiguraGeometrica() {

    }

    public String calcularArea(String tipoFigura) {
        Double valorArea = 0.0;
        Double valorDado = 0.0;
        String resultado;

        if (valorDado > 0.0) {

            if (tipoFigura.equals(circulo)) {
                valorDado = circulo.getRadio();
                valorArea = Math.PI * (valorDado * 2);
            } else if (tipoFigura.equals(cuadrado)) {
                valorDado = cuadrado.getLado();
                valorArea = valorDado * 2;
            }

            resultado = "el area de: " + tipoFigura + " es: " + valorArea + " unidades.";

        } else {
            resultado = "El valor del radio o lado debe ser mayor que cero.";
        }

        return resultado;
    }



}
