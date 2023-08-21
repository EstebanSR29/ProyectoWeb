package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository <Factura,Long> {
    
}
