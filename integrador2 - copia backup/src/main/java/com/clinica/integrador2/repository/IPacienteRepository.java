package com.clinica.integrador2.repository;

import com.clinica.integrador2.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    //Con esto Spring Data creará las operaciones CRUD para la entidad; Esto quiere
    // decir que ya podríamos: crear, leer, actualizar, y eliminar de la BD.

}
