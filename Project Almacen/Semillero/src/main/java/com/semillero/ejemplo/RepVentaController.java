package com.semillero.ejemplo;

import com.semillero.ejemplo.entity.RepVentas;
import com.semillero.ejemplo.service.RepVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda/repVentas/")
public class RepVentaController {

    @Autowired
    private RepVentasService service;

    @CrossOrigin(origins = "*")
    @PostMapping("add/")
    public RepVentas addVenta(@RequestBody RepVentas repVentas) {
        return service.addVenta(repVentas);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/{id_Venta}")
    public RepVentas buscarVentaPorId(@PathVariable(value = "id_Venta")  Long id_Venta) {
        return service.buscarVentaPorId(id_Venta);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/ventasIdProducto/{id_producto}")
    public List<RepVentas> buscarVentaPorId_Producto(@PathVariable(value = "id_producto")  Long id_producto) {
        return service.buscarVentaPorId_Producto(id_producto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/all")
    public List<RepVentas> buscarTodos() {
        return service.buscarTodos();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id_Venta}")
    public String eliminarVentaPorId(@PathVariable(value = "id_Venta")  Long id_Venta){
        service.eliminarVentaPorId(id_Venta);
        return "Reporte de Venta eliminada";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/actualizar/{id_Venta}")
    public String actualizarVenta(@RequestBody RepVentas repVenta,@PathVariable(value = "id_Venta") Long id_Venta){
        repVenta.setId_Venta(id_Venta);
        service.actualizarVenta(repVenta);
        return "Reporte de Venta actualizada";
    }

}
