package com.heading.example.jdbc.usuario;

import org.apache.log4j.Logger;

import java.sql.*;

public class JdbcRepositoryManager {

    public static Logger logger = Logger.getLogger(JdbcRepositoryManager.class);

    public static void hacerAlgo(String url, String usuario, String contraseña) {
        cargarElControlador();

        Connection conexión = null;

        try{

            conexión = generarConexión(url, usuario, contraseña);
            Statement stmt = conexión.createStatement();
            PreparedStatement pStmt = conexión.prepareStatement(SentenciasSQL.SQL_PREPARED_QUERY);

            pStmt.setString(1, "Juan OR 1 == 1");

            conexión.setAutoCommit(false);

            stmt.execute(SentenciasSQL.SQL_CREATE);
            stmt.execute(SentenciasSQL.SQL_DROP);
            int registrosModificados = stmt.executeUpdate(SentenciasSQL.generarInsertParaUsuarios("Daniel", "Ricciardo", 30));

            if(registrosModificados == 1){ //Este bloque if es para simular un error que no asociado con SQL.
                conexión.rollback();
                throw new CustomException("");
            }

            ResultSet rs = stmt.executeQuery(SentenciasSQL.SQL_QUERY);

            logger.info(rs.next() ? rs.getString("apellido") : "La tabla está vacía");


            conexión.commit();
            conexión.setAutoCommit(true);

            /* Mas operaciones con SQL */

        } catch (SQLException ex) {
            try {
                conexión.rollback();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
            logger.error(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexión != null){
                try {
                    conexión.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void cargarElControlador(){
        try {
            Class.forName("org.h2.Driver");
        }
        catch(ClassNotFoundException ex) {
            logger.error("Error: unable to load driver class!");
            System.exit(1);
        }
    }

    public static Connection generarConexión(String url, String usuario, String contraseña) throws SQLException {
        return DriverManager.getConnection(url, usuario, contraseña);
        //Mas tareas
    }
}
