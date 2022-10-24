package com.clinica.integrador2.service;

import com.clinica.integrador2.dto.PacienteDTO;
import com.clinica.integrador2.exception.ResourceNotFoundException;
import com.clinica.integrador2.exception.BadRequestException;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO) throws BadRequestException;
    PacienteDTO buscarPaciente(Integer id);
    void modificarPaciente (PacienteDTO pacienteDTO) throws ResourceNotFoundException;
    void eliminarPaciente(Integer id) throws ResourceNotFoundException;
    Set<PacienteDTO> buscarTodos();
}
