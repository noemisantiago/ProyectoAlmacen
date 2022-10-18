package com.semillero.ejemplo.service;

import com.semillero.ejemplo.entity.Membresia;

import java.util.List;

public interface MembresiaService {

    Membresia addMembresia(Membresia membresia);
    Membresia buscarPorClave(String clave_membresia);
    List<Membresia> buscarTodos();
    String eliminarMembresiaPorClave(String clave_membresia);
    void actualizarMembresia(Membresia membresia);

}
