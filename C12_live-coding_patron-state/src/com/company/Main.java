package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class Main {

    //1) querys ya se encuentran hechas
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS USUARIO; CREATE TABLE USUARIO VALUES"
            + "("
            + "ID INT PRIMARY KEY,"
            + "NOMBRE varchar(100) NOT NULL,"
            + "EMAIL varchar(100) NOT NULL,"
            + "SUELDO numeric(15, 2) NOT NULL"
            + ")";

    private static final String SQL_INSERT = "INSERT INTO USUARIO (ID, NOMBRE, EMAIL, SUELDO) VALUES"; //TODO FIJARSE
    private static final String SQL_UPDATE = "UPDATE USUARIO SET SUELDO=? WHERE EMAIL=?";

    public static void main(String[] args) {

        //3) creamos clase usuario que guardaremos en la bd
        Usuario usuario = new Usuario("Pedro","pedro@digitalhouse.com",100);

        //seteamos la conexion en null y lo capturamos en un try catch
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);

            //creada la tabla usamos un prepared statement
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

            //empiezo a insertar en la bd
            psInsert.setInt(1,1);
            psInsert.setString(2, usuario.getNombre());
            psInsert.setString(3, usuario.getEmail());
            psInsert.setDouble(4, usuario.getSueldo());

            psInsert.execute();

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);

        }
        //quede aca
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
