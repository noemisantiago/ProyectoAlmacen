package com.semillero.ejemplo.service;

import com.semillero.ejemplo.entity.Sucursal;

import java.util.List;

public interface SucursalService {

    Sucursal addSucursal(Sucursal sucursal);

    Sucursal buscarporClaveSuc(String clv_suc);

    List<Sucursal> obtenerSucursales();


    //List<Sucursal> findAllOrder();

    String eliminarSucursal(Long id_sucursal);

    String actualizarSucursal(Sucursal sucursal);
}
