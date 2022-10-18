package com.semillero.ejemplo.service;

import com.semillero.ejemplo.entity.Producto;
import com.semillero.ejemplo.persistence.ResponseProducto;

import java.util.List;

public interface ProductoService {
    Producto addProducto(Producto producto);
    List<Producto> buscarProduPorCat(Long idCategoria);
    Producto buscarProduPorId(Long idProducto);
    List<ResponseProducto> buscarTodosProdu();
    String eliminarProduPorId(Long idProducto);
    void actualizarProducto(Producto producto);
}
