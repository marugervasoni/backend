package com.example.C25_medicamento.service;

import com.dh.medicamentos.model.Medicamento;
import com.example.C25_medicamento.dao.IDao;

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
