package com.semillero.ejemplo.repository;

import com.semillero.ejemplo.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {


    Sucursal findByclvSuc(String clvSuc);

    //@Transactional
    //long deleteByClv_sucursal(String clv_suc);
}