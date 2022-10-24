package com.clinica.integrador2.service.impl;

import com.clinica.integrador2.entity.Domicilio;
import com.clinica.integrador2.entity.Paciente;
import com.clinica.integrador2.dto.PacienteDTO;
import com.clinica.integrador2.exception.ResourceNotFoundException;
import com.clinica.integrador2.exception.BadRequestException;
import com.clinica.integrador2.repository.IDomicilioRepository;
import com.clinica.integrador2.repository.IPacienteRepository;
import com.clinica.integrador2.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private IDomicilioRepository domicilioRepository;
    @Autowired
    ObjectMapper mapper;

    private static final  Logger logger = Logger.getLogger(String.valueOf(PacienteService.class));

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO)  throws BadRequestException {
        if (pacienteDTO.getDomicilio() == null)
            throw new BadRequestException("Debe ingresar un domicilio");
        else if (pacienteDTO.getNombre() == null || pacienteDTO.getApellido() == null || pacienteDTO.getDni() == null)
            throw new BadRequestException("Debe ingresar todos los  datos del paciente");

        Domicilio domicilio = mapper.convertValue(pacienteDTO.getDomicilio(), Domicilio.class);
        domicilioRepository.save(domicilio);
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        logger.info("Creando paciente: "+ pacienteDTO.getNombre()+" "+pacienteDTO.getApellido()+".");
        pacienteRepository.save(paciente);
    }
    @Override
    public PacienteDTO buscarPaciente(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if (paciente.isPresent())
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        logger.info("Buscando paciente: id "+id);
        return pacienteDTO;
    }
    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException{
        if (buscarPaciente(pacienteDTO.getId()) == null)
            throw new ResourceNotFoundException("no existe un paciente con el id "+pacienteDTO.getId());
        Domicilio domicilio = mapper.convertValue(pacienteDTO.getDomicilio(), Domicilio.class);
        domicilioRepository.save(domicilio);
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        logger.info("Modificando paciente: "+ pacienteDTO.getNombre()+" "+pacienteDTO.getApellido()+".");
        pacienteRepository.save(paciente);
    }
    @Override
    public void eliminarPaciente(Integer id)  throws ResourceNotFoundException{
        if (buscarPaciente(id) == null)
            throw new ResourceNotFoundException("no existe un paciente con el id "+id);
        logger.info("Eliminando paciente id n°: "+id+".");
        pacienteRepository.deleteById(id);
    }
    @Override
    public Set<PacienteDTO> buscarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente: pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        logger.info("Buscando todos los pacientes");
        return pacientesDTO;
    }
}
