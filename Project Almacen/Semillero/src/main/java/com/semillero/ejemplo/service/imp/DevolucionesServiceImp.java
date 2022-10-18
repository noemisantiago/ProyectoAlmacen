package com.semillero.ejemplo.service.imp;


import com.semillero.ejemplo.entity.Devoluciones;
import com.semillero.ejemplo.entity.Ventas;
import com.semillero.ejemplo.repository.DevolucionesRepository;
import com.semillero.ejemplo.service.DevolucionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionesServiceImp implements DevolucionesService {

    @Autowired
    private DevolucionesRepository repository;

    @Override
    public Devoluciones addDevolucion(Devoluciones devoluciones) {
        try {
            devoluciones.setMotivo(devoluciones.getMotivo().toUpperCase());
            return repository.save(devoluciones);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Devoluciones buscarDevolucionporId(Long id_devolucion) {
        try{
            return repository.findById(id_devolucion).get();

        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Devoluciones> buscarDevByFecha(String fecha) {
        try{
            System.out.println(fecha);
            fecha=fecha.replace('-','/');
            System.out.println(fecha);
            List<Devoluciones> listado = repository.findByFecha(fecha);
            //List<Devoluciones> listado = (List<Devoluciones>) repository.findByFecha(fecha);
            return listado;

        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Devoluciones> obtenerDevoluciones() {
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
    public String eliminarDevolucion(Long id_devolucion) {
        try {
            repository.deleteById(id_devolucion);
            return "Devolución eliminada";

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String actualizarDevolucion(Devoluciones devoluciones) {

        try{
            devoluciones.getId_producto();
            devoluciones.getId_venta();
            devoluciones.getValor_devolucion();
            devoluciones.getMotivo();
            devoluciones.getCantidad();
            devoluciones.getId_sucursal();
            repository.save(devoluciones);
            return "Devolución actualizada";
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
