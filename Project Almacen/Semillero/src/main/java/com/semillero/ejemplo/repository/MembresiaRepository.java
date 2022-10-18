package com.semillero.ejemplo.repository;

import com.semillero.ejemplo.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {


    Membresia findByClaveMembresia (String clave_membresia);

    @Transactional
    long deleteByClaveMembresia (String clave_membresia);

}