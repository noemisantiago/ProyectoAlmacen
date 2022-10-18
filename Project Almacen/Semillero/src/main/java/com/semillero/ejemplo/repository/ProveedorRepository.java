package com.semillero.ejemplo.repository;

import com.semillero.ejemplo.entity.Membresia;
import com.semillero.ejemplo.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    Proveedor findByNombreProveedor (String nombre_proveedor);
}