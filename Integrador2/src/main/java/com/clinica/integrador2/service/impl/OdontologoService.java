package com.clinica.integrador2.service.impl;

import com.clinica.integrador2.entity.Odontologo;
import com.clinica.integrador2.dto.OdontologoDTO;
import com.clinica.integrador2.exception.ResourceNotFoundException;
import com.clinica.integrador2.exception.BadRequestException;
import com.clinica.integrador2.repository.IOdontologoRepository;
import com.clinica.integrador2.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class OdontologoService  implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private static final Logger logger = Logger.getLogger(String.valueOf(PacienteService.class));

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        if (odontologoDTO.getNombre() == null || odontologoDTO.getApellido() == null || odontologoDTO.getMatricula() == null) {
            throw new BadRequestException("Debe ingresar todos los datos del odontologo");
        }
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        logger.info("Guardando odontologo, matricula n°: "+odontologoDTO.getMatricula()+".");
        odontologoRepository.save(odontologo);
    }
    @Override
    public OdontologoDTO buscarOdontologo(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if (odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        logger.info("Buscando odontologo id n°: "+id+".");
        return odontologoDTO;
    }
    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        if (buscarOdontologo(odontologoDTO.getId()) == null)
            throw new ResourceNotFoundException("no existe un odontologo con el id "+odontologoDTO.getId());
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        logger.info("Modificando odontologo: "+odontologoDTO.getMatricula()+".");
        odontologoRepository.save(odontologo);
    }
    @Override
    public void eliminarOdontologo(Integer id) throws ResourceNotFoundException {
        if (buscarOdontologo(id) == null)
            throw new ResourceNotFoundException("no existe un odontologo con el id "+id);
        logger.info("Eliminando odontologo id n°: "+id+".");
        odontologoRepository.deleteById(id);
    }
    @Override
    public Set<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo: odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        logger.info("Buscando todos los odontologos.");
        return odontologosDTO;
    }
}
