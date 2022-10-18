package com.semillero.ejemplo.service.imp;

import com.semillero.ejemplo.entity.Membresia;
import com.semillero.ejemplo.repository.MembresiaRepository;
import com.semillero.ejemplo.service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MembresiaServiceImp implements MembresiaService {

    @Autowired
    private MembresiaRepository repository;

    @Override
    public Membresia addMembresia(Membresia membresia) {
        try {
            membresia.setNombre_completo(membresia.getNombre_completo().toUpperCase());
            membresia.setTarjeta_c(membresia.getTarjeta_c().toUpperCase());



            LocalDateTime now = LocalDateTime.now();

            String dia = String.valueOf(now.getDayOfMonth());
            String mes = String.valueOf(now.getMonthValue());
            String año = String.valueOf((now.getYear()+1));

            membresia.setFecha_exp(LocalDate.parse(año + "-" + mes + "-" + dia));


            long fiveDigits = (long)Math.round((Math.random() * (9999 - 1000) + 1000));
            System.out.println(now.getYear() +"-"+ now.getMonthValue()+"-"+now.getDayOfMonth()+"-"+now.getHour()+"-"+now.getMinute()+"-"+now.getSecond()+"-"+fiveDigits);
            membresia.setClaveMembresia(now.getYear()+""+ String.format("%0" + 2 + "d", Integer.valueOf(now.getMonthValue()))+""+String.format("%0" + 2 + "d", Integer.valueOf(now.getDayOfMonth()))+""+String.format("%0" + 2 + "d", Integer.valueOf(now.getHour()))+""+String.format("%0" + 2 + "d", Integer.valueOf(now.getMinute()))+""+String.format("%0" + 2 + "d", Integer.valueOf(now.getSecond()))+""+fiveDigits);
            membresia.setCactivacion(true);
            return repository.save(membresia);

        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Membresia buscarPorClave(String clave_membresia) {
        try{
            Membresia member = repository.findByClaveMembresia(clave_membresia.toUpperCase());
            if(member.getCactivacion().equals(true)){
                return member;
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
    public List<Membresia> buscarTodos() {
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
    public String eliminarMembresiaPorClave(String clave_membresia) {
        try{
            repository.deleteByClaveMembresia(clave_membresia);
            return "Membresia eliminada";

        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public void actualizarMembresia(Membresia membresia) {

        try{
            membresia.setClaveMembresia(membresia.getClaveMembresia().toUpperCase());
            membresia.setNombre_completo(membresia.getNombre_completo().toUpperCase());
            membresia.setTarjeta_c(membresia.getTarjeta_c().toUpperCase());
            repository.save(membresia);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

}
