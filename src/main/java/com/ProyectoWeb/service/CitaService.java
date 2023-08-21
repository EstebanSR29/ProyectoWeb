package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Cita;
import java.util.List;

public interface CitaService {
    
    public List<Cita> getCitas(boolean activos);
    
    public Cita getCita (Cita cita);
    
    
    public void save(Cita cita);
    
    
    public void delete(Cita cita);
 
}