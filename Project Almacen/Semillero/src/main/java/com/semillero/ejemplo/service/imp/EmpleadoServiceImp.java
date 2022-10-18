package com.semillero.ejemplo.service.imp;
import com.semillero.ejemplo.entity.Empleado;
import com.semillero.ejemplo.repository.EmpleadoRepository;
import com.semillero.ejemplo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public Empleado addEmpleado(Empleado empleado) {
        try {
            empleado.setNombre(empleado.getNombre().toUpperCase());
            empleado.setApe_p(empleado.getApe_p().toUpperCase());
            empleado.setApe_m(empleado.getApe_m().toUpperCase());
            empleado.setCactivacion(true);
            return repository.save(empleado);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Empleado buscarEmpleadoporClave(String clvUsuario) {
        try{
            Empleado empleado = repository.findByclvUsuario(clvUsuario.toUpperCase());

            if(empleado.getCactivacion().equals(true)){
                return empleado;
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
    public List<Empleado> obtenerEmpleados() {
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
    public String eliminarEmpleado(String clvUsuario) {
        try {
            repository.deleteByclvUsuario(clvUsuario);
            return "Empleado eliminado";

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String actualizarEmpleado(Empleado empleado) {

        try{
            empleado.setNombre(empleado.getNombre().toUpperCase());
            empleado.setApe_p(empleado.getApe_p().toUpperCase());
            empleado.setApe_m(empleado.getApe_m().toUpperCase());
            empleado.setPuesto(empleado.getPuesto());
            empleado.getId_sucursal();
            empleado.getClvUsuario();
            repository.save(empleado);
            return "Empleado Actualizado";
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
