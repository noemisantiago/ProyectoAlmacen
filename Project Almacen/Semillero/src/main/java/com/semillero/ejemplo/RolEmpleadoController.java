package com.semillero.ejemplo;

import com.semillero.ejemplo.entity.Empleado;
import com.semillero.ejemplo.entity.RolEmpleado;
import com.semillero.ejemplo.service.RolEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("tienda/Rol/")
public class RolEmpleadoController {

    @Autowired
    private RolEmpleadoService service;

    @CrossOrigin(origins = "*")
    @GetMapping("/listarol")
    public List<RolEmpleado> buscarTodos(){
        return service.buscarTodos();
    }



}