package com.clinica.integrador2.service;

import com.clinica.integrador2.dto.TurnoDTO;
import com.clinica.integrador2.entity.Turno;
import com.clinica.integrador2.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private static final Logger logger = Logger.getLogger(String.valueOf(TurnoService.class));

    private void guardarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        logger.info("Creando turno para el día: "+ turnoDTO.getDate()+".");
        guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO buscarTurno(Integer id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if (turno.isPresent())
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);

        logger.info("Buscando turno id n°: "+id+".");
        return turnoDTO;
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        logger.info("Modificando turno de fecha: "+ turnoDTO.getDate()+".");
        guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Integer id) {
        logger.info("Eliminando turno id n°: "+id+".");
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for(Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        logger.info("Buscando todos los turnos");
        return turnosDTO;
    }
}
