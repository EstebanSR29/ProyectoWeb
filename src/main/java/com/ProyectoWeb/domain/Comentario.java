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
@Table(name="comentario")
public class Comentario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comentario")
    private Long idComentario;
    private String nombre;
    private String resena;
    private int puntuacion;
    private boolean activo;
    
    public Comentario() {
    }

    public Comentario(Long idComentario, String nombre, String resena, int puntuacion, boolean activo) {
        this.idComentario = idComentario;
        this.nombre = nombre;
        this.resena = resena;
        this.puntuacion = puntuacion;
        this.activo = activo;
    }

    
    
}