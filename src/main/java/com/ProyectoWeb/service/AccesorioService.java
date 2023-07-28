package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Accesorio;
import java.util.List;

public interface AccesorioService {
    
    public List<Accesorio> getAccesorios(boolean activos);
    
    public Accesorio getAccesorio (Accesorio accesorio);
    
    
    public void save(Accesorio accesorio);
    
    
    public void delete(Accesorio accesorio);
 
}