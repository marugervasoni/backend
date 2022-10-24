package com.dh.ecommerce.service.impl;

import com.dh.ecommerce.model.Tarjeta;

//3 -B) subsistema para procesar pago
public class PagoService {


    public Boolean procesarPago(Tarjeta tarjeta,String montoACobrar){
        Boolean pagoRealizado = Boolean.FALSE;
        if(tarjeta != null && tarjeta.getNumerosFrente() != null && tarjeta.getCodSeguridad() != null)
            System.out.println("Procesando el pago por "+ montoACobrar);
            pagoRealizado = Boolean.TRUE;


        return pagoRealizado;


    }

}
