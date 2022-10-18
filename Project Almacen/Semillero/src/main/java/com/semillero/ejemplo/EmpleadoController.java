package com.semillero.ejemplo;


import com.semillero.ejemplo.entity.Empleado;
import com.semillero.ejemplo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tienda/Empleados/")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @CrossOrigin(origins = "*")
    @PostMapping("add/")
    public Empleado addEmpleado(@RequestBody Empleado empleado) {
        return service.addEmpleado(empleado);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/{clvUsuario}")
    public Empleado buscarEmpleadoporClave(@PathVariable(value = "clvUsuario") String clvUsuario) {
        return service.buscarEmpleadoporClave(clvUsuario);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("listar")
    public List<Empleado> obtenerEmpleados() {

        return service.obtenerEmpleados();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{clvUsuario}")
    public String eliminarCategoria(@PathVariable(value = "clvUsuario")  String clvUsuario){
        service.eliminarEmpleado(clvUsuario);
        return "Empleado eliminado";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/actualizar/{id_empleado}")
    public String actualizarEmpleado(@RequestBody Empleado empleado,@PathVariable(value = "id_empleado") Long id_empleado){
        empleado.setId_empleado(id_empleado);
        service.actualizarEmpleado(empleado);
        return "Empleado actualizado";
    }
}
