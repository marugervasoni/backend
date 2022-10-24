package com.heading.example.jdbc.animalitos;

import com.heading.example.jdbc.animalitos.model.Animalito;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args){
        // [1] Registrar el Controlador
        try {
            Class.forName("org.h2.Driver");
        }
        catch(ClassNotFoundException ex) {
            logger.error("Error: unable to load driver class!");
            System.exit(1);
        }

        String URL = "jdbc:h2:~/test";
        String USER = "sa";
        String PASS = "";

        String sqlCreate =  "CREATE TABLE IF NOT EXISTS animalitos (id INT PRIMARY KEY, nombre VARCHAR(20), tipo VARCHAR(20))";
        String sqlInsert = "INSERT INTO animalitos VALUES(100, 'Pompilia', 'perro')";
        String sqlDelete = "DELETE FROM animalitos WHERE nombre = 'JuanPa'";
        String sqlQuery = "SELECT * FROM animalitos WHERE tipo='perro'";

        Collection<Animalito> animalitos = new ArrayList<>();

        // [2] - Establecer la conexión utilizando la URL y los datos de autenticación (opciones)
        // [3] - Obtener una instancia de Statement para poder ejecutar sentencias nativas de la base de datos
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()){

            logger.info("Creating table in given database...");

            stmt.execute(sqlCreate);
            stmt.executeUpdate(sqlInsert);
            stmt.executeUpdate(sqlDelete);

            //[4] - Utilizar ResultSet para obtener los datos provenientes de una consulta SQL
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while(rs.next()){ //Se recorre el ResultSet registro por registro
                Animalito animalitoActual = new Animalito();
                animalitoActual.setId(rs.getInt(1));
                animalitoActual.setNombre(rs.getString("nombre"));
                animalitoActual.setTipo(rs.getString(3));

                animalitos.add(animalitoActual);
            }


        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        animalitos.forEach(a -> System.out.println(a));

    }
}
