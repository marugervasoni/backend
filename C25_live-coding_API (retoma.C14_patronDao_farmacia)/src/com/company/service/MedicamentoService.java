package com.company.service;

import com.company.dao.IDao;
import com.company.model.Medicamento;

//2)
public class MedicamentoService  {

    //atributo el dao de medicamento
    private IDao<Medicamento> medicamentoDao;

    //constructor
    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    //metodos
    public Medicamento guardar(Medicamento medicamento) {
        //El Service debe validar los datos que vienen en el objeto Entidad
        return medicamentoDao.guardar(medicamento); //retorno el metodo del la interface
    }

    public Medicamento buscar(Integer id){
        return medicamentoDao.buscar(id); //retorno el metodo del la interface
    }


}
