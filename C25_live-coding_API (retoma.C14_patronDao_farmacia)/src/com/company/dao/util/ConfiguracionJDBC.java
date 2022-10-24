package com.company.dao.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//A)6)
public class ConfiguracionJDBC {

    //atributos
    private String jdbcDriver;
    private String dbUrl;
    private String nombreUsuario;
    private String contrasenaUsuario;

    //voy a usar loggers
    public static Logger logger = Logger.getLogger(ConfiguracionJDBC.class);

    //Podemos usar este constructor para conectarnos con otra configuracion
    public ConfiguracionJDBC(String jdbcDriver, String dbUrl, String nombreUsuario, String contrasenaUsuario) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    //mi configuracion para mi bd en H2----------------------------------------------
    public ConfiguracionJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/db_farmacia;INIT=RUNSCRIPT FROM 'create.sql'"; //INIT=RUNSCRIPT FROM 'create.sql'"
        this.nombreUsuario = "sa";
        this.contrasenaUsuario = "";
    }

    //Cnectar con la BD
    public Connection conectarConBaseDeDatos() {
        Connection connection = null; //arranca la conexion en null
        try {
            //intento obtener una conexion pasando mis datos de config de la BD
            connection = DriverManager.getConnection(dbUrl, nombreUsuario, contrasenaUsuario);
        } //si no puedo conectar: arrojo excepcion
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //si salio ben, retorno la conexion satisfactoriamente, sino la retornara en null
        return connection;
    }

    //cargarcontrolador
    public void cargarElControlador(){
        try {
            //Intentar, pasando la url de H2
            Class.forName(this.jdbcDriver);
        }
        //si no funciona, arrojar un logger y mostrarporconsola que fallo (exit 1)
        catch(ClassNotFoundException ex) {
            logger.error("Error: unable to load driver class! " + ex.getMessage());
            System.exit(1);
        }
    }

}
