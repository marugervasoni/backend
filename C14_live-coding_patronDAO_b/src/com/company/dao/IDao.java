package com.company.dao;

import java.util.List;

//2) creamos nuestra Interface DAO (utilizaremos generics: pasar por parametro el tipo)
public interface IDao<T> {

    public T guardar(T t);
    public void eliminar (Long id);
    public T buscar(Long id);
    public List<T> buscarTodos();
    
}
