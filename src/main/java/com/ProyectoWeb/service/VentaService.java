package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Venta;
import java.util.List;

public interface VentaService {
    
    public List<Venta> getVentas(boolean activos);
    
    public Venta getVenta (Venta venta);
    
    
    public void save(Venta venta);
    
    
    public void delete(Venta venta);
 
}
