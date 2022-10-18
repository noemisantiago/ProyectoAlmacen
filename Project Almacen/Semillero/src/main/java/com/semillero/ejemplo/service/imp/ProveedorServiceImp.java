package com.semillero.ejemplo.service.imp;


import com.semillero.ejemplo.entity.Proveedor;
import com.semillero.ejemplo.repository.ProveedorRepository;
import com.semillero.ejemplo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImp  implements ProveedorService {

    @Autowired
    private ProveedorRepository repository;
    @Override
    public Proveedor addProveedor(Proveedor proveedor) {
        try{
            proveedor.setNombreProveedor(proveedor.getNombreProveedor().toUpperCase());
            proveedor.setDireccion(proveedor.getDireccion().toUpperCase());
            proveedor.setCactivacion(true);
            return repository.save(proveedor);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Proveedor buscarPorNombre(String nombre_proveedor) {
        try{
            Proveedor provee = repository.findByNombreProveedor(nombre_proveedor.toUpperCase());
            if(provee.getCactivacion().equals(true)){
                return provee;
            }else{
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
    public List<Proveedor> buscarTodos() {
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
    public String eliminarProveedorPorId(Long id_proveedor) {
        try{
            repository.deleteById(id_proveedor);
            return "Proveedor eliminado";

        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void actualizarProveedorPorId(Proveedor proveedor) {
        try{
            proveedor.setNombreProveedor(proveedor.getNombreProveedor().toUpperCase());
            proveedor.setDireccion(proveedor.getDireccion().toUpperCase());
            repository.save(proveedor);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
