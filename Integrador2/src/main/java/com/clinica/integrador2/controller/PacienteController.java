package com.clinica.integrador2.controller;

import com.clinica.integrador2.dto.PacienteDTO;
//import com.clinica.integrador2.service.IDomicilioService;
import com.clinica.integrador2.exception.ResourceNotFoundException;
import com.clinica.integrador2.exception.BadRequestException;
import com.clinica.integrador2.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException, BadRequestException {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok("se creó 1 nuevo paciente");
    }
    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable Integer id) {
        return pacienteService.buscarPaciente(id);
    }
    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok("se modificó paciente id: " + pacienteDTO.getId());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Integer id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("Paciente ID n°: " + id + " eliminado.");
    }
    @GetMapping
    public Collection<PacienteDTO> buscarTodosPacientes() {
        return pacienteService.buscarTodos();
    }
}