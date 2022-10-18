package com.semillero.ejemplo.repository;

import com.semillero.ejemplo.entity.RepVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepVentasRepository extends JpaRepository<RepVentas, Long> {

    List<RepVentas> findByidProducto(Long id_producto);
}