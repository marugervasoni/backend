package com.clinica.integrador2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Odontologos")
@Getter @Setter
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private Integer matricula;

    //1 a M --> c turno
    @OneToMany(mappedBy = "odontologo") //fetch lazy por defecto
    @JsonIgnore //x bidireccional p que el JSON no entre en bucle infinito
    private Set<Turno> turnos;


}
