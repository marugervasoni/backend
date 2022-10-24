package com.company;

import java.io.*;
import java.util.ArrayList;

public class ManejoDeArchivos {

    static ArrayList<Contacto> contactos = new ArrayList<>();

        public static void guardarArchivos(){
            try {
                FileOutputStream fos = new FileOutputStream("contactos.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(contactos);

                oos.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void recuperarObjetos(){
            try {
                FileInputStream fis = new FileInputStream("contactos.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Contacto> misContactos;

                System.out.println("Mis contactos:");
                System.out.println("------------------------------------");
                misContactos = (ArrayList<Contacto>) ois.readObject();

                for (Contacto c : misContactos){
                    System.out.println("- "+c);
                }

                ois.close();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
            }
        }
}


