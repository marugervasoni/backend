package com.example.C25_medicamento.dao.impl;

import com.dh.medicamentos.dao.IDao;
import com.example.C25_medicamento.dao.util.ConfiguracionJDBC;
import com.dh.medicamentos.dao.util.GeneradorDeSentencias;
import com.dh.medicamentos.model.Medicamento;
//import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;


public class MedicamentoDaoH2 implements IDao<Medicamento> {

    //private final static Logger logger = Logger.getLogger(MedicamentoDaoH2.class);

    private final static ConfiguracionJDBC jdbc = new ConfiguracionJDBC();
    private final static String TABLE = "medicamentos";

    @Override
    public Medicamento guardar(Medicamento medicamento){
        jdbc.cargarElControlador();

        try (Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO "+ TABLE + "(codigo_numerico, nombre, laboratorio, cantidad, precio) " +
                                                                "VALUES(?, ?, ?, ?, ?)")){


        String s = generarInsertParaTodosLosCampos();
        stmt.setInt(1, medicamento.getCodigoNumerico());
        stmt.setString(2, medicamento.getNombre());
        stmt.setString(3, medicamento.getLaboratorio());
        stmt.setInt(4, medicamento.getCantidad());
        stmt.setDouble(5, medicamento.getPrecio());

        stmt.executeUpdate();

        } catch (SQLException e) {
            //logger.error(e.getMessage());
            System.out.println(e.getMessage());
            return null;
        }

        return medicamento;
    }

    @Override
    public Medicamento buscar(Integer id) {
        jdbc.cargarElControlador();
        Medicamento respuesta = null;

        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM medicamentos WHERE id = ?")){

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                respuesta = new Medicamento(rs.getInt("id"),
                                            rs.getString("nombre"),
                                            rs.getInt("codigo_numerico"),
                                            rs.getString("laboratorio"),
                                            rs.getInt("cantidad"),
                                            rs.getDouble("precio"));
            }

        } catch (SQLException e) {
            //logger.error(e.getMessage());
            System.out.println(e.getMessage());
        }

        return respuesta;
    }

    private String generarInsertParaTodosLosCampos(){

        return GeneradorDeSentencias.generarInsert(TABLE, List.of("codigo_numerico", "nombre", "laboratorio", "cantidad", "precio"));
    }
}