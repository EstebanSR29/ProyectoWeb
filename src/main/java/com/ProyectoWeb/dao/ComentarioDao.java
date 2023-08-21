package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioDao extends JpaRepository <Comentario,Long> {
    
}
