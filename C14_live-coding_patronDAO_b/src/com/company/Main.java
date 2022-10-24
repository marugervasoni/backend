package com.company;

import com.company.dao.EstudianteDAOH2;
import com.company.entidades.Estudiante;
import com.company.servicio.EstudianteService;

public class Main {

    public static void main(String[] args) {
        //9) probamos que haya salido bien
            //creamos 1 estudiante
        Estudiante estudiante = new Estudiante();

            //seteamos valores de estudiante
        estudiante.setId(1L);
        estudiante.setNombre("Javier");
        estudiante.setApellido("Rabuch");

            //instancia mi EstudianteService
        EstudianteService estudianteService = new EstudianteService();
            //seteo una estrategia de persistencia (DAO)
        estudianteService.setEstudianteIDao(new EstudianteDAOH2());

            //pido al servicio guardar un estudiante en la BD
        estudianteService.guardarEstudiante(estudiante);

        //puedo probar los otros metodos
        //estudianteService.eliminarEstudiante();
    }
}
