package com.clinica.integrador2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Turnos")
@Getter @Setter
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //1 a 1 --> c paciente
    @ManyToOne //(mappedBy = "turno")
    @JoinColumn(name = "paciente_id")//, nullable = false)
    private Paciente paciente;

    //M a 1 --> c odontologo
    @ManyToOne
    //(que atrib de mi tabla (odont) establece relac c otra tabla)
    @JoinColumn(name = "odontologo_id")//, nullable = false)
    private Odontologo odontologo;

    private LocalDate date;
}
