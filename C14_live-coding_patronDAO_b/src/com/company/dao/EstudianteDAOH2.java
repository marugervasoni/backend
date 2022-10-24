package com.company.dao;

import com.company.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//4 Creo la clase EstudianteDAOH2 (se debe importar al proyecto la BDH2)
public class EstudianteDAOH2 implements IDao<Estudiante>{  //implementa interface DAO

    //para conectarnos a BD necesitaremos: driver de conexion, url, usuario, password
    //los colocamos como atributos: (de forma privada, final estatica)
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_estudiantes";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

   //implemento metodos de la interface y luego los sobreescribo:
        //5) Metodo guardar:
    @Override
    public Estudiante guardar(Estudiante estudiante) {
        PreparedStatement preparedStatement = null; //b)
        Connection connection = null; //a)

        //a) levantamos driver y contactamos (atrapado en un catch)
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

        //b) crear sentencia
        preparedStatement = connection.prepareStatement("INSERT INTO estudiantes VALUES (?,?,?)");
        preparedStatement.setLong(1,estudiante.getId());
        preparedStatement.setString(2,estudiante.getNombre());
        preparedStatement.setString(3,estudiante.getApellido());

        //c) ejecutamos la sentencia
        preparedStatement.executeUpdate();
        preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;
    }

        //metodo eliminar
    @Override
    public void eliminar(Long id) {
        PreparedStatement preparedStatement = null; //b)
        Connection connection = null; //a)

        //a) levantamos driver y contactamos (atrapado en un catch)
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            //b) crear sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM estudiantes where id=?");
            preparedStatement.setLong(1,id);

            //c) ejecutamos la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

        //metodo buscar
    @Override
    public Estudiante buscar(Long id) {
        Connection connection = null; //a)
        PreparedStatement preparedStatement = null; //b)
        Estudiante estudiante = null; //d)

        //a) levantamos driver y contactamos (atrapado en un catch)
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            //b) crear sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes where id=?");
            preparedStatement.setLong(1,id);

            //c) ejecutamos la sentencia
            ResultSet result = preparedStatement.executeQuery();

            //d) evaluar resultados
                //mientras haya resultados:
            while (result.next()) {
                Long idEstudiante = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                estudiante = new Estudiante(); //instancio estudiante si encuentro registro
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;
    }
        //metodo buscar todos
    @Override
    public List<Estudiante> buscarTodos() {
        Connection connection = null; //a)
        PreparedStatement preparedStatement = null; //b)
        List<Estudiante> estudiantes = new ArrayList<>(); //d)

        //a) levantamos driver y contactamos (atrapado en un catch)
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            //b) crear sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes"); //no hay where porque traemos todos

            //c) ejecutamos la sentencia
            ResultSet result = preparedStatement.executeQuery();

            //d) evaluar resultados
            //mientras haya resultados:
            while (result.next()) {
                Long idEstudiante = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                Estudiante estudiante = new Estudiante(); //instancio estudiante si encuentro registro
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);

                estudiantes.add(estudiante);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiantes;
    }
}




