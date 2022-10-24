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
}
