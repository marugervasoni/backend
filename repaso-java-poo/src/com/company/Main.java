package com.company;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//
//        //STRING--------------------------------------------------------------------------------------
//        String nombre = "Maria";
//
//        String mayuscula = nombre.toUpperCase();
//        int cantidadLetras = nombre.length();
//        boolean booleano = nombre.equals(mayuscula);
//        char letraSegunIndice = nombre.charAt(0);
////        System.out.println(mayuscula);
////        System.out.println(cantidadLetras);
////        System.out.println(booleano);
////        System.out.println(letraSegunIndice);
//
//
//        //INTEGER--------------------------------------------------------------------------------------
//        Integer num1 = 2;
//        Integer num2 = 1;
//        //comparamos (.equals o .compareTo)
//        int comparar; //valor numerico vamos a retornar, no booleano
//
//        //si son iguales bien
////            if (num1.equals(num2))
////                System.out.println("son iguales");
////            else { //usamos numeros porque comparar es de valor enterno, no es booleano (aca v es 1 y F es -1)
////                comparar = num1.compareTo(num2);
////                if (comparar > 0)
////                    System.out.println("num1 es mayor que num2");
////                else
////                    System.out.println("num2 es mayor que num1");
//        //    }
//
//        //FECHA--------------------------------------------------------------------------------------
//        Date fecha = new Date();
////        System.out.println(fecha);
//
//        //SCANNER--------------------------------------------------------------------------------------
//        Scanner scanner = new Scanner(System.in); //instanciamos para las entradas
//
//        //creo variable nombre; pido por consola ingrese el nombre y lo guardo en mi variable nombre con nextline
//        String name;
//        //System.out.println("ingrese su nombre");
//        name = scanner.nextLine();
//
//        //creo variable edad; pido por consola ingrese edad y la guardo en mi variable edad con nextint
//        int edad;
//        //System.out.println("ingrese su edad");
//        edad = scanner.nextInt();
//
////        System.out.println(name);
////        System.out.println(edad);
//

        //FUNCIONES--------------------------------------------------------------------------------------

//        String mensaje = "hola";
//
//        void mostrarMensaje(String mensaje){
//            System.out.println(mensaje);
//        }

        //ARRAY--------------------------------------------------------------------------------------
//        String[] nombres = new String[2];//array con dos strings nada mas
//        nombres[0] = "Juan";
//        nombres[1] = "Pepe";
//
//        //recorrerlo
//        for (String nombre : nombres) {
//            System.out.println(nombre);
//        }

        //OBJETOS--------------------------------------------------------------------------------------
        //(clases)
        Perro perro = new Perro("Firu","caniche",true);
        System.out.println(perro.getRaza());
        perro.ladrar();

        perro.setRaza("caniche toy");
        System.out.println(perro.getRaza());

        Perro.cambiarCostoAlimento(200);
        System.out.println("costo total de alimento consumido por perro: $"+ perro.gastoAlimento(0.5));
    }
}