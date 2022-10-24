package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //1. creo mis paginas fav
        Pagina pag1 = new Pagina("www.digitalhouse.com","digital house");
        Pagina pag2 = new Pagina("www.google.com","google");
        Pagina pag3 = new Pagina("www.instagram.com","instagram");
        Pagina pag4 = new Pagina("www.kahoot.it","kahoot");

        //2. creo mi coleccion de paginas
        ArrayList<Pagina> paginasFavoritas = new ArrayList<>();

        //3. agrego mis paginas fav a la coleccion
        paginasFavoritas.add(pag1);
        paginasFavoritas.add(pag2);
        paginasFavoritas.add(pag3);
        paginasFavoritas.add(pag4);

        //4. archivo y objeto de salida
        try {
            FileOutputStream fileOut = new FileOutputStream("paginas.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            //grabo array
            objectOut.writeObject(paginasFavoritas);

            //close
            objectOut.close();

            //5. abro nuevamente el archivo para listar
                // archivo y objeto entrada
            FileInputStream fileIn = new FileInputStream("paginas.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ArrayList<Pagina> paginasFav;

                //imprimir
            System.out.println("Paginas favoritas");
            System.out.println("*************************************+");
            paginasFav = (ArrayList<Pagina>) objectIn.readObject();

            for (Pagina p : paginasFav){
                System.out.println("- "+p);
            }

                //close
            objectIn.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
