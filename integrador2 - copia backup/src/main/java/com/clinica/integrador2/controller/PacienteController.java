package com.clinica.integrador2.controller;

import com.clinica.integrador2.dto.DomicilioDTO;
import com.clinica.integrador2.dto.PacienteDTO;
import com.clinica.integrador2.entity.Domicilio;
import com.clinica.integrador2.entity.Paciente;
//import com.clinica.integrador2.service.IDomicilioService;
import com.clinica.integrador2.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

//    comprobar fundamentalmente los posibles casos de errores, como
//    agregar un turno a un odontólogo que no existe en la base de datos, o eliminar un turno
//    que no exista en la base de datos.

    @Autowired
    IPacienteService pacienteService;
//    @Autowired
//    IDomicilioService domicilioService;

//    @PostMapping
//    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
//        Domicilio d = domicilioService.crearDomicilio(domicilioDTO);
//        return ResponseEntity.ok(d); //modificar todo asi, cosa que en vez de ok me devuelva la data
//    }

//    @PostMapping
//    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
//        return ResponseEntity.ok(pacienteService.crearPaciente(pacienteDTO));
//    }

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
//        retornar codigo status400(bad request) si no existe paciente/odontologo
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok("se creó nuevo paciente"); //fijarse como mejorar las respuestas
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable Integer id){
        return pacienteService.buscarPaciente(id);
    }

//    @PutMapping
//    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
//        return ResponseEntity.ok(pacienteService.modificarPaciente(pacienteDTO));
//    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok("se modificó paciente id: "+pacienteDTO.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Integer id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("Paciente ID n°: "+id+" eliminado.");
    }

    @GetMapping
    public Collection<PacienteDTO> buscarTodosPacientes(){
        return pacienteService.buscarTodos();
    }
}
