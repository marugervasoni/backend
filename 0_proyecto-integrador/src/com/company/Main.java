package com.company;

import com.company.dao.impl.DomicilioDaoH2;
import com.company.dao.impl.PacienteDaoH2;
import com.company.model.Domicilio;
import com.company.model.Paciente;
import com.company.service.DomicilioService;
import com.company.service.PacienteService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //instancio servicios y seteo estrategia de persistencia
        DomicilioService domicilioService = new DomicilioService(new DomicilioDaoH2());
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

        //agregar domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Falsa");
        domicilio.setNumero("123");
        domicilio.setLocalidad("Springfield");
        domicilio.setProvincia("Buenos Aires");

        //agregar paciente:
        Paciente paciente = new Paciente();
        //seteamos nombre,apellido,dni,domicilio,fechaIngreso,
        paciente.setNombre("Maru");
        paciente.setApellido("Gerva");
        paciente.setDni("123456789");
        paciente.setDomicilio(domicilio);


        //probar metodos de mi daoh2
            //agregar domicilio
        Domicilio domicilioAGuardar = domicilioService.guardar(domicilio);
        System.out.println("se guardo domicilio: "+domicilioAGuardar);
            //agregar paciente
        Paciente pacienteAGuardar = pacienteService.guardar(paciente);
        System.out.println("se guardo paciente: "+pacienteAGuardar);
    }

}
