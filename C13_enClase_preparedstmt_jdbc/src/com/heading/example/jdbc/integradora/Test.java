package com.heading.example.jdbc.integradora;

import java.sql.*;
import org.apache.log4j.Logger;

import javax.swing.*;

import static java.sql.DriverManager.getConnection;

public class Test {

    /*Crear un statement para crear una tabla usuario, que contenga las columnas con su tipo
Id int
primer_nombre varchar2
apellido varchar2
edad int
Insertar 3 columnas distintas y después eliminar una cualquiera.
Debemos agregar logs para corroborar cual columna fue eliminada.
*/

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS USUARIO; CREATE TABLE USUARIO "
                                                    + "("
                                                    + " ID INT PRIMARY KEY,"
                                                    + " NOMBRE varchar(100) NOT NULL, "
                                                    + " EDAD INT NOT NULL, "
                                                    + " APELLIDO varchar(100) NOT NULL "
                                                    + " )";

    private static final String SQL_INSERT =  "INSERT INTO USUARIO (ID, NOMBRE, APELLIDO, EDAD) VALUES (1, 'Lia', 'Luz', 55)";
    private static final String SQL_INSERT2 =  "INSERT INTO USUARIO (ID, NOMBRE, APELLIDO, EDAD) VALUES (2, 'Lore', 'Ga', 18)";
    private static final String SQL_INSERT3 =  "INSERT INTO USUARIO (ID, NOMBRE, APELLIDO, EDAD) VALUES (3, 'Pilh', 'Perez', 75)";

    private static final String SQL_DELETE =  "DELETE FROM USUARIO WHERE ID=2";

    private static final Logger logger = Logger.getLogger(Test.class);
    private static final String SQL_GET_ALL = "SELECT * FROM usuario";


    public static void main(String[] args) throws Exception {

        String URL = "jdbc:h2:~/test";
        String USER = "sa";
        String PASS = "";

        Class.forName("org.h2.Driver");

        try(Connection conn = getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement()){

            int registrosCreados = 0;

            stmt.execute(SQL_CREATE_TABLE);
            logger.info("Tabla creada :)");

            registrosCreados += stmt.executeUpdate(SQL_INSERT);
            registrosCreados += stmt.executeUpdate(SQL_INSERT2);
            registrosCreados += stmt.executeUpdate(SQL_INSERT3);

            logger.info("Se han registrado " + registrosCreados + " usuarios.");

            ResultSet rs = stmt.executeQuery(SQL_GET_ALL);

            imprimirInfoDelResultSet(rs);

            int registrosEliminados = stmt.executeUpdate(SQL_DELETE);
            logger.info("Se han eliminado " + registrosEliminados + " usuario(s).");

            rs = stmt.executeQuery(SQL_GET_ALL);

            imprimirInfoDelResultSet(rs);

        } catch (SQLException ex) {
            logger.error("UPS!!! " + ex.getMessage());
        }

        logger.info("-- Fin del programa --");
    }

    private static void imprimirInfoDelResultSet(ResultSet rs) throws SQLException {
        while(rs.next()){
            System.out.println(rs.getString("nombre"));
        }
    }

}
