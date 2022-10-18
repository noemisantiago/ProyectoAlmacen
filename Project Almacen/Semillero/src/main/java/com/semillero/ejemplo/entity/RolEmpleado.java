package com.semillero.ejemplo.entity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "ROL")
public class RolEmpleado {
    @Id
    @SequenceGenerator(name = "ID_ROL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ROL")

    @Column(name = "ID_ROL")
    private Long id_rol;
    @Column(name = "ROL")
    private String rol;



}
