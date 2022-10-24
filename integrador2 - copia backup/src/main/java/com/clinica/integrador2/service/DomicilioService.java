//package com.clinica.integrador2.service;
//
//import com.clinica.integrador2.entity.Domicilio;
//import com.clinica.integrador2.dto.DomicilioDTO;
//import com.clinica.integrador2.repository.IDomicilioRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//public class DomicilioService implements IDomicilioService{
//
//    //TODO LOGGER
//    @Autowired //para poder inyectar dependencias ya que accedera a la capa de datos
//    private IDomicilioRepository domicilioRepository;
//    @Autowired //necesitamos para esta, tener en pom su dependencia (jackson).
//    ObjectMapper mapper;
//
//
//        //metodo para utilizar en CREAR y en MODIFICAR:----------------------------------------------------
//            //porque ambos utilizan metodo save() solo que si el id es 0
//            // agrega  uno nuevo, si el id es diferente de cero nos va a modificar.
////    private Domicilio guardarDomicilio(DomicilioDTO domicilioDTO){
////        //para usar el metodo save, mapeo mi domicilioDTO a domicilio (porque save solo recibe domicdto y yo preciso pasar domic.)
////        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
////        //la paso por parametro
////        return domicilioRepository.save(domicilio);
////    }
//
//
//    //implemento metodos de mi interface:--------------------------------------
//    @Override //guardamos en la bd
//    public Domicilio crearDomicilio(DomicilioDTO domicilioDTO) {
//        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
//        return domicilioRepository.save(domicilio);
//        //llamo a mi metodo utilizable porque es lo mismo lo que debo hacer
//        //logger.info("se guardó un domicilio");   TODO
//        //return guardarDomicilio(domicilioDTO);
//    }
//
//    @Override
//    public DomicilioDTO buscarDomicilio(Integer id) {
//        //la busqueda por id a realizar la almaceno en una variable tipo Optional de domicilio (xq el findById retorna un optional)
//        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
//        //creo una variable null de domic dto para luego pasarle valor
//        DomicilioDTO domicilioDTO = null;
//        //pregunto si mi objeto domicilio tiene valores:
//        if(domicilio.isPresent()){
//            //si tiene: mapeo mi objeto domicilio a domicilio dto
//            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
//        }
//        //finalmente lo retorno
//        return domicilioDTO;
//    }
//
//    @Override
//    public Domicilio modificarDomicilio(DomicilioDTO domicilioDTO) {
//        //llamo a mi metodo utilizable
//        //guardarDomicilio(domicilioDTO);
//        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
//        return domicilioRepository.save(domicilio);
//    }
//
//    @Override
//    public void eliminarDomicilio(Integer id) {
//        //uso metodo para borrar x id y paso el id
//        domicilioRepository.deleteById(id);
//    }
//
//    @Override
//    public Set<DomicilioDTO> buscarTodos() {
//        //almaceno mi metodo en variable domicilios que retorna una lista de ellos por ello el tipo list domic
//        List<Domicilio> domicilios = domicilioRepository.findAll();
//
//        //debo devolver dto: creo lista tipo set, la instancio y la recorro
//        Set<DomicilioDTO> domiciliosDTO = new HashSet<>();
//            //X c domic  de colección domic
//        for (Domicilio domicilio: domicilios){
//            //agrégalo a colección domicDTO c mapper p transf domic a dto.
//            domiciliosDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
//        }
//        //finalmente retorno lista de domic transf a domicDTO
//        return domiciliosDTO;
//    }
//}
