package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Accesorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccesorioDao extends JpaRepository <Accesorio,Long> {
    
}
