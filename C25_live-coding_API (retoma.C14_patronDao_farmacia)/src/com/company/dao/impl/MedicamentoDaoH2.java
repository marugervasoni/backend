package com.company.dao.impl;

import com.company.dao.IDao;
import com.company.dao.util.ConfiguracionJDBC;
import com.company.dao.util.GeneradorDeSentencias;
import com.company.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//5)
//*agregar al proyecto las dependencias de H2, y log4j (y para este el file).
//debo implementar la interface dao (y setear el generics) para sobreescribir los metodos
public class MedicamentoDaoH2  implements IDao<Medicamento> {

    //invoco el logger
    private final static Logger logger = Logger.getLogger(MedicamentoDaoH2.class);

    //A) en otra clase (en util) tenemos seteada la configuracion de JDBC y aca la instanciamos
    private final static ConfiguracionJDBC jdbc = new ConfiguracionJDBC(); //configuracion; conexion; cargar controlador.
    //B) seteo el nombre de mi tabla de la BD
    private final static String TABLE = "medicamentos";

    //sobreescribo metodos IDao

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        jdbc.cargarElControlador();

        //Intentar conectar con la BD y mandar mi query insert en una pstmt:
        try (Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO "+TABLE+"(id, codigo-numerico, nombre, laboratorio, cantidad, precio)"+
        "VALUES(?,?,?,?,?,?)")) {

            //aca agrego los valores de cada ? en mi pstmt
            String s = generarInsertParaTodosLosCampos();
            pstmt.setInt(1,medicamento.getId()); //este lo agregue cuando desconfigure autoincremental
            pstmt.setInt(2, medicamento.getCodigoNumerico());
            pstmt.setString(3, medicamento.getNombre());
            pstmt.setString(4, medicamento.getLaboratorio());
            pstmt.setInt(5, medicamento.getCantidad());
            pstmt.setDouble(6, medicamento.getPrecio());

            pstmt.executeUpdate(); //ejecuta la modificacion de tabla

        } catch (SQLException e) {
            //si no funciona la ejecucion, arroja el error en un logger y retorna null
           logger.error(e.getMessage());
           return null;
        }

        //caso de exito; retornamos medicamento updateado
        return  medicamento;
    }

    @Override
    public Medicamento buscar(Integer id) {
        jdbc.cargarElControlador();
        Medicamento respuesta = null; //la respuesta de mi query comienza en null

        //intentar conectar con h2 y mandar una query
        try (Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM"+TABLE+"WHERE id = ?")) {

            //paso como parametro el id del medicamento que quiero buscar con mi query
            pstmt.setInt(1,id);

            //ejecuto mi query
            ResultSet rs = pstmt.executeQuery();

            //recorro los resultados de result set y voy seteando los valores que obtengo para dar mas legibilidad
            if (rs.next()){
                respuesta = new Medicamento(rs.getInt("id"),
                                            rs.getInt("codigo_numerico"),
                                            rs.getString("nombre"),
                                            rs.getString("laboratorio"),
                                            rs.getInt("cantidad"),
                                            rs.getDouble("precio"));
            }
            //si no tengo resultados porque no funcionó o x, muestro un logger del error
            } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        //retornamos la respuesta a la busqueda si fue exitoso o si esta en null
        return respuesta;
    }

    //metodo que conecta el util de generador de sentencias
    private String generarInsertParaTodosLosCampos(){
        return GeneradorDeSentencias.generarInsert(TABLE, List.of("codigo_numerico","nombre","laboratorio","cantidad","precio"));
    }
}
