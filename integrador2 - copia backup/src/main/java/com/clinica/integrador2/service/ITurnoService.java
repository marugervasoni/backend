package com.clinica.integrador2.service;

import com.clinica.integrador2.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDTO turnoDTO); //este no debería estar
    TurnoDTO buscarTurno(Integer id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Integer id);
    Set<TurnoDTO> buscarTodos(); //este no deberia es
}
