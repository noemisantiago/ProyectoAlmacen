package com.semillero.ejemplo.service.imp;

import com.semillero.ejemplo.entity.Producto;
import com.semillero.ejemplo.persistence.ResponseProducto;
import com.semillero.ejemplo.repository.ProductoRepository;
import com.semillero.ejemplo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public Producto addProducto(Producto producto) {
        try{
            producto.setContenido(producto.getContenido().toUpperCase());
            producto.setNombre(producto.getNombre().toUpperCase());
            producto.setTipoUnidad(producto.getTipoUnidad().toUpperCase());

            producto.setCactivacion(true);
            return repository.save(producto);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Producto> buscarProduPorCat(Long idCategoria) {

        try{
            List<Producto> listProdu = repository.findByidCategoria(idCategoria);
            return listProdu;
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Producto buscarProduPorId(Long idProducto) {
        try{
            Producto produ = repository.findById(idProducto).get();

            if(produ.getCactivacion().equals(true)){
                return produ;
            }
            else{
                return null;
            }

        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ResponseProducto> buscarTodosProdu() {
        List<ResponseProducto> respProdu = new ArrayList<ResponseProducto>();
        List<Producto> producto = null;
        try{
            producto = repository.findAll();
            for(Producto rProducto : producto){
                ResponseProducto respProducto = new ResponseProducto();
                respProducto.setId_Producto(rProducto.getId_Producto());
                respProducto.setContenido(rProducto.getContenido());
                respProducto.setCactivacion(rProducto.getCactivacion());
                respProducto.setNombre(rProducto.getNombre());
                respProducto.setIdProveedor(rProducto.getIdProveedor());
                respProducto.setExistencia(rProducto.getExistencia());
                respProducto.setFCaducidad(rProducto.getFCaducidad());
                respProducto.setTipoUnidad(rProducto.getTipoUnidad());
                respProducto.setPrecioProveedor(rProducto.getPrecioProveedor());
                respProducto.setPrecioMayoreo(rProducto.getPrecioMayoreo());
                respProducto.setPrecioMenudeo(rProducto.getPrecioMenudeo());
                respProducto.setIdCategoria(rProducto.getIdCategoria());
                respProducto.setIdSucursal(rProducto.getIdSucursal());



                respProducto.setStatus(evaluarCaducidad(rProducto.getFCaducidad()));

                respProdu.add(respProducto);
            }



            return respProdu;
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }



    }

    public Long evaluarCaducidad(LocalDate fecha){

        try {
            LocalDate now = LocalDate.now();
            long diferencia = DAYS.between(now, fecha);
            return diferencia;
        }
        catch (Exception e){
            return null;
        }
    }
    @Override
    public String eliminarProduPorId(Long idProducto) {
        try{
            repository.deleteById(idProducto);
            return "Producto eliminado";
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void actualizarProducto(Producto producto) {
        try{
            producto.setContenido(producto.getContenido().toUpperCase());
            producto.setNombre(producto.getNombre().toUpperCase());
            producto.setTipoUnidad(producto.getTipoUnidad().toUpperCase());
            repository.save(producto);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
