package com.semillero.ejemplo.repository;

import com.semillero.ejemplo.entity.Devoluciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DevolucionesRepository extends JpaRepository<Devoluciones, Long> {
    List<Devoluciones> findByFecha(String fecha);

}