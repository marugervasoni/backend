package com.company;

import com.company.model.Tarjeta;

import java.util.Date;

public abstract class ValidadorPago {

    //template method
    public void procesarPago() {
        autorizar();
        validarFecha();
    }

    protected abstract void autorizar();

    private void validarFecha(){ //no sale, llora
        System.out.println("La fecha de expiracion es posterior a la fecha actual");

    }
}
