package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.CitaDao;
import com.ProyectoWeb.domain.Cita;
import com.ProyectoWeb.service.CitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements CitaService {
    
    @Autowired
    private CitaDao citaDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Cita> getCitas(boolean activos) {
        var lista = citaDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;        
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cita getCita (Cita cita) {
        return citaDao.findById(cita.getIdCita()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    @Transactional
    public void delete(Cita cita) {
        citaDao.delete(cita);
    }
}
