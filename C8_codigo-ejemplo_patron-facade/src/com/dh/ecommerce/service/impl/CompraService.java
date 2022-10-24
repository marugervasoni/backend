package com.dh.ecommerce.service.impl;

import com.dh.ecommerce.model.Direccion;
import com.dh.ecommerce.model.Producto;
import com.dh.ecommerce.model.Tarjeta;
import com.dh.ecommerce.service.ICompraService;

import java.util.Arrays;

//2) creamos nuestra clase FACADE que implementara una interface:
public class CompraService implements ICompraService {

    //atributos
    private AlmacenService almacenService;
    private PagoService pagoService;
    private EnvioService envioService;

    //constructor
    public CompraService(AlmacenService almacenService, PagoService pagoService, EnvioService envioService) {
        this.almacenService = almacenService;
        this.pagoService = pagoService;
        this.envioService = envioService;
    }

    //metodo que implementamos de la interface y lo sobreescribimos
    @Override
    public void procesarCompra(String productoId, Integer cantidad, Tarjeta tarjeta, Direccion direccion) {
        //producto = lo buscamos en servicio A (c atribs)
        Producto producto = almacenService.buscarProducto(productoId,cantidad);
        //si esta el producto:
        if(producto != null){
            //Si tenemos el producto y si procesamos el pago
           if(pagoService.procesarPago(tarjeta,String.valueOf(producto.getValor() * cantidad))){
               //procesamos el envio
               envioService.procesarEnvio(Arrays.asList(producto),direccion);
           }

        }
    }
}











