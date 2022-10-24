package com.company.dao;

//4)
//agrego generics a mi IDao
public interface IDao <T>{

    T guardar(T t);
    T buscar (Integer id);
}
