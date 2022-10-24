package com.company.dao.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//esta clase la voy a invocar en mis Dao cuando quiere generar la conexion con mi BD
public class ConfiguracionJDBC {

    //atributos
    private String jdbcDriver;
    private String dbUrl;
    private String nombreUsuario;
    private String contrasenaUsuario;

    public static Logger logger = Logger.getLogger(ConfiguracionJDBC.class);

    //Constructor para conectarnos con otra configuracion
    public ConfiguracionJDBC(String jdbcDriver, String dbUrl, String nombreUsuario, String contrasenaUsuario) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    //constructor para conectar con h2
    public ConfiguracionJDBC() {
        this.jdbcDriver = "org.h2.Driver";
            //iniciamos la creacion de nuestra tabla desde acá (init ruscript)
        this.dbUrl = "jdbc:h2:~/db_clinicaDental;INIT=RUNSCRIPT FROM 'create.sql'";
        this.nombreUsuario = "sa";
        this.contrasenaUsuario = "";
    }

    //metodos:
        //armar objeto conexion
    public Connection conectarConBaseDeDatos() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nombreUsuario, contrasenaUsuario);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
        //nueva instancia del driver
    public void cargarElControlador(){
        try {
            Class.forName(this.jdbcDriver);
        }
        catch(ClassNotFoundException ex) {
            logger.error("Error: unable to load driver class! " + ex.getMessage());
            System.exit(1);
        }
    }

}
