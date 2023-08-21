package com.ProyectoWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="factura2")
public class Factura2 implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private Long idFactura;
    private String nombre;
    private Date fecha;
    private double total;
      
    public Factura2() {
    }

    public Factura2(String nombre) {
        this.nombre = nombre;
        this.fecha = Calendar.getInstance().getTime();
    }    
}