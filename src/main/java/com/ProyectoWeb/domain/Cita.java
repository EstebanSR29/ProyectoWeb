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
@Table(name="cita")
public class Cita implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cita")
    private Long idCita;
    private String nombre;
    private String correo;
    private String fecha;
    private int telefono;
    private String comentarios;
    private boolean activo;
    
    public Cita() {
    }

    public Cita(Long idCita, String nombre, String correo, String fecha, int telefono, String comentarios, boolean activo) {
        this.idCita = idCita;
        this.nombre = nombre;
        this.correo = correo;
        this.fecha = fecha;
        this.telefono = telefono;
        this.comentarios = comentarios;
        this.activo = activo;
    }
    
}