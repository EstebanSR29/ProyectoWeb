package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaDao extends JpaRepository <Cita,Long> {
    
}
