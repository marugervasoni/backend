package com.company.dao;

public interface IMedicamentoDAO<T> {

    public T registrar (T t);
    public Long buscar (Long id);
}
