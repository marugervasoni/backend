package com.company.dao.impl;

import com.company.dao.IDao;
import com.company.dao.util.ConfiguracionJDBC;
import com.company.dao.util.GeneradorDeSentencias;
import com.company.dao.util.Util;
import com.company.model.Domicilio;
import com.company.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.company.dao.util.GeneradorDeSentencias.generarInsert;

public class PacienteDaoH2 implements IDao<Paciente> {

    private final static Logger logger = Logger.getLogger(PacienteDaoH2.class);
    private final static ConfiguracionJDBC jdbc = new ConfiguracionJDBC();
    private final static String TABLE = "pacientes";

    //instanciamos domicilioDaoH2 para poder utilizarlo:
    private DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();

    //sobreescribo metodos:
    @Override
    public Paciente guardar(Paciente paciente) {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            jdbc.cargarElControlador();
            logger.info("levantando driver");
            conexion = jdbc.conectarConBaseDeDatos();
            logger.info("conectando con la base de datos");

            //guardar previamente el domicilio del paciente porque lo necesitaremos:
            //obtengo el domic guardado con guardar de domicDaoH2 y lo almaceno en var domic
            Domicilio domicilio = domicilioDaoH2.guardar(paciente.getDomicilio());
            //llamo atrib domic de Paciente y le asigno el id de mi variable domicilio.
            paciente.getDomicilio().setId(domicilio.getId());

            //crear sentencia: especifico  id es autoincrement (c metodo returnGeneratedKeys de statement) y luego NO se lo pasamos:
            pstmt = conexion.prepareStatement("INSERT INTO " + TABLE + "(nombre,apellido,dni,fecha_ingreso,domicilio_id) " +
                    "VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            {
                //TODO ver si uso generador de sentencias en algun momento o borrar
                //String s = generarInsertParaTodosLosCampos();
                pstmt.setString(1, paciente.getNombre());
                pstmt.setString(2, paciente.getApellido());
                pstmt.setString(3, paciente.getDni());
                //covierto DATE en sql.date para que de java pase a sql, usando clase Util:
                pstmt.setDate(4, Util.utilDateToSqlDate(paciente.getFechaDeIngreso()));
                //paso FK del id de Domicilio al atrib domicilio de Paciente:
                pstmt.setInt(5, paciente.getDomicilio().getId()); //al atrib domic (de tipo Domic) de Paciente le pido el Id.

                //ejecuto sentencia y obtengo id autogenerado por metodo de statement
                pstmt.executeUpdate();
                logger.info("inserté nuevos registros en la tabla PACIENTES");
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.next())
                    paciente.setId(keys.getInt(1));

                pstmt.close();
            }

        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement: " + e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        Paciente paciente = null;

        try {
            jdbc.cargarElControlador();
            logger.info("levantando driver");
            conexion = jdbc.conectarConBaseDeDatos();
            logger.info("conectando con la base de datos");

            //crear sentencia select:
            pstmt = conexion.prepareStatement("SELECT id,nombre,apellido,dni,fecha_ingreso,domicilio_id FROM "+TABLE+" WHERE id = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            logger.info("buscando paciente con id: "+id);

            //obtener resultados
            while (rs.next()) {
                int idPaciente = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                    //seteo el tipo de dato date como sql
                java.sql.Date fechaIngreso = rs.getDate("fecha_Ingreso");
                int idDomicilio = rs.getInt("domicilio_id");

                    //Con el domicilio_id traemos el domicilio de la tabla domicilio a traves de DAO de Domicilios
                Domicilio domicilio = domicilioDaoH2.buscar(idDomicilio);
                paciente = new Paciente(idPaciente,nombre,apellido,dni,fechaIngreso,domicilio);
            }
            pstmt.close();

        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement" + e.getMessage());
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        List<Paciente> pacientes = new ArrayList<>();

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
                int idPaciente = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                //seteo el tipo de dato date como sql
                java.sql.Date fechaIngreso = rs.getDate("fecha_Ingreso");
                int idDomicilio = rs.getInt("domicilio_id");

                //Con el domicilio_id traemos el domicilio de la tabla domicilio a traves de DAO de Domicilios
                Domicilio domicilio = domicilioDaoH2.buscar(idDomicilio);
                Paciente paciente = new Paciente(idPaciente,nombre,apellido,dni,fechaIngreso,domicilio);
                pacientes.add(paciente);
                logger.info("agregando pacientes encontrados a lista pacientes");
            }
            pstmt.close();
        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement" + e.getMessage());
        }
        return pacientes;
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

            //crear sentencia delete y setear para el envio del idPaciente a eliminar
            pstmt = conexion.prepareStatement("DELETE FROM "+TABLE+"WHERE id = ?");
            pstmt.setInt(1,id);

            //ejecutar sentencia
            pstmt.executeUpdate();
            logger.info("eliminando paciente id: "+id);
            pstmt.close();

        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement" + e.getMessage());
        }
        //no retorno porque es void
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        try {
            jdbc.cargarElControlador();
            logger.info("levantando driver");
            conexion = jdbc.conectarConBaseDeDatos();
            logger.info("conectando con la base de datos");

            //previamente actualizar domicilio del paciente:
                //en mi variable domic invoco el metodo actualizar de domicDAOH2.
            Domicilio domicilio = domicilioDaoH2.actualizar(paciente.getDomicilio());

            //crear sentencia update:id autoincrement; luego NO se lo pasamos:
            pstmt = conexion.prepareStatement("UPDATE "+TABLE+"SET nombre=?, apellido=?, dni=?, fecha_ingreso=?, domicilio_id=?  WHERE id = ?");

            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApellido());
            pstmt.setString(3, paciente.getDni());
                //covierto DATE en sql.date:
            pstmt.setDate(4, Util.utilDateToSqlDate(paciente.getFechaDeIngreso()));
                //paso FK del id de Domicilio:
            pstmt.setInt(5, paciente.getDomicilio().getId()); //al atrib domic (de tipo Domic) de Paciente le pido el Id.
            pstmt.setInt(6, paciente.getId());

            //ejecuto sentencia y obtengo id autogenerado por metodo de statement
            pstmt.executeUpdate();
            logger.info("actualicé registros en la tabla PACIENTES");

            pstmt.close();

        } catch (SQLException e) {
            logger.error("hubo un problema con el prepared statement" + e.getMessage());
        }
            return paciente;
    }
}

    //metodos del generador de sentencias TODO: borrar?----------------------------------------------------------------------------------------------------------------------
//    private String generarInsertParaTodosLosCampos() {
//        return GeneradorDeSentencias.generarInsert(TABLE, List.of("id", "nombre", "apellido", "dni", "domicilio", "fechaDeIngreso"));
//    }
//    private String generarSelectParaTodosLosCampos() {
//        return GeneradorDeSentencias.generarSelectAll(TABLE);
//    }
//}
