package com.semillero.ejemplo.service.imp;

import ch.qos.logback.classic.pattern.DateConverter;
import com.semillero.ejemplo.entity.Membresia;
import com.semillero.ejemplo.entity.Ventas;
import com.semillero.ejemplo.repository.MembresiaRepository;
import com.semillero.ejemplo.repository.VentasRepository;
import com.semillero.ejemplo.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class VentasServiceImp implements VentasService {

    @Autowired
    private VentasRepository repository;
    @Override
    public Ventas addVenta(Ventas venta) {


        try{
            return repository.save(venta);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Ventas buscarVentaPorId(Long id_Venta) {
        try{
            Ventas venta = repository.findById(id_Venta).get();
            if(venta.getCactivacion().equals(true)){
                return venta;
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
    public List<Ventas> buscarVentaPorFecha(String fecha) {
        try{

            fecha=fecha.replace('-','/');
            List<Ventas> listado = repository.findByFecha(fecha);
            return listado;
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ventas> buscarPorRangoFecha(LocalDate fecha1, LocalDate fecha2) {

        try{
            List<Ventas> ventasFechas = repository.findByFechaBetween(fecha1,fecha2);
            return ventasFechas;
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    public LocalDate stringtoLocalDateTime(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        return LocalDate.parse(fecha, formatter);
    }

    @Override
    public List<Ventas> buscarTodos() {
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
    public void actualizarVenta(Ventas venta) {
        try{
            repository.save(venta);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
