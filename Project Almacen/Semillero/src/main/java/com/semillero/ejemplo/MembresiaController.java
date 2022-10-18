package com.semillero.ejemplo;

import com.semillero.ejemplo.service.MembresiaService;

import com.semillero.ejemplo.entity.Membresia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("membresias/")
public class MembresiaController {

    @Autowired
    private MembresiaService service;

    @CrossOrigin(origins = "*")
    @PostMapping("add")
    public Membresia addMembresia(@RequestBody Membresia membresia) {
        return service.addMembresia(membresia);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/{clave_membresia}")
    public Membresia buscarPorClave(@PathVariable(value = "clave_membresia")  String clave_membresia) {
        return service.buscarPorClave(clave_membresia);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("listar")
    public List<Membresia> buscarTodos() {
        return service.buscarTodos();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("delete/{clave_membresia}")
    public String eliminarMembresiaPorClave(@PathVariable(value = "clave_membresia")  String clave_membresia){
        service.eliminarMembresiaPorClave(clave_membresia);
        return "Membresia eliminada";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("actualizar/{clave_membresia}")
    public String actualizarProductoCodigo(@RequestBody Membresia membresia,@PathVariable(value = "clave_membresia") String clave_membresia){
        membresia.setClaveMembresia(clave_membresia);
        service.actualizarMembresia(membresia);
        return "Membresia actualizada";
    }



}
