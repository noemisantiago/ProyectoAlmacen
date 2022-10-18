package com.semillero.ejemplo;


import com.semillero.ejemplo.entity.Ventas;
import com.semillero.ejemplo.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tienda/ventas/")
public class VentasController {

    @Autowired
    private VentasService service;

    @CrossOrigin(origins = "*")
    @PostMapping("add/")
    public Ventas addVenta(@RequestBody Ventas venta) {
        return service.addVenta(venta);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/{id_Venta}")
    public Ventas buscarVentaPorId(@PathVariable(value = "id_Venta")  Long id_Venta) {
        return service.buscarVentaPorId(id_Venta);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/fecha/{fecha}")
    public List<Ventas> buscarVentaPorFecha(@PathVariable(value = "fecha") String fecha) {
        return service.buscarVentaPorFecha(fecha);
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/fechas/{fecha1}/{fecha2}")
    public List<Ventas> buscarVentaPorRangoFecha(@PathVariable(value = "fecha1") String fecha1, @PathVariable(value = "fecha2")String fecha2) {
        return service.buscarPorRangoFecha(LocalDate.parse(fecha1),LocalDate.parse(fecha2));
    }



    @CrossOrigin(origins = "*")
    @GetMapping("listar")
    public List<Ventas> buscarTodos() {
        return service.buscarTodos();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id_Venta}")
    public String eliminarVentaPorId(@PathVariable(value = "id_Venta")  Long id_Venta){
        service.eliminarVentaPorId(id_Venta);
        return "Venta eliminada";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/actualizar/{id_Venta}")
    public String actualizarVenta(@RequestBody Ventas venta,@PathVariable(value = "id_Venta") Long id_Venta){
        venta.setId_Venta(id_Venta);
        service.actualizarVenta(venta);
        return "Venta actualizada";
    }

}
