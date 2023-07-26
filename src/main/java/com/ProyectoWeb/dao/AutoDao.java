package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoDao extends JpaRepository <Auto,Long> {
    
}
