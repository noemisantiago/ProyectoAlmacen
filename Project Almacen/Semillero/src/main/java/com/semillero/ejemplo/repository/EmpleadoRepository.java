package com.semillero.ejemplo.repository;

import com.semillero.ejemplo.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Empleado findByclvUsuario(String clvUsuario);

    @Transactional
    String deleteByclvUsuario(String clvUsuario);


}