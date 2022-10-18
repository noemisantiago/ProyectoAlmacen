package com.semillero.ejemplo.repository;

import com.semillero.ejemplo.entity.Categoria_productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Categoria_productosRepository extends JpaRepository<Categoria_productos, Integer> {

    Categoria_productos findByCategoria(String categoria);

    @Transactional
    long deleteByCategoria(String categoria);
}