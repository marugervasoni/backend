package com.company;

import java.io.*;
import java.util.ArrayList;

//2)
public class Paseo {

    //debe ir dentro de main para que sea ejecutable
    public static void main(String[] args) { //throws FileNotFoundException

    //1) creo perros
    Perro p1 = new Perro("Fido","ovejero",3,"dir1");
    Perro p2 = new Perro("Tobi","cocker",1,"dir2");
    Perro p3 = new Perro("Bobby","Dogo",7,"dir3");
    Perro p4 = new Perro("Smith","maltez",4,"dir4");
    //2) creo arreglo

    ArrayList<Perro> lunes = new ArrayList<Perro>();
    ArrayList<Perro> martes = new ArrayList<Perro>();
    ArrayList<Perro> miercoles = new ArrayList<Perro>();
    ArrayList<Perro> jueves = new ArrayList<Perro>();
    ArrayList<Perro> viernes = new ArrayList<Perro>();

    lunes.add(p1);
    miercoles.add(p1);
    viernes.add(p1);

    lunes.add(p2);
    martes.add(p2);
    miercoles.add(p2);
    jueves.add(p2);

    miercoles.add(p3);
    jueves.add(p3);
    viernes.add(p3);

    lunes.add(p4);
    martes.add(p4);
    miercoles.add(p4);
    jueves.add(p4);
    viernes.add(p4);

    //grabar cada array  y luego imprimir (implementar interfaz serialiable)
        // --> lo hago dentro de un try catch:
        try {
            //creo 1 archivo de salida
            FileOutputStream fil = new FileOutputStream("perros.dat");
            //creo mi objeto de entrada
            ObjectOutputStream archi = new ObjectOutputStream(fil);

            //grabo arrays
            archi.writeObject(lunes);
            archi.writeObject(martes);
            archi.writeObject(miercoles);
            archi.writeObject(jueves);
            archi.writeObject(viernes);

            //todos grabados hago un close para cerrar el archivo y proceso
            archi.close();

            //lo vuelvo a abrir luego de cerrado pero para listarlo:
                //creo mi metodo para listarlo
            FileInputStream filIn = new FileInputStream("perros.dat");
            ObjectInputStream archiIn = new ObjectInputStream(filIn);

            ArrayList<Perro> dia;

            for (int i=0; i<5; i++){
                System.out.println("Dia: "+ (i+1));
                System.out.println("===================");
                dia = (ArrayList<Perro>) archiIn.readObject(); //debo castear esto a array de perro
                //recorro para imprimir: recibo un perro(p) del array dia que es de perros
                for (Perro p : dia){
                    System.out.println(p);
                }
            }
            //cierro la impresion
            archiIn.close();

        } catch (FileNotFoundException e) { //del FileOutput
            e.printStackTrace();
        } catch (IOException e) { //del objectOutput
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
