package com.clinica.integrador2.controller;

import com.clinica.integrador2.dto.OdontologoDTO;
import com.clinica.integrador2.exception.ResourceNotFoundException;
import com.clinica.integrador2.exception.BadRequestException;
import com.clinica.integrador2.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException, BadRequestException {
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok("se creó 1 nuevo odontologo");
    }
    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologo(@PathVariable Integer id){
        return odontologoService.buscarOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException{
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok("se modificó odontologo id: " + odontologoDTO.getId());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Integer id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Odontologo ID n°: " + id + " eliminado.");
    }
    @GetMapping
    public Collection<OdontologoDTO> buscarTodosOdontologos(){
        return odontologoService.buscarTodos();
    }
}
