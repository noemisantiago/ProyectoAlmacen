package com.semillero.ejemplo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @SequenceGenerator(name = "ID_PRODUCTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRODUCTO")

    @Column(name="ID_PRODUCTO")
    private Long id_Producto;

    @Column(name="ID_CATEGORIA")
    private Long idCategoria;

    @Column(name="CONTENIDO")
    private String contenido;

    @Column(name="ID_SUCURSAL")
    private Long idSucursal;

    @Column(name="TIPO_UNIDAD")
    private String tipoUnidad;

    @Column(name="ID_PROVEEDOR")
    private Long idProveedor;

    @Column(name="PRECIO_PROVEEDOR")
    private Float precioProveedor;

    @Column(name="PRECIO_MENUDEO")
    private Float precioMenudeo;

    @Column(name="PRECIO_MAYOREO")
    private Float precioMayoreo;

    @Column(name="F_CADUCIDAD")
    private LocalDate fCaducidad;

    @Column(name="EXISTENCIA")
    private Long existencia;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="C_ACTIVACION")
    private Boolean cactivacion;


}