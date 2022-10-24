package com.dh.clinica.persistence;

public interface IDao<E> {
    /**
     *
     * @param entidad
     * @return <b>null</b> si ocurrió un error al intentar insertar el registro en la base de datos.
     */
    E crear(E entidad);
    E buscarPorId(int id);
}
