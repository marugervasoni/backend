package com.company.dao.util;

import java.util.List;

//esta clase la voy a invocar en mis Dao cuando quiera: insertar datos, buscar, modificar, eliminar (CRUD):
public class GeneradorDeSentencias {

    //para insertar datos en las filas de mi tabla
    public static String generarInsert(String tabla, List<String> campos) {
        //si indices campo es menor que 1 retorno null
        if (campos.size() < 1){
            return null;
        }

        //caso que sea mayor, reemplazo ult caracter por signo y repito x cantid indice campos
        String cantidadCampos = sacarUltimoCaracter("?,".repeat(campos.size()));

        //creador de sentencia string
        StringBuilder sentencia = new StringBuilder("INSERT INTO " + tabla + " (");

        //cada campo de la lista campos lo ingreso en string builder
        for (String campo : campos) {
            sentencia.append(campo + ",");
        }

        //retorno mi sentencia creada pasada a string y agrego valores (reemplazando los ? x cada campo)
        return sacarUltimoCaracter(sentencia.toString()) + ") VALUES (" + cantidadCampos + ");";
    }

    //sentencias
        //para obtener todos los datos de la tabla
    public static String generarSelectAll(String tabla){
        return "SELECT * FROM " + tabla;
    }

        //obtener datos correspondientes al id x
    public static String generarSelectPorId(String tabla){
        return "SELECT * FROM " + tabla + " WHERE id = ?";
    }

        //obtener datos correspondientes al campo x
    public static String generarSelectPorCampo(String tabla){
        return "SELECT * FROM " + tabla + " WHERE ? = ?";
    }

        //borrar fila donde campo sea x
    public static String generarDeletePorCampo(String tabla) {
        return "DELETE FROM " + tabla + " WHERE ? = ?";
    }

    /**
     * Este método se encarga de generar un UPDATE SQL para PreparedStatement.
     * @param tabla
     * @param campos
     * @return
     * @throws Exception
     */

    //generar modificacion por id (paso tabla, lista de campos y arrojo excepcion)
    public static String generarUpdatePorId(String tabla, List<String> campos) throws Exception {
        //si indice de listaCampos es menor a uno (= null) arrojo excepcion
        if (campos.size() < 1) throw new Exception("No se puede generar un update sin campos");
        //caso contrario creo un builder para modificar tabla seteando:
        StringBuilder sentencia = new StringBuilder("UPDATE " + tabla + " SET ");
        //cada campo de listaCampos (agregandolo a mi sentencia update)
        for (String campo : campos) {
            sentencia.append(campo + "= ?,");
        }
        //finalmente retorno en string mi sentencia, y reemplazando los ? por el campo
        return sacarUltimoCaracter(sentencia.toString()) + " WHERE id = ?;";
    }

    //metodo que retorna un substring del string enviado(sentencia:
            //ejemplo: --- "UPDATE "+tabla(pacientes)+" SET "campo(id)+"= ?" --- )
        // -->con el contenido entre 0 y length(indice final del string) de sentencia - 1: --> es decir: "?"
    private static String sacarUltimoCaracter(String str) {
        return str.substring(0, str.length() - 1);
    }
}


