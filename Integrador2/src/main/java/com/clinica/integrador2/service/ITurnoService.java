package com.clinica.integrador2.service;

import com.clinica.integrador2.dto.TurnoDTO;
import com.clinica.integrador2.exception.ResourceNotFoundException;

import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDTO turnoDTO) throws Exception;
    TurnoDTO buscarTurno(Integer id);
    void modificarTurno(TurnoDTO turnoDTO) throws ResourceNotFoundException;
    void eliminarTurno(Integer id) throws ResourceNotFoundException;
    Set<TurnoDTO> buscarTodos();
}
