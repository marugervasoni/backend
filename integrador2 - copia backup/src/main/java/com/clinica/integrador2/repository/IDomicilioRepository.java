package com.clinica.integrador2.repository;

import com.clinica.integrador2.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //para ayudar a srping a la inyeccion de dependencias
public interface IDomicilioRepository extends JpaRepository<Domicilio, Integer> {

    //Con esto Spring Data creará las operaciones CRUD para la entidad; Esto quiere
    // decir que ya podríamos: crear, leer, actualizar, y eliminar de la BD.
}
