package com.semillero.ejemplo.service.imp;

import com.semillero.ejemplo.entity.RepVentas;
import com.semillero.ejemplo.repository.RepVentasRepository;
import com.semillero.ejemplo.service.RepVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepVentaServiceImp implements RepVentasService {

    @Autowired
    private RepVentasRepository repository;
    @Override
    public RepVentas addVenta(RepVentas repVenta) {
        try{
            return repository.save(repVenta);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RepVentas buscarVentaPorId(Long id_Venta) {
        try{
            RepVentas repVenta = repository.findById(id_Venta).get();
            if(repVenta.getCactivacion().equals(true)){
                return repVenta;
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
    public List<RepVentas> buscarVentaPorId_Producto(Long id_producto) {
        try{
            List<RepVentas> repVenta = repository.findByidProducto(id_producto);
            return repVenta;
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RepVentas> buscarTodos() {
        try{
            return repository.findAll();
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String eliminarVentaPorId(Long id_Venta) {
        try{
            repository.deleteById(id_Venta);
            return "Venta eliminada";

        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void actualizarVenta(RepVentas repventa) {
        try{
            repository.save(repventa);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
