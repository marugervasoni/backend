package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    //test nombre correcto
    @Test
    public  void siElNombreEsCorrecto(){}

    //test mayoria de edad
    @Test
    public void siEsMayorDeEdad(){
        Persona persona1 = new Persona("Maria","Gervasoni","jffldj@mail.com",26);
        Persona persona2 = new Persona("Azul", "Suarez","sjkfjjkj@gmail.com",1);

        boolean esMayor1 = persona1.esMayor();
        boolean esMayor2 = persona2.esMayor();

        assertEquals(true,persona1.esMayor());
        assertFalse(esMayor2);
    } //funciona el test


}