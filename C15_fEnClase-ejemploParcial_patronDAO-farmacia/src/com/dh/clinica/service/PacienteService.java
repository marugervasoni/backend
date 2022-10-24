package com.dh.clinica.service;

import com.dh.clinica.model.Domicilio;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.persistence.IDao;

public class PacienteService {

    IDao<Paciente> daoPaciente;
    IDao<Domicilio> daoDomicilio;

    public PacienteService(IDao<Paciente> daoPaciente, IDao<Domicilio> daoDomicilio) {
        this.daoPaciente = daoPaciente;
        this.daoDomicilio = daoDomicilio;
    }

    public Paciente buscarPacientePorId(int id){
        return daoPaciente.buscarPorId(id);
    }

    public Paciente darDeAlta(Paciente p){
        Paciente resultado = null;

        if(p.getDomicilio() != null){
            if(daoDomicilio.crear(p.getDomicilio()) != null){
                resultado = daoPaciente.crear(p);
            }
        }

        return resultado;
    }
}
