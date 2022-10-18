package com.semillero.ejemplo.service.imp;

import com.semillero.ejemplo.entity.Membresia;
import com.semillero.ejemplo.entity.RolEmpleado;
import com.semillero.ejemplo.repository.RolEmpleadoRepository;
import com.semillero.ejemplo.service.RolEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolEmpleadoServiceImp implements RolEmpleadoService {
    @Autowired
    private  RolEmpleadoRepository repository;

    @Override
    public List<RolEmpleado> buscarTodos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
