package com.dh.proxy.service.impl;

import com.dh.proxy.service.IConexionInternet;

//2) definimos el servicio que nos conecta a Internet
public class InternetService implements IConexionInternet {


    @Override
    public void conectarCon(String url) {
        System.out.println("Conectando con "+url);
    }
}
