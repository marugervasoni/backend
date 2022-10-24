//package com.clinica.integrador2.test;
//
//import com.clinica.integrador2.dto.DomicilioDTO;
//import com.clinica.integrador2.service.IDomicilioService;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import static org.junit.jupiter.api.Assertions.*;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Objects;
//
////@RunWith(SpringRunner.class)
//@SpringBootTest
//class DomicilioServiceTest {
//
//    @Autowired //llamo al service para poder inyectar dependencias
//    private IDomicilioService domicilioService;
//
//    @Test //agrego mi test y su anotación
//    public void testCrearDomicilio(){
//
//        //DADOS: tener un domicdto y sus datos
//        DomicilioDTO domicilioDTO = new DomicilioDTO();
//        domicilioDTO.setCalle("Antartida Argentina");
//        domicilioDTO.setNumero("2776");
//        domicilioDTO.setLocalidad("San Isidro");
//        domicilioDTO.setProvincia("Buenos Aires");
//
//        //CUANDO: pruebo el metodo
//        domicilioService.crearDomicilio(domicilioDTO);
//
//        //ENTONCES: si busco el objeto nuevo por su id no debe ser null
//        assertTrue(domicilioService.buscarDomicilio(1) != null);
//    }
//
//    @Test
//    public void testBuscarDomicilio(){
//
//        DomicilioDTO domicilioDTO = new DomicilioDTO();
//        domicilioDTO.setCalle("Antartida Argentina");
//        domicilioDTO.setNumero("2776");
//        domicilioDTO.setLocalidad("San Isidro");
//        domicilioDTO.setProvincia("Buenos Aires");
//
//        domicilioService.crearDomicilio(domicilioDTO);
//        domicilioService.buscarDomicilio(1);
//
//        assertTrue(domicilioDTO != null);
//    }
//
//    @Test
//    public void testModificardomicilio(){
//
//        DomicilioDTO domicilioDTO = new DomicilioDTO();
//        domicilioDTO.setCalle("Antartida Argentina");
//        domicilioDTO.setNumero("2776");
//        domicilioDTO.setLocalidad("San Isidro");
//        domicilioDTO.setProvincia("Buenos Aires");
//        domicilioService.crearDomicilio(domicilioDTO);
//
//        domicilioDTO.setId(1);
//        domicilioDTO.setCalle("Hola");
//        domicilioDTO.setNumero("123");
//        domicilioService.modificarDomicilio(domicilioDTO);
//        domicilioService.buscarDomicilio(1);
//
//        assertTrue(domicilioDTO.getCalle() == "Hola" && domicilioDTO.getNumero() == "123");
//    }
//
//    @Test
//    public void testEliminarDomicilio(){
//
//        DomicilioDTO domicilioDTO = new DomicilioDTO();
//        domicilioDTO.setCalle("Antartida Argentina");
//        domicilioDTO.setNumero("2776");
//        domicilioDTO.setLocalidad("San Isidro");
//        domicilioDTO.setProvincia("Buenos Aires");
//        domicilioService.crearDomicilio(domicilioDTO);
//
//        domicilioService.eliminarDomicilio(1);
//        DomicilioDTO domicilioDTO1 = domicilioService.buscarDomicilio(1);
//
//        assertTrue(domicilioDTO1 == null);
//    }
//
//    @Test
//    public void testBuscarTodos(){
//
//        DomicilioDTO domicilioDTO1 = new DomicilioDTO();
//        domicilioDTO1.setCalle("Antartida Argentina");
//        domicilioDTO1.setNumero("2776");
//        domicilioDTO1.setLocalidad("San Isidro");
//        domicilioDTO1.setProvincia("Buenos Aires");
//        DomicilioDTO domicilioDTO2 = new DomicilioDTO();
//        domicilioDTO2.setCalle("calle falsa");
//        domicilioDTO2.setNumero("123");
//        domicilioDTO2.setLocalidad("Boulogne");
//        domicilioDTO2.setProvincia("Buenos Aires");
//        domicilioService.crearDomicilio(domicilioDTO1);
//        domicilioService.crearDomicilio(domicilioDTO2);
//
//        domicilioService.buscarTodos();
//
//        assertTrue(domicilioService.buscarTodos() != null);
//    }
//}