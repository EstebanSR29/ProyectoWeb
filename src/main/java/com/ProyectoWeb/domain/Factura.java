package com.ProyectoWeb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name="factura")
public class Factura implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private Long idFactura;
    private String nombre;
    private String correo;
    private String direccion;
    private int cedula;
    private int telefono;
    private int monto;
    private boolean activo;

    public Factura() {
    }

    public Factura(Long idFactura, String nombre, String correo, String direccion, int cedula, int telefono, int monto, boolean activo) {
        this.idFactura = idFactura;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.cedula = cedula;
        this.telefono = telefono;
        this.monto = monto;
        this.activo = activo;
    }
    
}
