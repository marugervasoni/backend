package com.clinica.integrador2.service;

import com.clinica.integrador2.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarOdontologo(Integer id);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Integer id);
    Set<OdontologoDTO> buscarTodos();
}
