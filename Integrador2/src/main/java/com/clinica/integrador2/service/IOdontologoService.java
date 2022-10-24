package com.clinica.integrador2.service;

import com.clinica.integrador2.dto.OdontologoDTO;
import com.clinica.integrador2.exception.ResourceNotFoundException;
import com.clinica.integrador2.exception.BadRequestException;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException;
    OdontologoDTO buscarOdontologo(Integer id);
    void modificarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundException;
    void eliminarOdontologo(Integer id) throws ResourceNotFoundException;
    Set<OdontologoDTO> buscarTodos();
}
