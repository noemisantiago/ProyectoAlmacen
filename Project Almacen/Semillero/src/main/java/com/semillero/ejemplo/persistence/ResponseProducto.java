package com.semillero.ejemplo.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class ResponseProducto {

    private Long id_Producto;
    private Long idCategoria;
    private String contenido;
    private Long idSucursal;
    private String tipoUnidad;
    private Long idProveedor;
    private Float precioProveedor;
    private Float precioMenudeo;
    private Float precioMayoreo;
    private LocalDate fCaducidad;
    private Long existencia;
    private String nombre;
    private Boolean cactivacion;

    private Long status;

}
