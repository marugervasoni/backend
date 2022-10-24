package com.company.service;

import com.company.dao.IDao;
import com.company.model.Domicilio;

import java.util.List;

public class DomicilioService {

    IDao<Domicilio> domicilioIDao;

    public DomicilioService(IDao<Domicilio> domicilioIDao) {
        this.domicilioIDao = domicilioIDao;
    }

    //metodos: guardar; buscar; buscarTodos; eliminar.
    public Domicilio guardar(Domicilio d){
        domicilioIDao.guardar(d);
        return d; //retorno el domicilio guardado para paciente
    }
    public Domicilio buscar(Integer id){
        return domicilioIDao.buscar(id);
    }
    public List<Domicilio> buscarTodos(){
        return domicilioIDao.buscarTodos();
    }
    public void eliminar(Integer id){
        domicilioIDao.eliminar(id);
    }
}
