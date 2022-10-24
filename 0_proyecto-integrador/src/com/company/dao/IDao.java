package com.company.dao;

import com.company.model.Paciente;

import java.util.List;

public interface IDao <T>{

    T guardar(T t);
    T buscar(Integer id);
    List<T> buscarTodos();
    void eliminar (Integer id);
    T actualizar(T t);

}


