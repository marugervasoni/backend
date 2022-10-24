package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {

    public static void main(String[] args) throws Exception {

        //hago nueva instancia del driver
        Class.forName("org.h2.Driver").newInstance();
        //armo objeto conexion
        Connection connection = DriverManager.getConnection("jdbc:h2:"+ "./dejameprobar","sa","");
        //conectados ya podemos crear objetos statement
        Statement stmt = connection.createStatement();

        //creacion de tablas:
            //string para ingresar mi sentencia, buena practica comenzar con drop
        String createTable = "DROP TABLE IF EXISTS TEST; CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255))";
        stmt.execute(createTable); //-->ejecutamos la sentencia

        //insertar filas
            //creamos otro string
        String insertarFila = "INSERT INTO TEST VALUES(1,'HOLA')";
        String insertarFila2 = "INSERT INTO TEST VALUES(2,'CHAU')";
            //las ejecutamos
        stmt.execute(insertarFila);
        stmt.execute(insertarFila2);

        //sentencia query para obtener datos
        String sql = "SELECT * FROM TEST";
            //ejecutamos pero teniendo en cuenta que es query y que nos devuelva un result
        ResultSet rd = stmt.executeQuery(sql);
            //lo iteramos mientras tenga prox elemento:
        while(rd.next()){
            //imprimo por consola el primer elemento(id) y el segundo (nombre)
            System.out.println(rd.getInt(1)+rd.getString(2));
        }
    }
}
