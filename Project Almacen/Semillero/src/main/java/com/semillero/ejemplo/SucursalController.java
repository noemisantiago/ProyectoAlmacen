package com.semillero.ejemplo;


import com.semillero.ejemplo.entity.Sucursal;
import com.semillero.ejemplo.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tienda/sucursal/")
public class SucursalController {

    @Autowired
    private SucursalService service;

    @CrossOrigin(origins = "*")
    @PostMapping("add/")
    public Sucursal addSucursal(@RequestBody Sucursal sucursal) {
        return service.addSucursal(sucursal);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/{clv_suc}")
    public Sucursal buscarporClaveSuc(@PathVariable(value = "clv_suc") String clv_suc) {
        return  service.buscarporClaveSuc(clv_suc);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("listar")
    public List<Sucursal> obtenerSucursales() {

        return service.obtenerSucursales();

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id_sucursal}")
    public String eliminarSucursal(@PathVariable(value = "id_sucursal")  Long id_sucursal){
        service.eliminarSucursal(id_sucursal);
        return "Sucursal eliminada";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("actualizar/{id_sucursal}")
    public String actualizarProductoCodigo(@RequestBody Sucursal sucursal,@PathVariable(value = "id_sucursal") Long id_sucursal){
        sucursal.setId_sucursal(id_sucursal);
        service.actualizarSucursal(sucursal);
        return "Sucursal actualizada";
    }
}
