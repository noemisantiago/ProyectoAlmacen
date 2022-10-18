package com.semillero.ejemplo.repository;

import com.semillero.ejemplo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    List<Producto> findByidCategoria(Long idCategoria);
}