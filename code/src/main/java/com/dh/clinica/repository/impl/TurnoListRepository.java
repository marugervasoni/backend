package com.dh.clinica.repository.impl;

import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.dto.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoListRepository implements IDao<Turno> {

    private List<Turno> turnos;

    public TurnoListRepository() {
        turnos = new ArrayList<>();
    }

    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        for(Turno turno : turnos){
            if(turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {

        for(Turno turno : turnos){
            if(turno.getId().equals(id)){
                turnos.remove(turno);
                return;
            }
        }

    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        Turno result = turno;
        if(turnos.contains(turno)) {
            eliminar(turno.getId());
            turnos.add(turno);
        }else{
            result = null;
        }

        return result;
    }
}
