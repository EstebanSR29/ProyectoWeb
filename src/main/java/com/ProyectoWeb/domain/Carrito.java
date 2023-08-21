package com.ProyectoWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="carrito")
public class Carrito implements Serializable {  
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_carrito")
    private Long idCarrito;
    private Long idFactura;
    private Long idAccesorio; 
    private String nombre;
    private int cantidad;
    private int precio;   
    
    public Carrito() {
    }

    public Carrito(Long idCarrito, Long idFactura, Long idAccesorio, String nombre, int cantidad, int precio) {
        this.idCarrito = idCarrito;
        this.idFactura = idFactura;
        this.idAccesorio = idAccesorio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Carrito(Long idFactura, Long idAccesorio, int precio, int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}