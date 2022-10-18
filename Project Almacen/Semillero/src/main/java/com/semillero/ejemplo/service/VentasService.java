package com.semillero.ejemplo.service;

import com.semillero.ejemplo.entity.Ventas;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface VentasService {

    Ventas addVenta(Ventas venta);
    Ventas buscarVentaPorId(Long id_Venta);

    List<Ventas> buscarVentaPorFecha(String fecha);


    List<Ventas> buscarPorRangoFecha(LocalDate fecha1, LocalDate fecha2);

    List<Ventas> buscarTodos();
    String eliminarVentaPorId(Long id_Venta);
    void actualizarVenta(Ventas venta);
}
