package com.heading.example.jdbc.usuario;

public class SentenciasSQL {

    public final static String SQL_CREATE = "CREATE TABLE IF NOT EXISTS usuarios (id INT AUTO_INCREMENT PRIMARY KEY, " +
            "nombre VARCHAR(20)," +
            "apellido VARCHAR(20)," +
            "edad INT)";
    public static final String SQL_PREPARED_QUERY = "SELECT * FROM usuarios WHERE nombre = ?";
    private final static String SQL_INSERT = "INSERT INTO usuarios(nombre, apellido, edad) VALUES(";
    public final static String SQL_DROP = "ALTER TABLE usuarios " +
            "DROP COLUMN apellido";
    public static final String SQL_QUERY = "SELECT * FROM usuarios";

    public static String generarInsertParaUsuarios(String nombre, String apellido, Integer edad){
        return SQL_INSERT + nombre + ", " + apellido + ", " + edad +")";
    }
}
