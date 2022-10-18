package com.semillero.ejemplo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "categoria_productos")
public class Categoria_productos {
    @Id
    @SequenceGenerator(name = "ID_CATEGORIA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CATEGORIA")

    @Column(name = "ID_CATEGORIA")
    private Long id_categoria;
    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name="C_ACTIVACION")
    private Boolean cactivacion;
}