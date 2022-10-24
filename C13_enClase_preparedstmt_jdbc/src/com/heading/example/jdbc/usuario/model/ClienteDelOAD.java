package com.heading.example.jdbc.usuario.model;

import com.heading.example.jdbc.usuario.JdbcRepositoryManager;

public class ClienteDelOAD {

    public static void main(String[] args){
        JdbcRepositoryManager.hacerAlgo("jdbc:h2:~/test", "sa", "");
    }
}
