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
@Table(name="accesorio")
public class Accesorio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_accesorio")
    private Long idAccesorio;
    private String nombre;
    private String imagen;
    private int precio;
    private boolean activo;
    
    public Accesorio() {
    }

    public Accesorio(Long idAccesorio, String nombre, String imagen, int precio, boolean activo) {
        this.idAccesorio = idAccesorio;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.activo = activo;
    }

}
