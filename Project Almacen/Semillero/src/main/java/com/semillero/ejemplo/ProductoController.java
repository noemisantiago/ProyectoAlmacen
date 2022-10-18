package com.semillero.ejemplo;

import com.semillero.ejemplo.entity.Producto;
import com.semillero.ejemplo.persistence.ResponseProducto;
import com.semillero.ejemplo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda/producto/")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @CrossOrigin(origins = "*")
    @PostMapping("add/")
    public Producto addProducto(@RequestBody Producto producto) {
        return service.addProducto(producto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/categoria/{idCategoria}")
    public List<Producto> buscarProducPorCat(@PathVariable(value = "idCategoria")  Long idCategoria) {
        return service.buscarProduPorCat(idCategoria);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar/idProdu/{idProducto}")
    public Producto buscarProductoPorId(@PathVariable(value = "idProducto")  Long idProducto) {
        return service.buscarProduPorId(idProducto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("listar")
    public List<ResponseProducto> buscarTodos() {
        return service.buscarTodosProdu();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{idProducto}")
    public String eliminarProduPorId(@PathVariable(value = "idProducto")  Long idProducto){
        service.eliminarProduPorId(idProducto);
        return "Producto eliminada";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/actualizar/{idProducto}")
    public String actualizarProdu(@RequestBody Producto producto,@PathVariable(value = "idProducto") Long idProducto){
        producto.setId_Producto(idProducto);
        service.actualizarProducto(producto);
        return "Producto actualizado";
    }


}
