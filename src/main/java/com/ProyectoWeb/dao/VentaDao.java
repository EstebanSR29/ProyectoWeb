package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDao extends JpaRepository <Venta,Long> {
    
}
