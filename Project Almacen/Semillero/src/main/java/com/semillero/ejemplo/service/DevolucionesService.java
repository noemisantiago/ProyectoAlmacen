package com.semillero.ejemplo.service;



import com.semillero.ejemplo.entity.Devoluciones;

import java.util.List;

public interface DevolucionesService {

    Devoluciones addDevolucion(Devoluciones devoluciones);

    Devoluciones buscarDevolucionporId(Long id_devolucion);

    List<Devoluciones> buscarDevByFecha(String fecha);

    List<Devoluciones> obtenerDevoluciones();

    String eliminarDevolucion(Long id_devolucion);

    String actualizarDevolucion(Devoluciones devoluciones);
}
