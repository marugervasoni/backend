package com.dh.medicamentos.service;

import com.dh.medicamentos.dao.IDao;
import com.dh.medicamentos.dao.impl.MedicamentoDaoH2;
import com.dh.medicamentos.model.Medicamento;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoDao;

    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento guardar(Medicamento medicamento){
       //El Service debe validar los datos que vienen en el objeto Entidad
       return medicamentoDao.guardar(medicamento);
    }

    public  Medicamento buscar(Integer id){
        return medicamentoDao.buscar(id);
    }
}