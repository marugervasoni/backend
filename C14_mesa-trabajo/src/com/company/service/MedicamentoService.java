package com.company.service;

import com.company.dao.IMedicamentoDAO;
import com.company.entity.Medicamento;


public class MedicamentoService {

    //interface de tipo medicamento como atributo
    private IMedicamentoDAO<Medicamento>  medicamentoIDao;

    //getters y setters
    public IMedicamentoDAO<Medicamento> getMedicamentoIDao() {
        return medicamentoIDao;
    }

    public void setMedicamentoIDao(IMedicamentoDAO<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    //metodos que delegaran la responsabilidad al Dao.
    public Medicamento registrarMedicamento(Medicamento m) {
        return medicamentoIDao.registrar(m);
    }
    public Long buscarMedicamento (Long id){
        return  medicamentoIDao.buscar(id);
    }
}
