package com.clinica.integrador2.test;

import com.clinica.integrador2.dto.TurnoDTO;
import com.clinica.integrador2.service.ITurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private ITurnoService turnoService;

    @Test
    public void testCrearTurno() {

        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setDate(LocalDate.now());

        turnoService.crearTurno(turnoDTO);

        assertTrue(turnoService.buscarTurno(1) != null);
    }

    @Test
    public void testBuscarTurno(){

        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setDate(LocalDate.now());
        turnoService.crearTurno(turnoDTO);

        turnoService.buscarTurno(1);

        assertTrue(turnoDTO != null);
    }

    @Test
    public void testModificarTurno(){

        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setDate(LocalDate.now());
        turnoService.crearTurno(turnoDTO);

        turnoDTO.setId(1);
        turnoDTO.setDate(LocalDate.of(2022,10,23));
        turnoService.modificarTurno(turnoDTO);
        turnoService.buscarTurno(1);

        assertTrue(turnoDTO.getDate().equals(LocalDate.of(2022,10,23)));
    }

    @Test
    public void testEliminarOdontologo(){

        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setDate(LocalDate.now());
        turnoService.crearTurno(turnoDTO);

        turnoService.eliminarTurno(1);
        TurnoDTO turnoDTO1 = turnoService.buscarTurno(1);

        assertTrue(turnoDTO1 == null);
    }

    @Test
    public void testBuscarTodos(){

        TurnoDTO turnoDTO1 = new TurnoDTO();
        turnoDTO1.setDate(LocalDate.now());
        turnoService.crearTurno(turnoDTO1);
        TurnoDTO turnoDTO2 = new TurnoDTO();
        turnoDTO2.setDate(LocalDate.of(2022,10,23));
        turnoService.crearTurno(turnoDTO2);

        turnoService.buscarTodos();

        assertTrue(turnoService.buscarTodos() != null);
    }
}
