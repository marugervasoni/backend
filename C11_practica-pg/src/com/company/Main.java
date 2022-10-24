package com.company;

import com.company.model.Empleado;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    //agrego logger
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args){
//-----------------------------------------------------------------------------
//FUNCIONA PERO NO USABA LOGGERS NI CLASE EMPLEADO

        //1) conexion a bd
            //registro controlador:
        try {
            //hago nueva instancia del driver
            Class.forName("org.h2.Driver"); //.newInstance(); ya no lo uso aca
        }
        catch (ClassNotFoundException ex) {
            logger.error("Error: unable to load driver class!");
            System.exit(1);
        }

            //seteo mis variables para conexion:
        String URL = "jdbc:h2:~/test";
        String USER = "sa";
        String PASS = "";

        //string para ingresar mi sentencia, buena practica comenzar con drop
        String sqlCreate =  "CREATE TABLE IF NOT EXISTS empleado (id INT PRIMARY KEY, nombre VARCHAR(255), edad INT, empresa VARCHAR(255), fechaIngreso VARCHAR(255))";
        //strings para sentencias tipo insert
        String sqlInsert1 = "INSERT INTO empleado VALUES(1,'Maria',26,'Digital','10/08/2022')";
        String sqlInsert2 = "INSERT INTO empleado VALUES(2,'Valeria',24,'Google','10/07/2022')";
        String sqlInsert3 = "INSERT INTO empleado VALUES(3,'Lucia',29,'Facebook','10/06/2022')";
//        String sqlDelete = "DELETE FROM animalitos WHERE nombre = 'JuanPa'";
//        String sqlQuery = "SELECT * FROM animalitos WHERE tipo='perro'";
//
        //genero una coleccion para llenarla despues
        Collection<Empleado> empleados = new ArrayList<>();

        //armo objeto conexion pero lo encierro en un try catch
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             //conectados ya podemos crear objetos statement
             Statement stmt = connection.createStatement()){

            logger.info("Creating table in given database...");

            //2) creacion de tablas:
            stmt.execute(sqlCreate); //-->ejecutamos la sentencia

            //3) insertar filas
            stmt.executeUpdate(sqlInsert1); //-->agrego mis empleados
            stmt.executeUpdate(sqlInsert2);
            stmt.executeUpdate(sqlInsert3);

            //4) muestro datos con result set
                // sentencia query para obtener datos
            String sqlQuery = "SELECT * FROM EMPLEADO";

                //ejecutamos pero teniendo en cuenta que es query y que nos devuelva un result
            ResultSet rs = stmt.executeQuery(sqlQuery);
                //itero resultSet registro x registro:
            while(rs.next()){
                //--imprimo por consola el primer elemento(id) y el segundo (nombre)
//                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3)+rs.getString(4)+rs.getString(5));

                //--alternativa de impresion
                Empleado empleadoActual = new Empleado();
                empleadoActual.setId(rs.getInt(1));
                empleadoActual.setNombre(rs.getString(2)); //Puedo poner index o label
                empleadoActual.setEdad(rs.getInt(3));
                empleadoActual.setEmpresa(rs.getString(4));
                empleadoActual.setFechaIngreso(rs.getString(5));

                empleados.add(empleadoActual); //agrego en cada iteracion un empleado
            }
        }
        catch (SQLException ex){
            logger.error(ex.getMessage());
        }

        empleados.forEach(a -> System.out.println(a)); //aca imprimo empleado
    }
}
