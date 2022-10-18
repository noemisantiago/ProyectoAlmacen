package com.semillero.ejemplo;

import com.semillero.ejemplo.entity.Devoluciones;
import com.semillero.ejemplo.service.DevolucionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tienda/Devoluciones/")
public class DevolucionesController {

    @Autowired
    private DevolucionesService service;

    @CrossOrigin(origins = "*")
    @PostMapping("add/")
    public Devoluciones addDevolucion(@RequestBody Devoluciones devoluciones) {
        return service.addDevolucion(devoluciones);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/{id_devolucion}")
    public Devoluciones buscarDevolucionporId(@PathVariable(value = "id_devolucion") Long id_devolucion) {
        return service.buscarDevolucionporId(id_devolucion);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("buscarFecha/{fecha}")
    public List<Devoluciones> buscarDevByFecha(@PathVariable(value = "fecha") String fecha) {
        System.out.println(fecha);
        return service.buscarDevByFecha(fecha);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("listar")
    public List<Devoluciones> obtenerDevoluciones() {
        return service.obtenerDevoluciones();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id_devolucion}")
    public String eliminarDevolucion(@PathVariable(value = "id_devolucion")  Long id_devolucion){
        service.eliminarDevolucion(id_devolucion);
        return "Devolucion eliminada";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/actualizar/{id_devolucion}")
    public String actualizarDevolucion(@RequestBody Devoluciones devoluciones,@PathVariable(value = "id_devolucion") Long id_devolucion){
        devoluciones.setId_devolucion(id_devolucion);
        service.actualizarDevolucion(devoluciones);
        return "Devolucion actualizada";
    }
}
