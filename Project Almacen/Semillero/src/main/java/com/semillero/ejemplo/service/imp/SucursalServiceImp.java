package com.semillero.ejemplo.service.imp;


import com.semillero.ejemplo.entity.Sucursal;
import com.semillero.ejemplo.repository.SucursalRepository;
import com.semillero.ejemplo.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImp implements SucursalService {

    @Autowired
    private SucursalRepository repository;

    @Override
    public Sucursal addSucursal(Sucursal sucursal) {
        try {
            sucursal.setDireccion(sucursal.getDireccion().toUpperCase());
            sucursal.setEstado(sucursal.getEstado().toUpperCase());
            sucursal.setClvSuc(sucursal.getClvSuc().toUpperCase());

            sucursal.setCactivacion(true);

            return repository.save(sucursal);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Sucursal buscarporClaveSuc(String clv_suc) {
        try{
            Sucursal sucursal = repository.findByclvSuc(clv_suc.toUpperCase());
            if(sucursal.getCactivacion().equals(true)){
                return sucursal;
            }
            else{
                return null;
            }


        }catch (Exception e){
            System.out.println("Categoria no encontrada");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Sucursal> obtenerSucursales() {
        try{
            return repository.findAll();
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /*@Override
    public List<Sucursal> obtenerSucursales(){
        List<Sucursal> sucursales = repository.findAll(Sort.by(Sort.Direction.ASC,"id_sucursal"));
        return sucursales;

    }*/


    @Override
    public String eliminarSucursal(Long id_sucursal) {
        try {
            repository.deleteById(id_sucursal);
            return "Categoria eliminada";

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String actualizarSucursal(Sucursal sucursal) {

        try{
            sucursal.setDireccion(sucursal.getDireccion().toUpperCase());
            sucursal.setEstado(sucursal.getEstado().toUpperCase());
            sucursal.setClvSuc(sucursal.getClvSuc().toUpperCase());
            repository.save(sucursal);
            return "SUCURSAL ACTUALIZADA";
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }



    }




}
