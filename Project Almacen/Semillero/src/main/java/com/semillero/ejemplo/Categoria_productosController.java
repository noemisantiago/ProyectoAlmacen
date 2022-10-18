package com.semillero.ejemplo;

import com.semillero.ejemplo.entity.Categoria_productos;
import com.semillero.ejemplo.service.Categoria_productosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tienda/CategoriaProduc/")
public class Categoria_productosController {

    @Autowired
    private Categoria_productosService service;

    @CrossOrigin(origins = "*")
    @PostMapping("add/")
    public Categoria_productos addCategoria(@RequestBody Categoria_productos categoria_productos) {
        return service.addCategoria(categoria_productos);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/{categoria}")
    public Categoria_productos buscarCategoriaporNombre(@PathVariable(value = "categoria") String categoria) {
        return service.buscarCategoriaporNombre(categoria);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("listar")
    public List<Categoria_productos> buscarTodos() {

        return service.buscarCategorias();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{categoria}")
    public String eliminarCategoria(@PathVariable(value = "categoria")  String categoria){
        service.eliminarCategoria(categoria);
        return "Membresia eliminada";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/actualizar/{id_categoria}")
    public String actualizarProductoCodigo(@RequestBody Categoria_productos categoria_productos,@PathVariable(value = "id_categoria") Long id_categoria){
        categoria_productos.setId_categoria(id_categoria);
        service.actualizarCategoria(categoria_productos);
        return "Membresia actualizada";
    }
}
