package com.dh.flyweight.factory;

import com.dh.flyweight.model.Computador;
import com.dh.flyweight.model.ComputadorMac;
import com.dh.flyweight.model.ComputadorWin;

public class FábricaDeComputadores {

    public static final String MAC = "mac";
    public static final String WIN = "win";
    private Computador compuMac;
    private Computador compuWin;

    public Computador armarComputador(String tipo) throws Exception {
        Computador resultado = null;

        if(MAC.equalsIgnoreCase(tipo)){
            if(compuMac == null){
                compuMac = new ComputadorMac();
            }
            resultado = compuMac;
        }else if(WIN.equalsIgnoreCase(tipo)){
            if(compuWin == null){
                compuWin = new ComputadorWin();
            }
            resultado = compuWin;
        }else{
            throw new Exception("Tipo de computador no soportado");
        }

        return resultado;
    }

}
