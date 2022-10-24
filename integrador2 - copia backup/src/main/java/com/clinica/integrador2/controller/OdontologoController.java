package com.clinica.integrador2.controller;

import com.clinica.integrador2.dto.OdontologoDTO;
import com.clinica.integrador2.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

//    comprobar fundamentalmente los posibles casos de errores, como
//    agregar un turno a un odontólogo que no existe en la base de datos, o eliminar un turno
//    que no exista en la base de datos.

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
//        retornar codigo status400(bad request) si no existe paciente/odontologo
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologo(@PathVariable Integer id){
        return odontologoService.buscarOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Integer id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDTO> buscarTodosOdontologos(){
        return odontologoService.buscarTodos();
    }
}
