package com.company;

import java.util.ArrayList;

import static com.company.ManejoDeArchivos.contactos;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Contacto cont1 = new Contacto("Facu","Smith","facu.s@gmail.com","12345678");
        Contacto cont2 = new Contacto("Vale","Gerv","valegerv@gmail.com","12345778");
        Contacto cont3 = new Contacto("Lu","Gervasoni","luchidelpi.s@gmail.com","12345658");
        Contacto cont4 = new Contacto("Gi","Parker","gigi.park@gmail.com","12345698");

        ManejoDeArchivos.contactos.add(cont1);
        ManejoDeArchivos.contactos.add(cont2);
        ManejoDeArchivos.contactos.add(cont3);
        ManejoDeArchivos.contactos.add(cont4);

        ManejoDeArchivos.guardarArchivos();
        ManejoDeArchivos.recuperarObjetos();

    }
}
