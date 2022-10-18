package com.semillero.ejemplo.service;

import com.semillero.ejemplo.entity.Categoria_productos;

import java.util.List;

public interface Categoria_productosService {

    Categoria_productos addCategoria(Categoria_productos categoria_productos);

    Categoria_productos buscarCategoriaporNombre(String categoria);

    List<Categoria_productos> buscarCategorias();

    String eliminarCategoria(String categoria);

    String actualizarCategoria(Categoria_productos categoria_productos);

}
