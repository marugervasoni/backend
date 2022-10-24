package com.dh.ecommerce.service;

import com.dh.ecommerce.model.Direccion;
import com.dh.ecommerce.model.Tarjeta;

//1) Creamos una interface
public interface ICompraService {

    //metodo a implementar por el facade
    public void procesarCompra(String productoId, Integer cantidad, Tarjeta tarjeta, Direccion direccion);
}
