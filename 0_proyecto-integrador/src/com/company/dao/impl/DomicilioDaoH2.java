package com.company.dao.impl;

import com.company.dao.IDao;
import com.company.dao.util.ConfiguracionJDBC;
import com.company.model.Domicilio;
import com.company.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    private final static Logger logger = Logger.getLogger(PacienteDaoH2.class);
    private final static ConfiguracionJDBC jdbc = new ConfiguracionJDBC();
    private final static String TABLE = "domicilios";

    //sobreescribo metodos
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            //levantar driver y conectar
            jdbc.cargarElControlador();
            logger.info("levantando driver");
            conexion = jdbc.conectarConBaseDeDatos();
            logger.info("conectando con la base de datos");

            //crear sentencia: especificamos que id es autoincrement (usando metodo returnGeneratedKeys de statement) y luego NO se lo pasamos:
            pstmt = conexion.prepareStatement("INSERT INTO "+TABLE+"(calle, numero,localidad,provincia) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,domicilio.getCalle());
            pstmt.setString(2,domicilio.getNumero());
            pstmt.setString(3,domicilio.getLocalidad());
            pstmt.setString(4,domicilio.getProvincia());

            //ejecuto sentencia y obtengo id autogenerado por metodo de statement
            pstmt.executeUpdate();
            logger.info("inserté nuevos registros en tabla DOMICILIOS");
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) //-->siempre que hayan mas keys (ids): insertar como id (setId) en domicilio una vez que lo tengas(getId) de statement
                domicilio.setId(keys.getInt(1));

            pstmt.close();

        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement" + e.getMessage());
        }
        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        Domicilio domicilio = null;

        try {
            jdbc.cargarElControlador();
            logger.info("levantando driver");
            conexion = jdbc.conectarConBaseDeDatos();
            logger.info("conectando con la base de datos");

            //crear sentencia select y ejecutarla:
            pstmt = conexion.prepareStatement("SELECT id,calle,numero,localidad,provincia FROM "+TABLE+" WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            logger.info("buscando paciente con id: "+id);

            //obtener resultados
            while (rs.next()) {
                int idDomicilio = rs.getInt("id");
                String calle = rs.getString("calle");
                String numero = rs.getString("numero");
                String localidad = rs.getString("localidad");
                String provincia = rs.getString("provincia");

                domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);
            }
            pstmt.close();

        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement" + e.getMessage());
        }
        return domicilio;
    }
    @Override
    public List<Domicilio> buscarTodos() {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        List<Domicilio> domicilios = new ArrayList<>();

        try {
            jdbc.cargarElControlador();
            logger.info("levantando driver");
            conexion = jdbc.conectarConBaseDeDatos();
            logger.info("conectando con la base de datos");

            //crear sentencia select y ejecutarla:
            pstmt = conexion.prepareStatement("SELECT * FROM "+TABLE);
            ResultSet rs = pstmt.executeQuery();
            logger.info("ejecutando sentencia");

            //obtener resultados
            while (rs.next()) {
                int idDomicilio = rs.getInt("id");
                String calle = rs.getString("calle");
                String numero = rs.getString("numero");
                String localidad = rs.getString("localidad");
                String provincia = rs.getString("provincia");

                Domicilio domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);
                domicilios.add(domicilio);
            }
            pstmt.close();

        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement" + e.getMessage());
        }
        return domicilios;
    }


    @Override
    public void eliminar(Integer id) {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            jdbc.cargarElControlador();
            logger.info("levantando driver");
            conexion = jdbc.conectarConBaseDeDatos();
            logger.info("conectando con la base de datos");

            //crear sentencia delete y setear para el envio del idDomicilio a eliminar
            pstmt = conexion.prepareStatement("DELETE FROM "+TABLE+"WHERE id = ?");
            pstmt.setInt(1,id);

            //ejecutar sentencia
            pstmt.executeUpdate();
            logger.info("eliminando domicilio id: "+id);
            pstmt.close();

        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement" + e.getMessage());
        }
        //no retorno porque es void
    }


    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            jdbc.cargarElControlador();
            logger.info("levantando driver");
            conexion = jdbc.conectarConBaseDeDatos();
            logger.info("conectando con la base de datos");

            //creamos sentencia UPDATE pero NO pasamos id:
            pstmt = conexion.prepareStatement("UPDATE "+TABLE+" SET calle = ?, numero = ? ,localidad = ?, provincia = ?  WHERE id = ?");

            pstmt.setString(1,domicilio.getCalle());
            pstmt.setString(2, domicilio.getNumero());
            pstmt.setString(3, domicilio.getLocalidad());
            pstmt.setString(4, domicilio.getProvincia());
            pstmt.setInt(5, domicilio.getId());

            //ejecuto sentencia y obtengo id autogenerado por metodo de statement
            pstmt.executeUpdate();
            logger.info("atualicé registros en tabla DOMICILIOS");

            pstmt.close();


        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement" + e.getMessage());
        }
        return domicilio;
    }
}
