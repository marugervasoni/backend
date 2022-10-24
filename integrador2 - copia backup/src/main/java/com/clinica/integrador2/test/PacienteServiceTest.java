package com.clinica.integrador2.test;

import com.clinica.integrador2.dto.DomicilioDTO;
import com.clinica.integrador2.dto.PacienteDTO;
import com.clinica.integrador2.service.IPacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {


        @Autowired
        private IPacienteService pacienteService;

        @Test
        public void testCrearPaciente(){

            DomicilioDTO domicilioDTO = new DomicilioDTO();
            domicilioDTO.setCalle("Avenida Centenario");
            domicilioDTO.setNumero("105");
            domicilioDTO.setLocalidad("San Isidro");
            domicilioDTO.setProvincia("Buenos Aires");
            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setNombre("Maru");
            pacienteDTO.setApellido("Gerva");
            pacienteDTO.setDni("3938485");
            pacienteDTO.setDomicilio(domicilioDTO);

            pacienteService.crearPaciente(pacienteDTO);

            assertTrue(pacienteService.buscarPaciente(1)!= null);
        }

        @Test
        public void testBuscarPaciente(){

            DomicilioDTO domicilioDTO = new DomicilioDTO();
            domicilioDTO.setCalle("Avenida Centenario");
            domicilioDTO.setNumero("105");
            domicilioDTO.setLocalidad("San Isidro");
            domicilioDTO.setProvincia("Buenos Aires");
            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setNombre("Maru");
            pacienteDTO.setApellido("Gerva");
            pacienteDTO.setDni("3938485");
            pacienteDTO.setDomicilio(domicilioDTO);

            pacienteService.crearPaciente(pacienteDTO);
            pacienteService.buscarPaciente(1);

            assertTrue(pacienteDTO != null);
        }

        @Test
        public void testModificarOdontologo(){

            DomicilioDTO domicilioDTO = new DomicilioDTO();
            domicilioDTO.setCalle("Avenida Centenario");
            domicilioDTO.setNumero("105");
            domicilioDTO.setLocalidad("San Isidro");
            domicilioDTO.setProvincia("Buenos Aires");
            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setNombre("Maru");
            pacienteDTO.setApellido("Gerva");
            pacienteDTO.setDni("3938485");
            pacienteDTO.setDomicilio(domicilioDTO);
            pacienteService.crearPaciente(pacienteDTO);

            pacienteDTO.setId(1);
            pacienteDTO.setNombre("Maria Rosa");
            pacienteService.modificarPaciente(pacienteDTO);
            pacienteService.buscarPaciente(1);

            assertTrue(pacienteDTO.getNombre() == "Maria Rosa" && pacienteDTO.getApellido() == "Gerva" && pacienteDTO.getDni() == "3938485" && pacienteDTO.getDomicilio() == domicilioDTO);
        }

        @Test
        public void testEliminarOdontologo(){

            DomicilioDTO domicilioDTO = new DomicilioDTO();
            domicilioDTO.setCalle("Avenida Centenario");
            domicilioDTO.setNumero("105");
            domicilioDTO.setLocalidad("San Isidro");
            domicilioDTO.setProvincia("Buenos Aires");
            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setNombre("Maru");
            pacienteDTO.setApellido("Gerva");
            pacienteDTO.setDni("3938485");
            pacienteDTO.setDomicilio(domicilioDTO);
            pacienteService.crearPaciente(pacienteDTO);

            pacienteService.eliminarPaciente(1);
            PacienteDTO pacienteDTO1 = pacienteService.buscarPaciente(1);

            assertTrue(pacienteDTO1 == null);
        }

        @Test
        public void testBuscarTodos(){

            DomicilioDTO domicilioDTO1 = new DomicilioDTO();
            domicilioDTO1.setCalle("Avenida Centenario");
            domicilioDTO1.setNumero("105");
            domicilioDTO1.setLocalidad("San Isidro");
            domicilioDTO1.setProvincia("Buenos Aires");
            PacienteDTO pacienteDTO1 = new PacienteDTO();
            pacienteDTO1.setNombre("Maru");
            pacienteDTO1.setApellido("Gerva");
            pacienteDTO1.setDni("3938485");
            pacienteDTO1.setDomicilio(domicilioDTO1);
            pacienteService.crearPaciente(pacienteDTO1);
            DomicilioDTO domicilioDTO2 = new DomicilioDTO();
            domicilioDTO2.setCalle("Avenida Centinela");
            domicilioDTO2.setNumero("10578");
            domicilioDTO2.setLocalidad("Bulogne");
            domicilioDTO2.setProvincia("Buenos Aires");
            PacienteDTO pacienteDTO2 = new PacienteDTO();
            pacienteDTO2.setNombre("Valeria");
            pacienteDTO2.setApellido("Gervasoni");
            pacienteDTO2.setDni("183495");
            pacienteDTO2.setDomicilio(domicilioDTO2);
            pacienteService.crearPaciente(pacienteDTO2);

            pacienteService.buscarTodos();

            assertTrue(pacienteService.buscarTodos() != null);
        }
}