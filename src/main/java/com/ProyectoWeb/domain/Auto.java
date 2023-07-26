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
@Table(name="auto")
public class Auto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_auto")
    private Long idAuto;
    private String modelo;
    private String marca;
    private String imagen;
    private int precio;
    private boolean activo;
    
    public Auto() {
    }

    public Auto(Long idAuto, String modelo, String marca, String imagen, int precio, boolean activo) {
        this.idAuto = idAuto;
        this.modelo = modelo;
        this.marca = marca;
        this.imagen = imagen;
        this.precio = precio;
        this.activo = activo;
    }
}
