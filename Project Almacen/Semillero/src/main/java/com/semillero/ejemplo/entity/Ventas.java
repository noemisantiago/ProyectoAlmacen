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
@Table(name = "ventas")
public class Ventas {

    @Id
    @SequenceGenerator(name = "ID_VENTA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_VENTA")


    @Column(name="ID_VENTA")
    private Long id_Venta;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="FECHA")
    private LocalDate fecha;

    @Column(name="MONTO_TOTAL")
    private Float montoTotal;



    @Column(name="C_ACTIVACION")
    private Boolean cactivacion;
}