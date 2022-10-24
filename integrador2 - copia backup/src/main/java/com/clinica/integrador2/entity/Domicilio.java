package com.clinica.integrador2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Domicilios")
@Getter @Setter
public class Domicilio {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //@GeneratedValue (strategy =GenerationType.SEQUENCE)
    private Integer id;

    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}

