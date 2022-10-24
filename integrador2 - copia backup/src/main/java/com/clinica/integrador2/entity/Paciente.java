package com.clinica.integrador2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Pacientes")
@Getter @Setter
public class Paciente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id")
    private Domicilio domicilio;

    //1 a 1 --> c domicilio
    //1 a 1 --> c turno
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, )
//    @JoinColumn(name = "id_turno", referencedColumnName = "id")
//    private Turno turno; //lista?

    //SI ES set es oneToMany y le pongo un cascadeType remove
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Turno> turnos; //puedo buscar todos los turnos de un paciente x??


}
