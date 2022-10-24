package com.clinica.integrador2.service;

import com.clinica.integrador2.entity.Odontologo;
import com.clinica.integrador2.dto.OdontologoDTO;
import com.clinica.integrador2.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class OdontologoService  implements IOdontologoService{

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private static final Logger logger = Logger.getLogger(String.valueOf(PacienteService.class));

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        logger.info("Guardando odontologo, matricula n°: "+odontologoDTO.getMatricula()+".");
        odontologoRepository.save(odontologo);
    }
    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
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
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        logger.info("Modificando odontologo: "+odontologoDTO.getMatricula()+".");
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Integer id) {
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
