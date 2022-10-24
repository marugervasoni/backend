package com.clinica.integrador2.service;

import com.clinica.integrador2.dto.PacienteDTO;
import com.clinica.integrador2.entity.Paciente;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO);
    //Paciente crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO buscarPaciente(Integer id);
    //Paciente modificarPaciente(PacienteDTO pacienteDTO);
    void modificarPaciente (PacienteDTO pacienteDTO);
    void eliminarPaciente(Integer id);
    Set<PacienteDTO> buscarTodos();
}
