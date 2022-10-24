package com.clinica.integrador2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OdontologoDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    public OdontologoDTO() {
    }

    public OdontologoDTO(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
