package com.semillero.ejemplo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "REP_VENTAS")
public class RepVentas {

    @Id

    @Column(name="ID_VENTA")
    private Long id_Venta;

    @Column(name="ID_PRODUCTO")
    private Long idProducto;

    @Column(name="CANTIDAD")
    private Long cantidad;

    @Column(name="MONTO")
    private Float monto;


    @Column(name="C_ACTIVACION")
    private Boolean cactivacion;

}