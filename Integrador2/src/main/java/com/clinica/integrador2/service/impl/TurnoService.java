package com.clinica.integrador2.service.impl;

import com.clinica.integrador2.dto.TurnoDTO;
import com.clinica.integrador2.entity.Turno;
import com.clinica.integrador2.exception.InvalidDateException;
import com.clinica.integrador2.exception.ResourceNotFoundException;
import com.clinica.integrador2.exception.BadRequestException;
import com.clinica.integrador2.repository.IOdontologoRepository;
import com.clinica.integrador2.repository.IPacienteRepository;
import com.clinica.integrador2.repository.ITurnoRepository;
import com.clinica.integrador2.service.IOdontologoService;
import com.clinica.integrador2.service.IPacienteService;
import com.clinica.integrador2.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IOdontologoService odontologoService;

    @Autowired
    ObjectMapper mapper;

    private static final Logger logger = Logger.getLogger(String.valueOf(TurnoService.class));

    @Override
    public void crearTurno(TurnoDTO turnoDTO)  throws Exception{
        if (turnoDTO.getPaciente() == null){
            throw new BadRequestException("Debe ingresar un paciente");
        }
        else if (turnoDTO.getOdontologo() == null){
            throw new BadRequestException("Debe ingresar un odontologo");
        }
        else if (turnoDTO.getDate() == null) {
                throw new BadRequestException("Debe ingresar una fecha.");
        }
        else if (turnoDTO.getDate().isBefore(LocalDate.now())){
            throw new InvalidDateException("Debe ingresar una fecha válida");
        }
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        logger.info("Creando turno para el día: "+ turnoDTO.getDate()+".");
        turnoRepository.save(turno);
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
    public void modificarTurno(TurnoDTO turnoDTO) throws ResourceNotFoundException{
        if (buscarTurno(turnoDTO.getId()) == null)
            throw new ResourceNotFoundException("no existe un turno con el id "+turnoDTO.getId());
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        logger.info("Modificando turno de fecha: "+ turnoDTO.getDate()+".");
        turnoRepository.save(turno);
    }
    @Override
    public void eliminarTurno(Integer id)  throws ResourceNotFoundException{
        if (buscarTurno(id) == null)
            throw new ResourceNotFoundException("no existe un turno con el id "+id);
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
