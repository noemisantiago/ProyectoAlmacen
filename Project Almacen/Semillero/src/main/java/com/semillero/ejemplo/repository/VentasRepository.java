package com.semillero.ejemplo.repository;

import com.semillero.ejemplo.entity.Ventas;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
    public interface VentasRepository extends JpaRepository<Ventas, Long> {
    List<Ventas> findByFecha (String fecha);

    List<Ventas> findByFechaBetween (LocalDate fecha1, LocalDate fecha2);
}