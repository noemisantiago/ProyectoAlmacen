package com.semillero.ejemplo.service;

import com.semillero.ejemplo.entity.Proveedor;

import java.util.List;

public interface ProveedorService {

    Proveedor addProveedor(Proveedor proveedor);
    Proveedor buscarPorNombre(String nombre_proveedor);
    List<Proveedor> buscarTodos();
    String eliminarProveedorPorId(Long id_proveedor);
    void actualizarProveedorPorId(Proveedor proveedor);
}
