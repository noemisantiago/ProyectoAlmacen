package com.semillero.ejemplo.service.imp;


import com.semillero.ejemplo.entity.Categoria_productos;
import com.semillero.ejemplo.entity.Membresia;
import com.semillero.ejemplo.repository.Categoria_productosRepository;
import com.semillero.ejemplo.service.Categoria_productosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Categoria_productosServiceImp implements Categoria_productosService {

    @Autowired
    private Categoria_productosRepository repository;

    @Override
    public Categoria_productos addCategoria(Categoria_productos categoria_productos) {
        try {
            categoria_productos.setCategoria(categoria_productos.getCategoria().toUpperCase());
            return repository.save(categoria_productos);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Categoria_productos buscarCategoriaporNombre(String categoria) {
        try{

            Categoria_productos categoria_productos = repository.findByCategoria(categoria.toUpperCase());

            if(categoria_productos.getCactivacion().equals(true)){
                return categoria_productos;
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
    public List<Categoria_productos> buscarCategorias() {
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
    public String eliminarCategoria(String categoria) {
        try {
            long cate = repository.deleteByCategoria(categoria);
            return "Categoria eliminada";

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

        @Override
        public String actualizarCategoria(Categoria_productos categoria_productos) {

            try{
                categoria_productos.setCategoria(categoria_productos.getCategoria().toUpperCase());

                repository.save(categoria_productos);
                return "CATEGORIA ACTUALIZADA";
            }catch(Exception e){
                System.out.println("Ha ocurrido un error");
                System.out.println(e.getMessage());
                e.printStackTrace();
                return null;
            }



        }

}
