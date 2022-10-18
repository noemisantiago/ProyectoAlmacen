package com.semillero.ejemplo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @SequenceGenerator(name = "ID_EMPLEADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_EMPLEADO")

    @Column(name = "ID_EMPLEADO")
    private Long id_empleado;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APE_P")
    private String ape_p;
    @Column(name = "APE_M")
    private String ape_m;
    @Column(name = "TELEFONO")
    private Long telefono;
    @Column(name = "PUESTO")
    private Long puesto;
    @Column(name = "ID_SUCURSAL")
    private Long id_sucursal;
    @Column(name = "CLV_USUARIO")
    private String clvUsuario;
    @Column(name = "PASSWORD_USER")
    private String password_user;

    @Column(name="C_ACTIVACION")
    private Boolean cactivacion;

    

}