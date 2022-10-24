package com.clinica.integrador2.controller;

import com.clinica.integrador2.dto.TurnoDTO;
import com.clinica.integrador2.exception.ResourceNotFoundException;
import com.clinica.integrador2.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO) throws Exception{
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok("se creó 1 nuevo turno");
    }
    @GetMapping("/{id}")
    public TurnoDTO buscarTurno(@PathVariable Integer id){
        return turnoService.buscarTurno(id);
    }
    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException {
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok("se modificó turno id: " + turnoDTO.getId());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Integer id)  throws ResourceNotFoundException{
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Turno ID n°: " + id + " eliminado.");
    }
    @GetMapping
    public Collection<TurnoDTO> buscarTodosTurnos(){
        return turnoService.buscarTodos();
    }
}
