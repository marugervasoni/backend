package com.company;

import java.util.logging.Logger;

public class Calculadora {

    //atributos
    //agregamos para usar logger
    private static final Logger logger = Logger.getLogger(String.valueOf(Calculadora.class));

    private int valor1;
    private int valor2;

    //constructor
    public Calculadora(int valor1, int valor2){
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    //metodos
    public int sumar(){
        return valor1 + valor2;
    }
    public int restar(){
        return valor1 - valor2;
    }
    public int multiplicar(){
        return valor1 * valor2;
    }
    public double dividir() {
        //logger de info
        logger.info("empezamos a dividir"+ valor1 +"/"+ valor2);
        double resultado;
        try {
            resultado = valor1 / valor2;
        } catch (Exception e) {
            //loggeamos el error
            logger.info("ocurrio un error al dividir: "+ e);
            return 0;
        }
        //otro logger tipo debug, de acuerdo a mi config
        logger.info("terminamos de dividir cone exito");
        return resultado;
    }
}
