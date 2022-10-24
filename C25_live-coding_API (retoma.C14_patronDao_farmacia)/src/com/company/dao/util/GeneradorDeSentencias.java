package com.company.dao.util;

import java.util.List;

//7)
public class GeneradorDeSentencias {

    //creo el metodo generar insert
    public static String generarInsert(String tabla, List<String> campos) {

        //si el numero de campos es menor a 1, retorná null
        if (campos.size() < 1){
            return null;
        }
        //reemplaza los signos ? por el valor que llega/envia
        String cantidadCampos = sacarUltimoCaracter("?,".repeat(campos.size()));

        //genera string para realizar inserts
        StringBuilder sentencia = new StringBuilder("INSERT INTO " + tabla + " (");

        //por cada campo del string con campos, agrega el campo a la sentencia y separa por coma
        for (String campo : campos) {
            sentencia.append(campo + ",");
        }

        //retorna el metodo que por parametro recibe un toString
        return sacarUltimoCaracter(sentencia.toString()) + ") VALUES (" + cantidadCampos + ");";
    }

    //querys seteadas para utilizar
    public static String generarSelectAll(String tabla){
        return "SELECT * FROM " + tabla;
    }

    public static String generarSelectPorId(String tabla){
        return "SELECT * FROM " + tabla + " WHERE id = ?";
    }

    public static String generarSelectPorCampo(String tabla){
        return "SELECT * FROM " + tabla + " WHERE ? = ?";
    }

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
    public static String generarUpdatePorId(String tabla, List<String> campos) throws Exception {
        if (campos.size() < 1) throw new Exception("No se puede generar un update sin campos");
        StringBuilder sentencia = new StringBuilder("UPDATE " + tabla + " SET ");
        for (String campo : campos) {
            sentencia.append(campo + "= ?,");
        }
        return sacarUltimoCaracter(sentencia.toString()) + " WHERE id = ?;";
    }

    private static String sacarUltimoCaracter(String str) {
        return str.substring(0, str.length() - 1);
    }
}


