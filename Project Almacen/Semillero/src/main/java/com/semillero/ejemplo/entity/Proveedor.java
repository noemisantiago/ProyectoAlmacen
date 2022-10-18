package com.semillero.ejemplo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @SequenceGenerator(name = "ID_PROVEEDOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PROVEEDOR")

    @Column(name="ID_PROVEEDOR")
    private Long id_proveedor;
    @Column(name="NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Column(name="DIRECCION")
    private String direccion;
    @Column(name="TELEFONO")
    private Long telefono;

    @Column(name="C_ACTIVACION")
    private Boolean cactivacion;

}