package com.semillero.ejemplo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "membresia")
public class Membresia {

    @Id
    @SequenceGenerator(name = "ID_MEMBRESIA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MEMBRESIA")

    @Column(name="ID_MEMBRESIA")
    private Long id_membresia;
    @Column(name="NOMBRE_COMPLETO")
    private String nombre_completo;
    @Column(name="TELEFONO")
    private Long telefono;
    @Column(name="EDAD")
    private Long edad;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="FECHA_EXP")
    private LocalDate fecha_exp;


    @Column(name="TARJETA_C")
    private String tarjeta_c;

    @Column(name="CLAVE_MEMBRESIA", length=30, nullable=false, unique=true)
    private String claveMembresia;

    @Column(name="C_ACTIVACION")
    private Boolean cactivacion;
}