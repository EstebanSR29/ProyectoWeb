package com.ProyectoWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_venta")
    private Long idVenta;
    private String Accesorio;
    private String nombre;
    private int cantidad;
    private int precio;
    private int total;
    private boolean activo;

    public Venta() {
    }

    public Venta(Long idVenta, String Accesorio, String nombre, int cantidad, int precio, int total, boolean activo) {
        this.idVenta = idVenta;
        this.Accesorio = Accesorio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.activo = activo;
    }
    
}
