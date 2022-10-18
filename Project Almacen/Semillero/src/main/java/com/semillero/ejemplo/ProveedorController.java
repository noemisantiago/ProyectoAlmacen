package com.semillero.ejemplo;


import com.semillero.ejemplo.entity.Proveedor;
import com.semillero.ejemplo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda/proveedor/")
public class ProveedorController {

    @Autowired
    private ProveedorService service;

    @CrossOrigin(origins = "*")
    @PostMapping("add/")
    public Proveedor addProveedor(@RequestBody Proveedor proveedor) {

        return service.addProveedor(proveedor);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/{nombre_proveedor}")
    public Proveedor buscarPorNombre(@PathVariable(value = "nombre_proveedor")  String nombre_proveedor) {
        return service.buscarPorNombre(nombre_proveedor);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("listar")
    public List<Proveedor> buscarTodos() {
        return service.buscarTodos();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id_proveedor}")
    public String eliminarProveedorPorId(@PathVariable(value = "id_proveedor")  Long id_proveedor){
        service.eliminarProveedorPorId(id_proveedor);
        return "Proveedor eliminado";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/actualizar/{id_proveedor}")
    public String actualizarProveedorPorId(@RequestBody Proveedor proveedor,@PathVariable(value = "id_proveedor") Long id_proveedor){
        proveedor.setId_proveedor(id_proveedor);
        service.actualizarProveedorPorId(proveedor);
        return "Proveedor actualizado";
    }


}
