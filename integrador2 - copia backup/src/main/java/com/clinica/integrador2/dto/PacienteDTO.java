package com.clinica.integrador2.dto;

import com.clinica.integrador2.dto.DomicilioDTO;
import com.clinica.integrador2.entity.Domicilio;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PacienteDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private DomicilioDTO domicilio;

//    public PacienteDTO() {
//    }
//
//    public PacienteDTO(String nombre, String apellido, String dni, DomicilioDTO domicilio) {
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.dni = dni;
//        this.domicilio = domicilio;
//    }
}
