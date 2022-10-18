package com.semillero.ejemplo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "devoluciones")
public class Devoluciones {

    @Id
    @SequenceGenerator(name = "ID_DEVOLUCIONES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_DEVOLUCIONES")

    @Column(name = "ID_DEVOLUCION")
    private Long id_devolucion;
    @Column(name = "ID_PRODUCTO")
    private Long id_producto;
    @Column(name = "ID_VENTA")
    private Long id_venta;
    @Column(name = "VALOR_DEVOLUCION")
    private Long valor_devolucion;
    @Column(name = "MOTIVO")
    private String motivo;
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "CANTIDAD")
    private Long cantidad;
    @Column(name = "ID_SUCURSAL")
    private Long id_sucursal;

    @Column(name="C_ACTIVACION")
    private Boolean cactivacion;
}