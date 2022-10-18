package com.semillero.ejemplo.service;

import com.semillero.ejemplo.entity.RepVentas;

import java.util.List;

public interface RepVentasService {
    RepVentas addVenta(RepVentas repVenta);
    RepVentas buscarVentaPorId(Long id_Venta);
    List<RepVentas> buscarVentaPorId_Producto(Long id_producto);
    List<RepVentas> buscarTodos();
    String eliminarVentaPorId(Long id_Venta);
    void actualizarVenta(RepVentas repventa);

}
