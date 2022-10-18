package com.semillero.ejemplo.service;

import com.semillero.ejemplo.entity.Empleado;

import java.util.List;

public interface EmpleadoService {

    Empleado addEmpleado(Empleado empleado);

    Empleado buscarEmpleadoporClave(String clvUsuario);

    List<Empleado> obtenerEmpleados();

    String eliminarEmpleado(String clvUsuario);

    String actualizarEmpleado(Empleado empleado);
}
