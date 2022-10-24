package com.clinica.integrador2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DomicilioDTO {

    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

//    public DomicilioDTO() {
//    }
//
//    public DomicilioDTO(String calle, String numero, String localidad, String provincia) {
//        this.calle = calle;
//        this.numero = numero;
//        this.localidad = localidad;
//        this.provincia = provincia;
//    }
}
