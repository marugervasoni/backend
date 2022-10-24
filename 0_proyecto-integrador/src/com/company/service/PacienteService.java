package com.company.service;

import com.company.dao.IDao;
import com.company.model.Domicilio;
import com.company.model.Paciente;

import java.util.Date;
import java.util.List;

public class PacienteService {

    IDao<Paciente> pacienteIDao;

    //constructor de pacienteService
    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    //metodos: listar(buscar); agregar; modificar (dar de alta)?; eliminar.
    public Paciente guardar(Paciente p){
        p.setFechaDeIngreso(new Date());
        return pacienteIDao.guardar(p);
    }

    public Paciente buscar(Integer id){
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }

    public void eliminar(Integer id){
        pacienteIDao.eliminar(id);
    }

    public Paciente actualizar(Paciente p){
        return pacienteIDao.actualizar(p);
    }
}
