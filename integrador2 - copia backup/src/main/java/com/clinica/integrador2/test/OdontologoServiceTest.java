package com.clinica.integrador2.test;

import com.clinica.integrador2.dto.OdontologoDTO;
import com.clinica.integrador2.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void testCrearOdontologo(){

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Omar");
        odontologoDTO.setApellido("Diente");
        odontologoDTO.setMatricula(12345);

        odontologoService.crearOdontologo(odontologoDTO);

        assertTrue(odontologoService.buscarOdontologo(1) != null);
    }

    @Test
    public void testModificarOdontologo() {

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Omar");
        odontologoDTO.setApellido("Diente");
        odontologoDTO.setMatricula(12345);
        odontologoService.crearOdontologo(odontologoDTO);

        odontologoDTO.setId(1);
        odontologoDTO.setNombre("Omar Fernando");
        odontologoService.modificarOdontologo(odontologoDTO);
        odontologoService.buscarOdontologo(1);

        assertTrue(odontologoDTO.getNombre() == "Omar Fernando" && odontologoDTO.getApellido() == "Diente" && odontologoDTO.getMatricula() == 12345);
    }

    @Test
    public void testBuscarOdontologo(){

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Omar");
        odontologoDTO.setApellido("Diente");
        odontologoDTO.setMatricula(12345);

        odontologoService.crearOdontologo(odontologoDTO);
        odontologoService.buscarOdontologo(1);

        assertTrue(odontologoDTO != null);
    }

    @Test
    public void testEliminarOdontologo(){

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Omar");
        odontologoDTO.setApellido("Diente");
        odontologoDTO.setMatricula(12345);
        odontologoService.crearOdontologo(odontologoDTO);

        odontologoService.eliminarOdontologo(1);
        OdontologoDTO odontologoDTO1 = odontologoService.buscarOdontologo(1);

        assertTrue(odontologoDTO1 == null);
    }

    @Test
    public void testBuscarTodos(){

        OdontologoDTO odontologoDTO1 = new OdontologoDTO();
        odontologoDTO1.setNombre("Omar");
        odontologoDTO1.setApellido("Diente");
        odontologoDTO1.setMatricula(12345);
        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setNombre("Maria");
        odontologoDTO2.setApellido("Gervasoni");
        odontologoDTO2.setMatricula(23435);
        odontologoService.crearOdontologo(odontologoDTO1);
        odontologoService.crearOdontologo(odontologoDTO2);

        odontologoService.buscarTodos();

        assertTrue(odontologoService.buscarTodos() != null);
    }



}











