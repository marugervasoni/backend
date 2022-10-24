package com.clinica.integrador2.controller;

import com.clinica.integrador2.entity.Domicilio;
import com.clinica.integrador2.dto.DomicilioDTO;
//import com.clinica.integrador2.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
//
//@RestController
//@RequestMapping("/domicilios")
//public class DomicilioController {
//
//    @Autowired
//    IDomicilioService domicilioService;
//
//    @PostMapping
//    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
//        Domicilio d = domicilioService.crearDomicilio(domicilioDTO);
//        return ResponseEntity.ok(d); //modificar todo asi, cosa que en vez de ok me devuelva la data
//    }
//
//    @GetMapping("/{id}")
//    public DomicilioDTO buscarDomicilio(@PathVariable Integer id){
//
//        return domicilioService.buscarDomicilio(id);
//    }
//
//    @PutMapping
//    public ResponseEntity<?> modificarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
//        domicilioService.modificarDomicilio(domicilioDTO);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> eliminarDomicilio(@PathVariable Integer id){
//        domicilioService.eliminarDomicilio(id);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
//
//    //ESTO LO PUEDO IMPLEMENTAR? COMO SE VE EN POSTMAN?
////    @DeleteMapping("/{id}")
////    public ResponseEntity eliminar(@PathVariable Integer id) {
////        ResponseEntity response = null;
////        if (peliculaService.eliminar(id))
////            response = ResponseEntity.status(HttpStatus.OK).build();
////        else
////            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
////        return response;
//
//
//    @GetMapping
//    public Collection<DomicilioDTO> buscarTodosDomicilio(){
//        return domicilioService.buscarTodos();
//    }
//
//}

