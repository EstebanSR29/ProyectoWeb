package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.AccesorioDao;
import com.ProyectoWeb.domain.Accesorio;
import com.ProyectoWeb.service.AccesorioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccesorioServiceImpl implements AccesorioService {
    
    @Autowired
    private AccesorioDao accesorioDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Accesorio> getAccesorios(boolean activos) {
        var lista = accesorioDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;        
    }
    
    @Override
    @Transactional(readOnly = true)
    public Accesorio getAccesorio (Accesorio accesorio) {
        return accesorioDao.findById(accesorio.getIdAccesorio()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Accesorio accesorio) {
        accesorioDao.save(accesorio);
    }

    @Override
    @Transactional
    public void delete(Accesorio accesorio) {
        accesorioDao.delete(accesorio);
    }
}
