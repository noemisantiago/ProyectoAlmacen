package com.semillero.ejemplo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @SequenceGenerator(name = "ID_SUCURSAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SUCURSAL")

    @Column(name = "ID_SUCURSAL")
    private Long id_sucursal;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "ESTADO")
    private  String estado;
    @Column(name = "CLV_SUC")
    private String clvSuc;

    @Column(name="C_ACTIVACION")
    private Boolean cactivacion;
}