package com.heading.example.jdbc.integradoraaaaaaaa;

import com.heading.example.jdbc.integradoraaaaaaaa.model.Animalito;
import com.heading.example.jdbc.usuario.model.Usuario;
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

        String sqlCreate =  "CREATE TABLE IF NOT EXISTS usuario (id INT PRIMARY KEY, primer_nombre VARCHAR(20), apellido VARCHAR(20), edad INT)";
        String sqlInsert = "INSERT INTO usuario VALUES(1, 'Pompilia', 'Pompini', 5)";
        String sqlInsert2 = "INSERT INTO usuario VALUES(2, 'Martín', 'Martini', 5)";
        String sqlInsert3 = "INSERT INTO usuario VALUES(3, 'Yuma', 'Baby', 5)";
        String sqlDelete = "DELETE FROM usuario WHERE primer_nombre = 'Martín'";
        String sqlQuery = "SELECT * FROM usuario";

        Collection<Usuario> usuarios = new ArrayList<>();

        // [2] - Establecer la conexión utilizando la URL y los datos de autenticación (opciones)
        // [3] - Obtener una instancia de Statement para poder ejecutar sentencias nativas de la base de datos

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()){

            conn.setAutoCommit(false);

            logger.info("Creating table in given database...");

//            stmt.execute(sqlCreate);
//            //stmt.executeUpdate(sqlInsert);
            stmt.executeUpdate(sqlInsert2);
            stmt.executeUpdate(sqlInsert3);

            conn.setAutoCommit(true);

            stmt.executeUpdate(sqlDelete);

            //[4] - Utilizar ResultSet para obtener los datos provenientes de una consulta SQL
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while(rs.next()){ //Se recorre el ResultSet registro por registro
                Usuario usuarioActual = new Usuario();
                usuarioActual.setId(rs.getInt(1));
                usuarioActual.setNombre(rs.getString("primer_nombre"));
                usuarioActual.setApellido(rs.getString(3));
                usuarioActual.setEdad(rs.getInt("edad"));

                usuarios.add(usuarioActual);
            }


        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        usuarios.forEach(a -> System.out.println(a));

    }
}
