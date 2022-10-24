package com.clinica.integrador2.dto;

import com.clinica.integrador2.dto.OdontologoDTO;
import com.clinica.integrador2.dto.PacienteDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class TurnoDTO {

    private Integer id;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;
    private LocalDate date;
}
