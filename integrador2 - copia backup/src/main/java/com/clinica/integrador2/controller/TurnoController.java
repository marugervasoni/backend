package com.clinica.integrador2.controller;

import com.clinica.integrador2.dto.TurnoDTO;
import com.clinica.integrador2.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

//    comprobar fundamentalmente los posibles casos de errores, como
//    agregar un turno a un odontólogo que no existe en la base de datos, o eliminar un turno
//    que no exista en la base de datos.

    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO){
        //retornar codigo status400(bad request) si no existe paciente/odontologo
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public TurnoDTO buscarTurno(@PathVariable Integer id){
        return turnoService.buscarTurno(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Integer id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDTO> buscarTodosTurnos(){
        return turnoService.buscarTodos();
    }

}
